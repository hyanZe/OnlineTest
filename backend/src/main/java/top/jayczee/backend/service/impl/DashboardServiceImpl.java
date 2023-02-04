package top.jayczee.backend.service.impl;

import lombok.Setter;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jayczee.backend.service.DashboardService;
import top.jayczee.codegen.Tables;
import top.jayczee.codegen.tables.DeviceDataTable;
import top.jayczee.codegen.tables.daos.DeviceDataDao;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Setter(onMethod_ = @Autowired)
    private DeviceDataDao deviceDataDao;
    @Override
    public TotalSensorDataInfo sensorDataCount() {
        LocalDateTime startTime= LocalDate.now().atStartOfDay();
        LocalDateTime endTime=startTime.plusDays(1).minusNanos(1);
        DeviceDataTable ddt= Tables.DEVICE_DATA;
        TotalSensorDataInfo info=new TotalSensorDataInfo(0,0,0,0);
        Integer totalData=deviceDataDao
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
}
