/*
 * This file is generated by jOOQ.
 */
package top.jayczee.codegen.tables.records;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import top.jayczee.codegen.tables.DeviceInfoTable;
import top.jayczee.codegen.tables.interfaces.IDeviceInfo;


/**
 * 设备信息
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DeviceInfoRecord extends UpdatableRecordImpl<DeviceInfoRecord> implements Record4<Long, LocalDateTime, String, String>, IDeviceInfo {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>graduation.device_info.id</code>. 主键
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>graduation.device_info.id</code>. 主键
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>graduation.device_info.create_dt</code>. 创建日时(系统)
     */
    @Override
    public void setCreateDt(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>graduation.device_info.create_dt</code>. 创建日时(系统)
     */
    @Override
    public LocalDateTime getCreateDt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>graduation.device_info.ip</code>. ip地址
     */
    @Override
    public void setIp(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>graduation.device_info.ip</code>. ip地址
     */
    @Override
    public String getIp() {
        return (String) get(2);
    }

    /**
     * Setter for <code>graduation.device_info.device_name</code>. 设备名称
     */
    @Override
    public void setDeviceName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>graduation.device_info.device_name</code>. 设备名称
     */
    @Override
    public String getDeviceName() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, LocalDateTime, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, LocalDateTime, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return DeviceInfoTable.DEVICE_INFO.Id;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return DeviceInfoTable.DEVICE_INFO.CreateDt;
    }

    @Override
    public Field<String> field3() {
        return DeviceInfoTable.DEVICE_INFO.Ip;
    }

    @Override
    public Field<String> field4() {
        return DeviceInfoTable.DEVICE_INFO.DeviceName;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public LocalDateTime component2() {
        return getCreateDt();
    }

    @Override
    public String component3() {
        return getIp();
    }

    @Override
    public String component4() {
        return getDeviceName();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public LocalDateTime value2() {
        return getCreateDt();
    }

    @Override
    public String value3() {
        return getIp();
    }

    @Override
    public String value4() {
        return getDeviceName();
    }

    @Override
    public DeviceInfoRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public DeviceInfoRecord value2(LocalDateTime value) {
        setCreateDt(value);
        return this;
    }

    @Override
    public DeviceInfoRecord value3(String value) {
        setIp(value);
        return this;
    }

    @Override
    public DeviceInfoRecord value4(String value) {
        setDeviceName(value);
        return this;
    }

    @Override
    public DeviceInfoRecord values(Long value1, LocalDateTime value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IDeviceInfo from) {
        setId(from.getId());
        setCreateDt(from.getCreateDt());
        setIp(from.getIp());
        setDeviceName(from.getDeviceName());
    }

    @Override
    public <E extends IDeviceInfo> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DeviceInfoRecord
     */
    public DeviceInfoRecord() {
        super(DeviceInfoTable.DEVICE_INFO);
    }

    /**
     * Create a detached, initialised DeviceInfoRecord
     */
    public DeviceInfoRecord(Long id, LocalDateTime createDt, String ip, String deviceName) {
        super(DeviceInfoTable.DEVICE_INFO);

        setId(id);
        setCreateDt(createDt);
        setIp(ip);
        setDeviceName(deviceName);
    }
}