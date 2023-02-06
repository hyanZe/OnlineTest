package top.jayczee.backend.controller;

import io.swagger.annotations.ApiOperation;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jayczee.backend.pojo.R;
import top.jayczee.backend.service.DashboardService;

@RestController //将返回值序列化为json格式 // { "id":1,"ip":"2","deviceName":"3"}
public class DashboardController {
    @Setter(onMethod_ = @Autowired)
    private DashboardService dashboardService;

    @ApiOperation("传感器采集数据信息")
    @PostMapping("/auth/dashboard/sensor-data-count.json")
    public R<Object> totalSensorDataCount(){
        return R.okData(dashboardService.sensorDataCount());
    }

    @ApiOperation("传感器个数数据")
    @PostMapping("/auth/dashboard/sensor-count.json")
    public R<Object> totalSensorCount(){
        return R.okData(dashboardService.totalSensorCount());
    }

    @ApiOperation("平均元素浓度")
    @PostMapping("/auth/dashboard/average-data.json")
    public R<Object> averageData(){
        return null;
    }
}