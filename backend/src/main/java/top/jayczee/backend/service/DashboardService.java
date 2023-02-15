package top.jayczee.backend.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

public interface DashboardService {
    @Data
    @AllArgsConstructor
    class TotalSensorDataInfo{
        @Parameter(description = "累计采集数据量")
        private Integer dataCountTotal;
        @Parameter(description = "今日采集数据量")
        private Integer dataCountToday;
        @Parameter(description = "昨日采集数据量")
        private Integer dataCountLast;
        @Parameter(description = "异常数据量")
        private Integer dataCountError;
    }

    TotalSensorDataInfo sensorDataCount();

    /**
     * 传感器个数信息数据
     */
    @Data
    class TotalSensorCountInfo{
        private int phUsing;
        private int phTotal;
        @JsonProperty("pUsing")
        private int pUsing;
        @JsonProperty("pTotal")
        private int pTotal;
        private int airTempUsing;
        private int airTempTotal;
        private int baseUsing;
        private int baseTotal;
        @JsonProperty("nUsing")
        private int nUsing;
        @JsonProperty("nTotal")
        private int nTotal;
        @JsonProperty("kUsing")
        private int kUsing;
        @JsonProperty("kTotal")
        private int kTotal;
        private int airWetUsing;
        private int airWetTotal;
        private int baseTempUsing;
        private int baseTempTotal;
    }
    TotalSensorCountInfo totalSensorCount();
    @Getter
    @Setter
    class AverageDataSQL{
        private String dataType;
        private BigDecimal data;
    }
    /**
     * 平均元素浓度信息
     */
    @Getter
    @Setter
    class AverageDataInfo{
        private BigDecimal ph;
        private BigDecimal p;
        private BigDecimal n;
        private BigDecimal k;
    }

    AverageDataInfo averageData(Long deviceId);
    @Getter
    @Setter
    class DeviceConditionData{
        private String deviceName;
        private Integer sensorCountUsing;
        private Integer sensorCountTotal;
    }

    List<DeviceConditionData> deviceCondList();
}
