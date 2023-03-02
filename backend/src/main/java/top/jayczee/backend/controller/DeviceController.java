package top.jayczee.backend.controller;

import io.swagger.annotations.ApiOperation;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.jayczee.backend.pojo.R;
import top.jayczee.backend.service.DeviceService;
import top.jayczee.backend.util.EmptySugar;

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
    public R<Object> deviceList() {
        return R.okData(deviceService.deviceList());
    }

    @ApiOperation("设备传感器数据类型列表")
    @PostMapping("/auth/device/device-data-type-list.json")
    public R<Object> deviceSensorList(@RequestParam Long deviceId) {
        return R.okData(deviceService.deviceDataTypeList(deviceId));
    }

    @ApiOperation("设备传感器列表")
    @PostMapping("/auth/device/device-sensor-list.json")
    public R<Object> deviceSensorInfoList(@RequestParam Long deviceId,
                                          @RequestParam String dataType) {
        return R.okData(deviceService.deviceSensorInfoList(deviceId, dataType));
    }

    @ApiOperation("指定传感器数据列表")
    @PostMapping("/auth/device/sensor-data-list.json")
    public R<Object> sensorDataList(@RequestParam Long deviceId,
                                    @RequestParam Long sensorId) {
        return R.okData(deviceService.sensorDataList(deviceId, sensorId));
    }

    @ApiOperation("设备数据列表")
    @PostMapping("/auth/device/data-logs.json")
    public R<Object> dataLogs(@RequestParam Long deviceId) {
        return R.okData(deviceService.deviceDataLogs(deviceId));
    }

    @ApiOperation("更新数据异常状态")
    @PostMapping("/auth/device/update-err.json")
    public R<Object> updateDataErrorState(@RequestParam Long dataId,
                                          @RequestParam(required = false) Boolean state) {
        if (state == null) state = false;
        deviceService.updateErrorState(dataId, state);
        return R.ok();
    }
    @ApiOperation("初始化设备配置数据")
    @PostMapping("/auth/device/init-config.json")
    public R<Object> initDeviceConfig(@RequestParam Long deviceId){
        deviceService.initDeviceConfig(deviceId);
        return R.ok();
    }
    @ApiOperation("更新设备指定配置数据")
    @PostMapping("/auth/device/update-config.json")
    public R<Object> updateConfig(@RequestParam Long deviceId,
                                  @RequestParam String key,
                                  @RequestParam String val){
        deviceService.updateConfig(deviceId,key,val);
        return R.ok();
    }
    @ApiOperation("加载设备阈值数据")
    @PostMapping("/auth/device/threshold.json")
    public R<Object> deviceThreshold(@RequestParam Long deviceId){
        return R.okData(deviceService.deviceThreshold(deviceId));
    }
    @ApiOperation("设备详情")
    @PostMapping("/auth/device/detail-info.json")
    public R<Object> deviceDetailInfo(@RequestParam Long deviceId){
        return R.okData(deviceService.deviceDetail(deviceId));
    }
}
