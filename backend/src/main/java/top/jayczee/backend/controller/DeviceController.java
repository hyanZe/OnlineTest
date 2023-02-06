package top.jayczee.backend.controller;

import io.swagger.annotations.ApiOperation;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
