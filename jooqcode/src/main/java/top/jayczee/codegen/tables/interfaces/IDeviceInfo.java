/*
 * This file is generated by jOOQ.
 */
package top.jayczee.codegen.tables.interfaces;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 设备信息
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IDeviceInfo extends Serializable {

    /**
     * Setter for <code>graduation.device_info.id</code>. 主键
     */
    public void setId(Long value);

    /**
     * Getter for <code>graduation.device_info.id</code>. 主键
     */
    public Long getId();

    /**
     * Setter for <code>graduation.device_info.create_dt</code>. 创建日时(系统)
     */
    public void setCreateDt(LocalDateTime value);

    /**
     * Getter for <code>graduation.device_info.create_dt</code>. 创建日时(系统)
     */
    public LocalDateTime getCreateDt();

    /**
     * Setter for <code>graduation.device_info.ip</code>. ip地址
     */
    public void setIp(String value);

    /**
     * Getter for <code>graduation.device_info.ip</code>. ip地址
     */
    public String getIp();

    /**
     * Setter for <code>graduation.device_info.device_name</code>. 设备名称
     */
    public void setDeviceName(String value);

    /**
     * Getter for <code>graduation.device_info.device_name</code>. 设备名称
     */
    public String getDeviceName();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IDeviceInfo
     */
    public void from(IDeviceInfo from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IDeviceInfo
     */
    public <E extends IDeviceInfo> E into(E into);
}
