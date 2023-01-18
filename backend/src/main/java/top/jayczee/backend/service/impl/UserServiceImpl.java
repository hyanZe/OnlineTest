package top.jayczee.backend.service.impl;

import lombok.Setter;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jayczee.backend.service.UserService;
import top.jayczee.codegen.Tables;
import top.jayczee.codegen.tables.UserInfoTable;
import top.jayczee.codegen.tables.daos.UserInfoDao;
import top.jayczee.codegen.tables.pojos.UserInfo;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Setter(onMethod_ = {@Autowired})
    private UserInfoDao userInfoDao;

    @Override
    public Long checkLogin(LoginInfo loginInfo) {
        UserInfoTable uit=Tables.USER_INFO;
        UserInfo userInfo = userInfoDao //Result == List
                .ctx()
                .select()
                .from(uit)
                .where(uit.LoginName.eq(loginInfo.getUsername()))
                .and(uit.Password.eq(loginInfo.getPassword()))
                .fetchOneInto(UserInfo.class);
        if (userInfo == null)
            return -1L;
        return userInfo.getId();
    }
}


