CREATE TABLE `user_info`
(
    `id`         BIGINT(20)   NOT NULL COMMENT '主键',
    `create_dt`  DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日时(系统)',
    `login_name` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '账号',
    `password` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '密码',
    `salt` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '盐',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';

