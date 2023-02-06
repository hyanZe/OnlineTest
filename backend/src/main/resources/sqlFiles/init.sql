CREATE TABLE `user_info`
(
    `id`         BIGINT(20)   NOT NULL COMMENT '主键',
    `create_dt`  DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日时(系统)',
    `login_name` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '账号',
    `password` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '密码',
    `salt` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '盐',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';

CREATE TABLE `device_info`
(
    `id`         BIGINT(20)   NOT NULL COMMENT '主键',
    `create_dt`  DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日时(系统)',
    `ip` VARCHAR(200) NOT NULL DEFAULT '' COMMENT 'ip地址',
    `device_name` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '设备名称',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备信息';

CREATE TABLE `sensor_info`
(
    `id`         BIGINT(20)   NOT NULL COMMENT '主键',
    `create_dt`  DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日时(系统)',
    `sensor_name` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '传感器名称',
    `device_id` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '设备ID',
    `data_type` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '传感器类型',
    `is_running` TINYINT(1) NOT NULL DEFAULT '' COMMENT '是否打开',
    `is_delete` TINYINT(1) NOT NULL DEFAULT '' COMMENT '是否已删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='传感器信息';

CREATE TABLE `device_data`
(
    `id`         BIGINT(20)   NOT NULL COMMENT '主键',
    `create_dt`  DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日时(系统)',
    `ip` VARCHAR(200) NOT NULL DEFAULT '' COMMENT 'ip地址',
    `device_id` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '设备ID',
    `sensor_id` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '传感器ID',
    `data` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '数据值',
    `data_type` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '数据类型',
    `is_error` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否异常',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据记录';

