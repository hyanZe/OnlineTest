/*
 * This file is generated by jOOQ.
 */
package top.jayczee.codegen.tables.pojos;


import java.time.LocalDateTime;

import top.jayczee.codegen.tables.interfaces.ISensorInfo;


/**
 * 传感器信息
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SensorInfo implements ISensorInfo {

    private static final long serialVersionUID = 1L;

    private Long          id;
    private LocalDateTime createDt;
    private String        sensorName;
    private Long          deviceId;
    private Boolean       isRunning;

    public SensorInfo() {}

    public SensorInfo(ISensorInfo value) {
        this.id = value.getId();
        this.createDt = value.getCreateDt();
        this.sensorName = value.getSensorName();
        this.deviceId = value.getDeviceId();
        this.isRunning = value.getIsRunning();
    }

    public SensorInfo(
        Long          id,
        LocalDateTime createDt,
        String        sensorName,
        Long          deviceId,
        Boolean       isRunning
    ) {
        this.id = id;
        this.createDt = createDt;
        this.sensorName = sensorName;
        this.deviceId = deviceId;
        this.isRunning = isRunning;
    }

    /**
     * Getter for <code>graduation.sensor_info.id</code>. 主键
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>graduation.sensor_info.id</code>. 主键
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>graduation.sensor_info.create_dt</code>. 创建日时(系统)
     */
    @Override
    public LocalDateTime getCreateDt() {
        return this.createDt;
    }

    /**
     * Setter for <code>graduation.sensor_info.create_dt</code>. 创建日时(系统)
     */
    @Override
    public void setCreateDt(LocalDateTime createDt) {
        this.createDt = createDt;
    }

    /**
     * Getter for <code>graduation.sensor_info.sensor_name</code>. 传感器名称
     */
    @Override
    public String getSensorName() {
        return this.sensorName;
    }

    /**
     * Setter for <code>graduation.sensor_info.sensor_name</code>. 传感器名称
     */
    @Override
    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    /**
     * Getter for <code>graduation.sensor_info.device_id</code>. 设备ID
     */
    @Override
    public Long getDeviceId() {
        return this.deviceId;
    }

    /**
     * Setter for <code>graduation.sensor_info.device_id</code>. 设备ID
     */
    @Override
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Getter for <code>graduation.sensor_info.is_running</code>. 是否打开
     */
    @Override
    public Boolean getIsRunning() {
        return this.isRunning;
    }

    /**
     * Setter for <code>graduation.sensor_info.is_running</code>. 是否打开
     */
    @Override
    public void setIsRunning(Boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SensorInfo (");

        sb.append(id);
        sb.append(", ").append(createDt);
        sb.append(", ").append(sensorName);
        sb.append(", ").append(deviceId);
        sb.append(", ").append(isRunning);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ISensorInfo from) {
        setId(from.getId());
        setCreateDt(from.getCreateDt());
        setSensorName(from.getSensorName());
        setDeviceId(from.getDeviceId());
        setIsRunning(from.getIsRunning());
    }

    @Override
    public <E extends ISensorInfo> E into(E into) {
        into.from(this);
        return into;
    }
}
