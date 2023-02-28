package commonTest;

import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jayczee.backend.BackendApplication;
import top.jayczee.backend.service.DeviceService;

@SpringBootTest(classes = BackendApplication.class)
public class CommonTest {
    @Setter(onMethod_ = {@Autowired})
    private DeviceService deviceService;
    @Test
    void test(){
        deviceService.initDeviceConfig(0L);
    }
}
