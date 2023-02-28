package top.jayczee.backend.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import top.jayczee.codegen.tables.pojos.DeviceConfig;
import top.jayczee.codegen.tables.pojos.DeviceData;
import top.jayczee.codegen.tables.pojos.SensorInfo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DeviceService {

    default Map<String,String> DeviceThresholdConfigMap(){
        return new HashMap<String,String>(){{
            put("phThreshold","8");
            put("pThreshold","8");
            put("airTempThreshold","8");
            put("baseThreshold","8");
            put("nThreshold","8");
            put("kThreshold","8");
            put("airWetThreshold","8");
            put("baseTempThreshold","8");
        }};
    }

    /**
     * 设备信息
     */
    @Setter
    @Getter
    class DeviceInfo {
        private Long id;
        private String ip;
        private String deviceName;
    }

    /**
     * 设备列表
     */
    List<DeviceInfo> deviceList();

    /**
     * 设备传感器列表
     */
    List<String> deviceDataTypeList(Long deviceId);


    List<SensorInfo> deviceSensorInfoList(Long deviceId, String dataType);

    @Data
    class SensorChartData {
        List<String> createDt;
        List<BigDecimal> data;
    }

    SensorChartData sensorDataList(Long deviceId, Long sensorId);
    @Data
    class DataLogItem{
        private Long id;
        private LocalDateTime createDt;
        private String dataType;
        private String data;
        private Boolean isError;
    }

    List<DataLogItem> deviceDataLogs(Long deviceId);

    void updateErrorState(Long dataId, Boolean state);

    /**
     * 创建设备时初始化设备配置
     * @param deviceId
     */
    void initDeviceConfig(Long deviceId);

    void updateConfig(Long deviceId,String key,String val);
    @Data
    class ThresholdData{
        private BigDecimal phThreshold;
        @JsonProperty("pThreshold")
        private BigDecimal pThreshold;
        private BigDecimal airTempThreshold;
        private BigDecimal baseThreshold;
        @JsonProperty("nThreshold")
        private BigDecimal nThreshold;
        @JsonProperty("kThreshold")
        private BigDecimal kThreshold;
        private BigDecimal airWetThreshold;
        private BigDecimal baseTempThreshold;

        public void setAllEmpty(){
            this.phThreshold=BigDecimal.ZERO;
            this.pThreshold=BigDecimal.ZERO;
            this.airTempThreshold=BigDecimal.ZERO;
            this.baseThreshold=BigDecimal.ZERO;
            this.nThreshold=BigDecimal.ZERO;
            this.kThreshold=BigDecimal.ZERO;
            this.airWetThreshold=BigDecimal.ZERO;
            this.baseTempThreshold=BigDecimal.ZERO;
        }
    }

    ThresholdData deviceThreshold(Long deviceId);
}

//写controller  作用：给前端调用
//写Service层的Interface 作用：定义要实现的方法
//写Service层的实现类 implements 作用：方法的具体实现