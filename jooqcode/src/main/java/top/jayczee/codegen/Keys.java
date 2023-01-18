/*
 * This file is generated by jOOQ.
 */
package top.jayczee.codegen;


import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import top.jayczee.codegen.tables.UserInfoTable;
import top.jayczee.codegen.tables.records.UserInfoRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * graduation.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<UserInfoRecord> KEY_USER_INFO_PRIMARY = Internal.createUniqueKey(UserInfoTable.USER_INFO, DSL.name("KEY_user_info_PRIMARY"), new TableField[] { UserInfoTable.USER_INFO.Id }, true);
}