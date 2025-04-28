package com.fairychar.security.core.manager;

import lombok.AllArgsConstructor;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;

import java.util.List;
import java.util.Map;

/**
 * redis session管理器,管理用户登录状态
 *
 * @author chiyo <br>
 */
@AllArgsConstructor
public class SessionManager {

    private final FindByIndexNameSessionRepository sessionRepository;


    /**
     * 清除用户登录态
     *
     * @param principalKey 登录的username
     */
    public void logout(String principalKey) {
        Map<String, Session> sessionMap = this.sessionRepository.findByPrincipalName(principalKey);
        sessionMap.values().stream().map(Session::getId).forEach(this.sessionRepository::deleteById);
    }


    /**
     * 清除多个用户登录态
     *
     * @param principalKeys 登录的username List
     */
    public void multiLogout(List<String> principalKeys) {
        for (String principalKey : principalKeys) {
            this.logout(principalKey);
        }
    }
}
