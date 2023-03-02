package top.jayczee.backend.service.impl;

import io.swagger.models.auth.In;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jayczee.backend.service.DeviceService;
import top.jayczee.backend.util.SnowFlaskIdUtil;
import top.jayczee.codegen.Tables;
import top.jayczee.codegen.tables.DeviceConfigTable;
import top.jayczee.codegen.tables.DeviceDataTable;
import top.jayczee.codegen.tables.DeviceInfoTable;
import top.jayczee.codegen.tables.SensorInfoTable;
import top.jayczee.codegen.tables.daos.DeviceConfigDao;
import top.jayczee.codegen.tables.daos.DeviceDataDao;
import top.jayczee.codegen.tables.daos.DeviceInfoDao;
import top.jayczee.codegen.tables.daos.SensorInfoDao;
import top.jayczee.codegen.tables.pojos.DeviceConfig;
import top.jayczee.codegen.tables.pojos.DeviceData;
import top.jayczee.codegen.tables.pojos.DeviceInfo;
import top.jayczee.codegen.tables.pojos.SensorInfo;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Jayczee
 * @since 2023/2/6
 */

@Service
@Slf4j
public class DeviceServiceImpl implements DeviceService {
    @Setter(onMethod_ = {@Autowired})
    private DeviceInfoDao deviceInfoDao;
    @Setter(onMethod_ = {@Autowired})
    private SensorInfoDao sensorInfoDao;
    @Setter(onMethod_ = {@Autowired})
    private DeviceDataDao deviceDataDao;
    @Setter(onMethod_ = {@Autowired})
    private DeviceConfigDao deviceConfigDao;

    @Override
    public List<DeviceInfo> deviceList() {
        DeviceInfoTable dit = Tables.DEVICE_INFO;
        List<DeviceInfo> deviceInfos = deviceInfoDao
                .ctx()
                .select(dit.Id,
                        dit.Ip,
                        dit.DeviceName)
                .from(dit)
                .fetchInto(DeviceInfo.class);
        return deviceInfos;
    }

    @Override
    public List<String> deviceDataTypeList(Long deviceId) {
        SensorInfoTable sit = Tables.SENSOR_INFO;
        return sensorInfoDao
                .ctx()
                .selectDistinct(sit.DataType)
                .from(sit)
                .where(sit.DeviceId.eq(deviceId))
                .and(sit.IsDelete.eq(false))
                .fetchInto(String.class);
    }

    @Override
    public List<SensorInfo> deviceSensorInfoList(Long deviceId, String dataType) {
        SensorInfoTable sit = Tables.SENSOR_INFO;
        return sensorInfoDao
                .ctx()
                .selectFrom(sit)
                .where(sit.IsDelete.eq(false))
                .and(sit.DeviceId.eq(deviceId))
                .and(sit.DataType.eq(dataType))
                .fetchInto(SensorInfo.class);
    }

    @Override
    public SensorChartData sensorDataList(Long deviceId, Long sensorId) {
        DeviceDataTable ddt = Tables.DEVICE_DATA;
        List<DeviceData> deviceDataList = deviceDataDao
                .ctx()
                .selectFrom(ddt)
                .where(ddt.DeviceId.eq(deviceId))
                .and(ddt.SensorId.eq(sensorId))
                .orderBy(ddt.Id.desc())
                .limit(7)
                .fetchInto(DeviceData.class);
        SensorChartData data = new SensorChartData();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        data.setCreateDt(deviceDataList.stream().map(DeviceData::getCreateDt).map(formatter::format).collect(Collectors.toList()));
        Collections.reverse(data.getCreateDt());
        data.setData(deviceDataList.stream().map(DeviceData::getData).map(BigDecimal::new).collect(Collectors.toList()));
        return data;
    }

    @Override
    public List<DataLogItem> deviceDataLogs(Long deviceId) {
        DeviceDataTable ddt = Tables.DEVICE_DATA;
        return deviceDataDao
                .ctx()
                .selectFrom(ddt)
                .where(ddt.DeviceId.eq(deviceId))
                .orderBy(ddt.Id.desc())
                .fetchInto(DataLogItem.class);
    }

    @Override
    public void updateErrorState(Long dataId, Boolean state) {
        DeviceDataTable ddt = Tables.DEVICE_DATA;
        deviceDataDao
                .ctx()
                .update(ddt)
                .set(ddt.IsError, state)
                .where(ddt.Id.eq(dataId))
                .execute();
    }

    @Override
    public void initDeviceConfig(Long deviceId) {
        Map<String, String> thresholdMap = DeviceThresholdConfigMap();
        List<DeviceConfig> confList = new ArrayList<>();
        DeviceConfigTable dct = Tables.DEVICE_CONFIG;
        List<DeviceConfig> deviceConfigs = deviceConfigDao
                .ctx()
                .select(dct.Id)
                .from(dct)
                .where(dct.IsDelete.eq(false))
                .and(dct.DeviceId.eq(deviceId))
                .fetchInto(DeviceConfig.class);
        if (deviceConfigs.size() > 0) throw new IllegalStateException("该设备数据已初始化");
        for (Map.Entry<String, String> entry : thresholdMap.entrySet()) {
            DeviceConfig config = new DeviceConfig();
            config.setId(SnowFlaskIdUtil.getId());
            config.setConfigKey(entry.getKey());
            config.setConfigVal(entry.getValue());
            config.setDeviceId(deviceId);
            config.setIsDelete(false);
            config.setCreateDt(LocalDateTime.now());
            confList.add(config);
        }
        deviceConfigDao.insert(confList);
    }

    @Override
    public void updateConfig(Long deviceId, String key, String val) {
        DeviceConfigTable dct = Tables.DEVICE_CONFIG;
        deviceConfigDao
                .ctx()
                .update(dct)
                .set(dct.ConfigVal, val)
                .where(dct.DeviceId.eq(deviceId))
                .and(dct.ConfigKey.eq(key))
                .and(dct.IsDelete.eq(false))
                .execute();
    }

    @Override
    public ThresholdData deviceThreshold(Long deviceId){
        DeviceConfigTable dct = Tables.DEVICE_CONFIG;
        List<DeviceConfig> deviceConfigs = deviceConfigDao
                .ctx()
                .selectFrom(dct)
                .where(dct.DeviceId.eq(deviceId))
                .and(dct.IsDelete.eq(false))
                .fetchInto(DeviceConfig.class);
        ThresholdData data = new ThresholdData();
        data.setAllEmpty();
        Set<String> keySet = DeviceThresholdConfigMap().keySet();
        for (DeviceConfig config : deviceConfigs) {
            if (keySet.contains(config.getConfigKey())){
                try {
                    log.info(data.toString());
                    String key = config.getConfigKey();
                    log.info("获取对象字段:"+key);
                    Field field = data.getClass().getDeclaredField(key);
                    field.setAccessible(true);
                    field.set(data,new BigDecimal(config.getConfigVal()));
                }catch (NoSuchFieldException e){
                    log.error("反射获取字段失败");
                }catch (IllegalAccessException ex){
                    log.error("无字段访问权限");
                }
            }
        }
        return data;
    }

    @Override
    public DeviceDetailInfo deviceDetail(Long deviceId) {
        SensorInfoTable sit = Tables.SENSOR_INFO;
        Result<Record2<Integer, String>> fetch = sensorInfoDao
                .ctx()
                .select(DSL.count(sit.Id),
                        sit.DataType)
                .where(sit.DeviceId.eq(deviceId))
                .and(sit.IsDelete.eq(false))
                .groupBy(sit.DataType)
                .fetch();
        DeviceDetailInfo info = new DeviceDetailInfo();
        for(Record2<Integer,String> record:fetch){
            switch (record.value2()){
                case "ph":info.setPhSensorCount(record.value1());info.setTotalSensorCount(info.getTotalSensorCount() + record.value1());break;
                case "p":info.setPSensorCount(record.value1());info.setTotalSensorCount(info.getTotalSensorCount() + record.value1());break;
                case "airTemp":info.setAirTempSensorCount(record.value1());info.setTotalSensorCount(info.getTotalSensorCount() + record.value1());break;
                case "base":info.setBaseSensorCount(record.value1());info.setTotalSensorCount(info.getTotalSensorCount() + record.value1());break;
                case "n":info.setNSensorCount(record.value1());info.setTotalSensorCount(info.getTotalSensorCount() + record.value1());break;
                case "k":info.setKSensorCount(record.value1());info.setTotalSensorCount(info.getTotalSensorCount() + record.value1());break;
                case "airWet":info.setAirWetSensorCount(record.value1());info.setTotalSensorCount(info.getTotalSensorCount() + record.value1());break;
                case "baseTemp":info.setBaseTempSensorCount(record.value1());info.setTotalSensorCount(info.getTotalSensorCount() + record.value1());break;
            }
        }
        top.jayczee.codegen.tables.pojos.DeviceInfo deviceInfo = deviceInfoDao.fetchOneById(deviceId);
        info.setDeviceName(deviceInfo.getDeviceName());
        info.setIp(deviceInfo.getIp());
        info.setCreateDt(deviceInfo.getCreateDt());
        return info;
    }
}
