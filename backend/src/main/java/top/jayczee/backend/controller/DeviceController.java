package top.jayczee.backend.controller;

import io.swagger.annotations.ApiOperation;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.jayczee.backend.pojo.R;
import top.jayczee.backend.service.DeviceService;

/**
 * @author Jayczee
 * @since 2023/2/6
 */

@RestController
public class DeviceController {
    @Setter(onMethod_ = {@Autowired})
    private DeviceService deviceService;
    @ApiOperation("设备列表")
    @PostMapping("/auth/device/device-list.json")
    public R<Object> deviceList(){
        return R.okData(deviceService.deviceList());
    }

    @ApiOperation("设备传感器数据类型列表")
    @PostMapping("/auth/device/device-data-type-list.json")
    public R<Object> deviceSensorList(@RequestParam Long deviceId){
        return R.okData(deviceService.deviceDataTypeList(deviceId));
    }
    @ApiOperation("设备传感器列表")
    @PostMapping("/auth/device/device-sensor-list.json")
    public R<Object> deviceSensorInfoList(@RequestParam Long deviceId,
                                          @RequestParam String dataType){
        return R.okData(deviceService.deviceSensorInfoList(deviceId,dataType));
    }
    @ApiOperation("指定传感器数据列表")
    @PostMapping("/auth/device/sensor-data-list.json")
    public R<Object> sensorDataList(@RequestParam Long deviceId,
                                    @RequestParam Long sensorId){
        return R.okData(deviceService.sensorDataList(deviceId,sensorId));
    }
}
