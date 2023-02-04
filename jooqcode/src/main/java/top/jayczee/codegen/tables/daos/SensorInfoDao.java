/*
 * This file is generated by jOOQ.
 */
package top.jayczee.codegen.tables.daos;


import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.jayczee.codegen.tables.SensorInfoTable;
import top.jayczee.codegen.tables.pojos.SensorInfo;
import top.jayczee.codegen.tables.records.SensorInfoRecord;


/**
 * 传感器信息
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class SensorInfoDao extends DAOImpl<SensorInfoRecord, SensorInfo, Long> {

    /**
     * Create a new SensorInfoDao without any configuration
     */
    public SensorInfoDao() {
        super(SensorInfoTable.SENSOR_INFO, SensorInfo.class);
    }

    /**
     * Create a new SensorInfoDao with an attached configuration
     */
    @Autowired
    public SensorInfoDao(Configuration configuration) {
        super(SensorInfoTable.SENSOR_INFO, SensorInfo.class, configuration);
    }

    @Override
    public Long getId(SensorInfo object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<SensorInfo> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(SensorInfoTable.SENSOR_INFO.Id, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<SensorInfo> fetchById(Long... values) {
        return fetch(SensorInfoTable.SENSOR_INFO.Id, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public SensorInfo fetchOneById(Long value) {
        return fetchOne(SensorInfoTable.SENSOR_INFO.Id, value);
    }

    /**
     * Fetch records that have <code>create_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<SensorInfo> fetchRangeOfCreateDt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(SensorInfoTable.SENSOR_INFO.CreateDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_dt IN (values)</code>
     */
    public List<SensorInfo> fetchByCreateDt(LocalDateTime... values) {
        return fetch(SensorInfoTable.SENSOR_INFO.CreateDt, values);
    }

    /**
     * Fetch records that have <code>sensor_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<SensorInfo> fetchRangeOfSensorName(String lowerInclusive, String upperInclusive) {
        return fetchRange(SensorInfoTable.SENSOR_INFO.SensorName, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sensor_name IN (values)</code>
     */
    public List<SensorInfo> fetchBySensorName(String... values) {
        return fetch(SensorInfoTable.SENSOR_INFO.SensorName, values);
    }

    /**
     * Fetch records that have <code>device_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<SensorInfo> fetchRangeOfDeviceId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(SensorInfoTable.SENSOR_INFO.DeviceId, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>device_id IN (values)</code>
     */
    public List<SensorInfo> fetchByDeviceId(Long... values) {
        return fetch(SensorInfoTable.SENSOR_INFO.DeviceId, values);
    }

    /**
     * Fetch records that have <code>is_running BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<SensorInfo> fetchRangeOfIsRunning(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(SensorInfoTable.SENSOR_INFO.IsRunning, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>is_running IN (values)</code>
     */
    public List<SensorInfo> fetchByIsRunning(Boolean... values) {
        return fetch(SensorInfoTable.SENSOR_INFO.IsRunning, values);
    }
}
