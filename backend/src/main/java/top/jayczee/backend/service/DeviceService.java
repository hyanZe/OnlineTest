package top.jayczee.backend.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import top.jayczee.codegen.tables.pojos.DeviceData;
import top.jayczee.codegen.tables.pojos.SensorInfo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface DeviceService {

    /**
     * 设备信息
     */
    @Setter
    @Getter
    class DeviceInfo{
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
    class SensorChartData{
        List<String> createDt;
        List<BigDecimal> data;
    }

    SensorChartData sensorDataList(Long deviceId, Long sensorId);
}

//写controller  作用：给前端调用
//写Service层的Interface 作用：定义要实现的方法
//写Service层的实现类 implements 作用：方法的具体实现