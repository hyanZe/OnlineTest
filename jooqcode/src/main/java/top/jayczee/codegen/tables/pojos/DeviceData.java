/*
 * This file is generated by jOOQ.
 */
package top.jayczee.codegen.tables.pojos;


import java.time.LocalDateTime;

import top.jayczee.codegen.tables.interfaces.IDeviceData;


/**
 * 数据记录
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DeviceData implements IDeviceData {

    private static final long serialVersionUID = 1L;

    private Long          id;
    private LocalDateTime createDt;
    private String        ip;
    private Long          deviceId;
    private Long          sensorId;
    private String        data;
    private String        dataType;
    private Boolean       isError;

    public DeviceData() {}

    public DeviceData(IDeviceData value) {
        this.id = value.getId();
        this.createDt = value.getCreateDt();
        this.ip = value.getIp();
        this.deviceId = value.getDeviceId();
        this.sensorId = value.getSensorId();
        this.data = value.getData();
        this.dataType = value.getDataType();
        this.isError = value.getIsError();
    }

    public DeviceData(
        Long          id,
        LocalDateTime createDt,
        String        ip,
        Long          deviceId,
        Long          sensorId,
        String        data,
        String        dataType,
        Boolean       isError
    ) {
        this.id = id;
        this.createDt = createDt;
        this.ip = ip;
        this.deviceId = deviceId;
        this.sensorId = sensorId;
        this.data = data;
        this.dataType = dataType;
        this.isError = isError;
    }

    /**
     * Getter for <code>graduation.device_data.id</code>. 主键
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>graduation.device_data.id</code>. 主键
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>graduation.device_data.create_dt</code>. 创建日时(系统)
     */
    @Override
    public LocalDateTime getCreateDt() {
        return this.createDt;
    }

    /**
     * Setter for <code>graduation.device_data.create_dt</code>. 创建日时(系统)
     */
    @Override
    public void setCreateDt(LocalDateTime createDt) {
        this.createDt = createDt;
    }

    /**
     * Getter for <code>graduation.device_data.ip</code>. ip地址
     */
    @Override
    public String getIp() {
        return this.ip;
    }

    /**
     * Setter for <code>graduation.device_data.ip</code>. ip地址
     */
    @Override
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Getter for <code>graduation.device_data.device_id</code>. 设备ID
     */
    @Override
    public Long getDeviceId() {
        return this.deviceId;
    }

    /**
     * Setter for <code>graduation.device_data.device_id</code>. 设备ID
     */
    @Override
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Getter for <code>graduation.device_data.sensor_id</code>. 传感器ID
     */
    @Override
    public Long getSensorId() {
        return this.sensorId;
    }

    /**
     * Setter for <code>graduation.device_data.sensor_id</code>. 传感器ID
     */
    @Override
    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * Getter for <code>graduation.device_data.data</code>. 数据值
     */
    @Override
    public String getData() {
        return this.data;
    }

    /**
     * Setter for <code>graduation.device_data.data</code>. 数据值
     */
    @Override
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Getter for <code>graduation.device_data.data_type</code>. 数据类型
     */
    @Override
    public String getDataType() {
        return this.dataType;
    }

    /**
     * Setter for <code>graduation.device_data.data_type</code>. 数据类型
     */
    @Override
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * Getter for <code>graduation.device_data.is_error</code>. 是否异常
     */
    @Override
    public Boolean getIsError() {
        return this.isError;
    }

    /**
     * Setter for <code>graduation.device_data.is_error</code>. 是否异常
     */
    @Override
    public void setIsError(Boolean isError) {
        this.isError = isError;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DeviceData (");

        sb.append(id);
        sb.append(", ").append(createDt);
        sb.append(", ").append(ip);
        sb.append(", ").append(deviceId);
        sb.append(", ").append(sensorId);
        sb.append(", ").append(data);
        sb.append(", ").append(dataType);
        sb.append(", ").append(isError);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IDeviceData from) {
        setId(from.getId());
        setCreateDt(from.getCreateDt());
        setIp(from.getIp());
        setDeviceId(from.getDeviceId());
        setSensorId(from.getSensorId());
        setData(from.getData());
        setDataType(from.getDataType());
        setIsError(from.getIsError());
    }

    @Override
    public <E extends IDeviceData> E into(E into) {
        into.from(this);
        return into;
    }
}
