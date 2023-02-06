package top.jayczee.backend.service.impl;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jayczee.backend.service.DeviceService;
import top.jayczee.codegen.Tables;
import top.jayczee.codegen.tables.DeviceInfoTable;
import top.jayczee.codegen.tables.daos.DeviceInfoDao;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author Jayczee
 * @since 2023/2/6
 */

@Service
public class DeviceServiceImpl implements DeviceService {
    @Setter(onMethod_ = {@Autowired})
    private DeviceInfoDao deviceInfoDao;

    @Override
    public List<DeviceInfo> deviceList() {
        DeviceInfoTable dit= Tables.DEVICE_INFO;
        List<DeviceInfo> deviceInfos = deviceInfoDao
                .ctx()
                .select(dit.Id,
                        dit.Ip,
                        dit.DeviceName)
                .from(dit)
                .fetchInto(DeviceInfo.class);
        return deviceInfos;
    }
}
