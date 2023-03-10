/*
 * This file is generated by jOOQ.
 */
package top.jayczee.codegen;


import top.jayczee.codegen.tables.DeviceConfigTable;
import top.jayczee.codegen.tables.DeviceDataTable;
import top.jayczee.codegen.tables.DeviceInfoTable;
import top.jayczee.codegen.tables.SensorInfoTable;
import top.jayczee.codegen.tables.UserInfoTable;


/**
 * Convenience access to all tables in graduation.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * 设备配置表
     */
    public static final DeviceConfigTable DEVICE_CONFIG = DeviceConfigTable.DEVICE_CONFIG;

    /**
     * 数据记录
     */
    public static final DeviceDataTable DEVICE_DATA = DeviceDataTable.DEVICE_DATA;

    /**
     * 设备信息
     */
    public static final DeviceInfoTable DEVICE_INFO = DeviceInfoTable.DEVICE_INFO;

    /**
     * 传感器信息
     */
    public static final SensorInfoTable SENSOR_INFO = SensorInfoTable.SENSOR_INFO;

    /**
     * 用户信息
     */
    public static final UserInfoTable USER_INFO = UserInfoTable.USER_INFO;
}
