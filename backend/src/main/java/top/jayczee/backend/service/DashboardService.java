package top.jayczee.backend.service;

import lombok.AllArgsConstructor;
import lombok.Data;

public interface DashboardService {
    @Data
    @AllArgsConstructor
    class TotalSensorDataInfo{
        private Integer dataCountTotal;
        private Integer dataCountToday;
        private Integer dataCountLast;
        private Integer dataCountError;
    }

    TotalSensorDataInfo sensorDataCount();
}
