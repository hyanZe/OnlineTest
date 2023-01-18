package top.jayczee.backend.listener;

import cn.dev33.satoken.listener.SaTokenListener;
import cn.dev33.satoken.stp.SaLoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liuxing
 * @since 2022-09-01
 */
@Component
@Slf4j
public class NewSaTokenListener implements SaTokenListener {
    /** 每次登录时触发 */
    @Override
    public void doLogin(String loginType, Object loginId, String tokenValue, SaLoginModel loginModel) {
        log.info("用户【"+loginId+":"+tokenValue+"】已登录");
    }

    /** 每次注销时触发 */
    @Override
    public void doLogout(String loginType, Object loginId, String tokenValue) {
        log.info("用户【"+loginId+":"+tokenValue+"】已注销");
    }

    /** 每次被踢下线时触发 */
    @Override
    public void doKickout(String loginType, Object loginId, String tokenValue) {
        log.info("用户【"+loginId+":"+tokenValue+"】被踢下线");
    }

    /** 每次被顶下线时触发 */
    @Override
    public void doReplaced(String loginType, Object loginId, String tokenValue) {
        log.info("用户【"+loginId+":"+tokenValue+"】被顶下线");
    }

    /** 每次被封禁时触发 */
    @Override
    public void doDisable(String loginType, Object loginId, long disableTime) {
        log.info("用户【"+loginId+"】被封禁");
    }

    /** 每次被解封时触发 */
    @Override
    public void doUntieDisable(String loginType, Object loginId) {
        log.info("用户【"+loginId+"】被解封");
    }

    /** 每次创建Session时触发 */
    @Override
    public void doCreateSession(String id) {
        log.info("用户【"+id+"】创建Session");
    }

    /** 每次注销Session时触发 */
    @Override
    public void doLogoutSession(String id) {
        log.info("用户【"+id+"】注销Session");
    }
}
