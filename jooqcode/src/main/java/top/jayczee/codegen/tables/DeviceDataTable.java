/*
 * This file is generated by jOOQ.
 */
package top.jayczee.codegen.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import top.jayczee.codegen.Graduation;
import top.jayczee.codegen.Keys;
import top.jayczee.codegen.tables.records.DeviceDataRecord;


/**
 * 数据记录
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DeviceDataTable extends TableImpl<DeviceDataRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>graduation.device_data</code>
     */
    public static final DeviceDataTable DEVICE_DATA = new DeviceDataTable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DeviceDataRecord> getRecordType() {
        return DeviceDataRecord.class;
    }

    /**
     * The column <code>graduation.device_data.id</code>. 主键
     */
    public final TableField<DeviceDataRecord, Long> Id = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "主键");

    /**
     * The column <code>graduation.device_data.create_dt</code>. 创建日时(系统)
     */
    public final TableField<DeviceDataRecord, LocalDateTime> CreateDt = createField(DSL.name("create_dt"), SQLDataType.LOCALDATETIME(3).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP(3)", SQLDataType.LOCALDATETIME)), this, "创建日时(系统)");

    /**
     * The column <code>graduation.device_data.ip</code>. ip地址
     */
    public final TableField<DeviceDataRecord, String> Ip = createField(DSL.name("ip"), SQLDataType.VARCHAR(200).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "ip地址");

    /**
     * The column <code>graduation.device_data.device_id</code>. 设备ID
     */
    public final TableField<DeviceDataRecord, Long> DeviceId = createField(DSL.name("device_id"), SQLDataType.BIGINT.nullable(false).defaultValue(DSL.inline("0", SQLDataType.BIGINT)), this, "设备ID");

    /**
     * The column <code>graduation.device_data.sensor_id</code>. 传感器ID
     */
    public final TableField<DeviceDataRecord, Long> SensorId = createField(DSL.name("sensor_id"), SQLDataType.BIGINT.nullable(false).defaultValue(DSL.inline("0", SQLDataType.BIGINT)), this, "传感器ID");

    /**
     * The column <code>graduation.device_data.data</code>. 数据值
     */
    public final TableField<DeviceDataRecord, String> Data = createField(DSL.name("data"), SQLDataType.VARCHAR(200).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "数据值");

    /**
     * The column <code>graduation.device_data.data_type</code>. 数据类型
     */
    public final TableField<DeviceDataRecord, String> DataType = createField(DSL.name("data_type"), SQLDataType.VARCHAR(200).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "数据类型");

    /**
     * The column <code>graduation.device_data.is_error</code>. 是否异常
     */
    public final TableField<DeviceDataRecord, Boolean> IsError = createField(DSL.name("is_error"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.inline("0", SQLDataType.BOOLEAN)), this, "是否异常");

    private DeviceDataTable(Name alias, Table<DeviceDataRecord> aliased) {
        this(alias, aliased, null);
    }

    private DeviceDataTable(Name alias, Table<DeviceDataRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("数据记录"), TableOptions.table());
    }

    /**
     * Create an aliased <code>graduation.device_data</code> table reference
     */
    public DeviceDataTable(String alias) {
        this(DSL.name(alias), DEVICE_DATA);
    }

    /**
     * Create an aliased <code>graduation.device_data</code> table reference
     */
    public DeviceDataTable(Name alias) {
        this(alias, DEVICE_DATA);
    }

    /**
     * Create a <code>graduation.device_data</code> table reference
     */
    public DeviceDataTable() {
        this(DSL.name("device_data"), null);
    }

    public <O extends Record> DeviceDataTable(Table<O> child, ForeignKey<O, DeviceDataRecord> key) {
        super(child, key, DEVICE_DATA);
    }

    @Override
    public Schema getSchema() {
        return Graduation.GRADUATION;
    }

    @Override
    public UniqueKey<DeviceDataRecord> getPrimaryKey() {
        return Keys.KEY_DEVICE_DATA_PRIMARY;
    }

    @Override
    public List<UniqueKey<DeviceDataRecord>> getKeys() {
        return Arrays.<UniqueKey<DeviceDataRecord>>asList(Keys.KEY_DEVICE_DATA_PRIMARY);
    }

    @Override
    public DeviceDataTable as(String alias) {
        return new DeviceDataTable(DSL.name(alias), this);
    }

    @Override
    public DeviceDataTable as(Name alias) {
        return new DeviceDataTable(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DeviceDataTable rename(String name) {
        return new DeviceDataTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DeviceDataTable rename(Name name) {
        return new DeviceDataTable(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, LocalDateTime, String, Long, Long, String, String, Boolean> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}