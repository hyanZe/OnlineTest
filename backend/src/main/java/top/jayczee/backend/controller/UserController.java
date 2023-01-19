package top.jayczee.backend.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.jayczee.backend.pojo.R;
import top.jayczee.backend.service.UserService;
import top.jayczee.backend.service.UserService.*;
import top.jayczee.backend.util.EmptySugar;

import javax.validation.Valid;


/**
 * @author liuxing
 * @since 2022-08-19
 */
@RestController
@Api(value = "用户接口", tags = {"用户接口"})
public class UserController {
    @Setter(onMethod_ = {@Autowired})
    private UserService userService;
    @ApiOperation("登录接口")
    @PostMapping("/user/login.json")
    public R<Boolean> login(@RequestBody @Valid LoginInfo loginInfo){
        Long userId= userService.checkLogin(loginInfo);
        if (userId == -1L){
            return R.ng("用户名或密码错误");
        }else{
            StpUtil.login(userId);
            SaSession session = StpUtil.getSession();
            session.set("id",userId);
            return R.ok("登录成功");
        }
    }
    @ApiOperation("注册接口")
    @PostMapping("/user/register.json")
    public R<?> register(@RequestBody @Valid LoginInfo loginInfo){
        Long userId=userService.register(loginInfo);
        if (userId > 0)
            return R.ok();
        return R.ng();
    }
}
