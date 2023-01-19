package top.jayczee.backend.service;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface UserService {
    @Data
    class LoginInfo{
        @NotEmpty(message = "用户名不能为空")
        private String username;
        @NotEmpty(message = "密码不能为空")
        private String password;
    }
    Long checkLogin(LoginInfo loginInfo);

    Long register(LoginInfo loginInfo);
}
