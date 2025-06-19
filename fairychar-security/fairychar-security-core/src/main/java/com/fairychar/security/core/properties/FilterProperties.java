package com.fairychar.security.core.properties;

import com.fairychar.security.core.auth.IJsonLoginRequest;
import com.fairychar.security.core.pojo.request.SimpleJsonLoginRequest;
import lombok.Data;

import java.util.Collections;
import java.util.Set;

/**
 * 拦截器配置
 *
 * @author chiyo <br>
 */
@Data
public class FilterProperties {
    /**
     * 菜单拦截器
     */
    private ApiPermissionFilterProperties apiPermission = new ApiPermissionFilterProperties();
    /**
     * 验证码拦截器
     */
    private VerifyCodeFilterProperties verifyCode = new VerifyCodeFilterProperties();
    /**
     * 登录参数体配置
     */
    private JsonLoginFilterProperties login = new JsonLoginFilterProperties();

    @Data
    public static class JsonLoginFilterProperties {
        private Class<? extends IJsonLoginRequest> loginClass = SimpleJsonLoginRequest.class;
    }

    @Data
    public static class VerifyCodeFilterProperties {
        private boolean enable;
        /**
         * <pre>忽略拦截的url</pre>
         * 使用了{@link org.springframework.util.AntPathMatcher}匹配,可以使用复杂模糊匹配,例如<br>
         * "/api/**","/index/hi"
         */
        private Set<String> verifyUrls = Collections.emptySet();
    }

    @Data
    public static class ApiPermissionFilterProperties {
        private boolean enable;
        /**
         * 忽略的路径
         */
        private Set<String> ignorePaths = Collections.emptySet();
    }
}
