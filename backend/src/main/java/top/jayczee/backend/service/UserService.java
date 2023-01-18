package top.jayczee.backend.service;

import lombok.Data;

public interface UserService {
    @Data
    class LoginInfo{
        private String username;
        private String password;
    }
    Long checkLogin(LoginInfo loginInfo);
}
