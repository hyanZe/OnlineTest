package top.jayczee.backend.config;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    /**
     * 拦截器 负责请求的登录校验 权限校验等......
     * 设置需要校验是否登录的接口的路由
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaRouteInterceptor(((saRequest, saResponse, o) -> {
                    SaRouter.match("/auth/**", r -> StpUtil.checkLogin());
                })));
    }
}
