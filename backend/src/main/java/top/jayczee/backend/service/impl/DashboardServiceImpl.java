package top.jayczee.backend.service.impl;

import lombok.Setter;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jayczee.backend.enums.SensorDataType;
import top.jayczee.backend.service.DashboardService;
import top.jayczee.codegen.Tables;
import top.jayczee.codegen.tables.DeviceDataTable;
import top.jayczee.codegen.tables.SensorInfoTable;
import top.jayczee.codegen.tables.daos.DeviceDataDao;
import top.jayczee.codegen.tables.daos.SensorInfoDao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Setter(onMethod_ = @Autowired)
    private DeviceDataDao deviceDataDao;
    @Setter(onMethod_ = @Autowired)
    private SensorInfoDao sensorInfoDao;

    @Override
    public TotalSensorDataInfo sensorDataCount() {
        LocalDateTime startTime = LocalDate.now().atStartOfDay();
        LocalDateTime endTime = startTime.plusDays(1).minusNanos(1);
        DeviceDataTable ddt = Tables.DEVICE_DATA;
        TotalSensorDataInfo info = new TotalSensorDataInfo(0, 0, 0, 0);
        Integer totalData = deviceDataDao
                .ctx()
                .select(DSL.count(ddt.Id))
                .from(ddt)
                .fetchOneInto(Integer.class);
        info.setDataCountTotal(totalData);
        Integer dataToday = deviceDataDao
                .ctx()
                .select(DSL.count(ddt.Id))
                .from(ddt)
                .where(ddt.CreateDt.ge(startTime).and(ddt.CreateDt.le(endTime)))
                .fetchOneInto(Integer.class);
        info.setDataCountToday(dataToday);
        Integer dataLast = deviceDataDao
                .ctx()
                .select(DSL.count(ddt.Id))
                .from(ddt)
                .where(ddt.CreateDt.ge(startTime.minusDays(1)).and(ddt.CreateDt.le(endTime.minusDays(1))))
                .fetchOneInto(Integer.class);
        info.setDataCountLast(dataLast);
        Integer dataError = deviceDataDao
                .ctx()
                .select(DSL.count(ddt.Id))
                .from(ddt)
                .where(ddt.IsError)
                .fetchOneInto(Integer.class);
        info.setDataCountError(dataError);
        return info;
    }

    @Override
    public TotalSensorCountInfo totalSensorCount() {
        SensorInfoTable sit = Tables.SENSOR_INFO;
        TotalSensorCountInfo info = new TotalSensorCountInfo();
        Map<String, Integer> resultMap = sensorInfoDao
                .ctx()
                .select(sit.DataType,
                        DSL.count(sit.Id))
                .from(sit)
                .where(sit.IsDelete.eq(false))
                .groupBy(sit.DataType)
                .fetchMap(sit.DataType, DSL.count(sit.Id));
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            switch (entry.getKey()) {
                case "ph":
                    info.setPhTotal(info.getPhTotal() + 1);
                    break;
                case "p":
                    info.setPTotal(info.getPTotal() + 1);
                    break;
                case "airTemp":
                    info.setAirTempTotal(info.getAirTempTotal() + 1);
                    break;
                case "base":
                    info.setBaseTotal(info.getBaseTotal() + 1);
                    break;
                case "n":
                    info.setNTotal(info.getNTotal() + 1);
                    break;
                case "k":
                    info.setKTotal(info.getKTotal() + 1);
                    break;
                case "airWet":
                    info.setAirWetTotal(info.getAirWetTotal() + 1);
                    break;
                case "baseTemp":
                    info.setBaseTempTotal(info.getBaseTempTotal() + 1);
                    break;
            }
        }
        Map<String, Integer> resultMapRunning = sensorInfoDao
                .ctx()
                .select(sit.DataType,
                        DSL.count(sit.Id))
                .from(sit)
                .where(sit.IsDelete.eq(false))
                .and(sit.IsRunning)
                .groupBy(sit.DataType)
                .fetchMap(sit.DataType, DSL.count(sit.Id));
        for (Map.Entry<String, Integer> entry : resultMapRunning.entrySet()) {
            switch (entry.getKey()) {
                case "ph":
                    info.setPhUsing(info.getPhUsing() + 1);
                    break;
                case "p":
                    info.setPUsing(info.getPUsing() + 1);
                    break;
                case "airTemp":
                    info.setAirTempUsing(info.getAirTempUsing() + 1);
                    break;
                case "base":
                    info.setBaseUsing(info.getBaseUsing() + 1);
                    break;
                case "n":
                    info.setNUsing(info.getNUsing() + 1);
                    break;
                case "k":
                    info.setKUsing(info.getKUsing() + 1);
                    break;
                case "airWet":
                    info.setAirWetUsing(info.getAirWetUsing() + 1);
                    break;
                case "baseTemp":
                    info.setBaseTempUsing(info.getBaseTempUsing() + 1);
                    break;
            }
        }
        return info;
    }

    @Override
    public AverageDataInfo averageData(Long deviceId) {
        DeviceDataTable ddt=Tables.DEVICE_DATA;
        List<AverageDataSQL> list = deviceDataDao
                .ctx()
                .select(ddt.DataType,
                        DSL.avg(DSL.cast(ddt.Data, BigDecimal.class)).as("data"))
                .from(ddt)
                .where(ddt.DeviceId.eq(deviceId))
                .and(ddt.IsError.eq(false))
                .and(ddt.DataType.in(SensorDataType.PH.getCode(), SensorDataType.P.getCode(), SensorDataType.N.getCode(), SensorDataType.K.getCode()))
                .groupBy(ddt.DataType)
                .fetchInto(AverageDataSQL.class);

        AverageDataInfo averageDataInfo = new AverageDataInfo();
        averageDataInfo.setPh(BigDecimal.ZERO);
        averageDataInfo.setP(BigDecimal.ZERO);
        averageDataInfo.setN(BigDecimal.ZERO);
        averageDataInfo.setK(BigDecimal.ZERO);

        for (AverageDataSQL info:list){
            switch (info.getDataType()){
                case "ph":averageDataInfo.setPh(info.getData());break;
                case "p":averageDataInfo.setP(info.getData());break;
                case "n":averageDataInfo.setN(info.getData());break;
                case "k":averageDataInfo.setK(info.getData());break;
            }
        }
        return averageDataInfo;
    }
}
