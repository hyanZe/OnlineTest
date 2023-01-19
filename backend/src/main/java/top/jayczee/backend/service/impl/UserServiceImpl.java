package top.jayczee.backend.service.impl;

import lombok.Setter;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jayczee.backend.pojo.R;
import top.jayczee.backend.service.UserService;
import top.jayczee.backend.util.SnowFlaskIdUtil;
import top.jayczee.codegen.Tables;
import top.jayczee.codegen.tables.UserInfoTable;
import top.jayczee.codegen.tables.daos.UserInfoDao;
import top.jayczee.codegen.tables.pojos.UserInfo;

import java.time.LocalDateTime;
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

    @Override
    public Long register(LoginInfo loginInfo) {
        UserInfoTable uit=Tables.USER_INFO;
        String username=loginInfo.getUsername();
        String password=loginInfo.getPassword();
        //1.搜索数据库中是否有相同的用户名
        Integer count=userInfoDao
                .ctx()
                .select(DSL.count(uit.LoginName))
                .from(uit)
                .where(uit.LoginName.eq(username))
                .fetchOneInto(Integer.class);
        if (count > 0){
            throw new IllegalArgumentException("用户名已被注册");
        }
        UserInfo userInfo=new UserInfo();
        userInfo.setLoginName(username);
        userInfo.setPassword(password);
        userInfo.setCreateDt(LocalDateTime.now());
        Long userId= SnowFlaskIdUtil.getId();
        userInfo.setId(userId);
        userInfoDao.insert(userInfo);
        return userId;
    }
}


