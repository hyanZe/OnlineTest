package top.jayczee.backend.service;

import lombok.Setter;

import java.util.List;

public interface DeviceService {
    @Setter
    class DeviceInfo{
        private Long id;
        private String ip;
        private String deviceName;
    }
    List<DeviceInfo> deviceList();
}

//写controller  作用：给前端调用
//写Service层的Interface 作用：定义要实现的方法
//写Service层的实现类 implements 作用：方法的具体实现