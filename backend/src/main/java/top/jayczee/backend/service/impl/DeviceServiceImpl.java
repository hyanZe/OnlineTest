package top.jayczee.backend.service.impl;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jayczee.backend.service.DeviceService;
import top.jayczee.codegen.Tables;
import top.jayczee.codegen.tables.DeviceDataTable;
import top.jayczee.codegen.tables.DeviceInfoTable;
import top.jayczee.codegen.tables.SensorInfoTable;
import top.jayczee.codegen.tables.daos.DeviceDataDao;
import top.jayczee.codegen.tables.daos.DeviceInfoDao;
import top.jayczee.codegen.tables.daos.SensorInfoDao;
import top.jayczee.codegen.tables.pojos.DeviceData;
import top.jayczee.codegen.tables.pojos.SensorInfo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>TODO</p>
 *
 * @author Jayczee
 * @since 2023/2/6
 */

@Service
public class DeviceServiceImpl implements DeviceService {
    @Setter(onMethod_ = {@Autowired})
    private DeviceInfoDao deviceInfoDao;
    @Setter(onMethod_ = {@Autowired})
    private SensorInfoDao sensorInfoDao;
    @Setter(onMethod_ = {@Autowired})
    private DeviceDataDao deviceDataDao;
    @Override
    public List<DeviceInfo> deviceList() {
        DeviceInfoTable dit= Tables.DEVICE_INFO;
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
        SensorInfoTable sit=Tables.SENSOR_INFO;
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
        SensorInfoTable sit=Tables.SENSOR_INFO;
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
}
