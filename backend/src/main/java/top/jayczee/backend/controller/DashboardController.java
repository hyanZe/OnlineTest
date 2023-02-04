package top.jayczee.backend.controller;

import io.swagger.annotations.ApiOperation;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jayczee.backend.pojo.R;
import top.jayczee.backend.service.DashboardService;

@RestController
public class DashboardController {
    @Setter(onMethod_ = @Autowired)
    private DashboardService dashboardService;

    @ApiOperation("传感器采集数据信息")
    @PostMapping("/auth/dashboard/sensor-data-count.json")
    public R<Object> totalSensorDataCount(){
        return R.okData(dashboardService.sensorDataCount());
    }
}