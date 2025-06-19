package com.fairychar.security.boot.configurer;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.fairychar.security.core.auth.IJsonLoginRequest;
import com.fairychar.security.core.auth.filter.ApiPermissionFilter;
import com.fairychar.security.core.auth.filter.JsonAuthenticationFilter;
import com.fairychar.security.core.auth.filter.VerifyCodeFilter;
import com.fairychar.security.core.auth.strategy.JsonInvalidSessionStrategy;
import com.fairychar.security.core.auth.strategy.JsonSessionExpiredStrategy;
import com.fairychar.security.core.beans.login.IPasswordDecrypt;
import com.fairychar.security.core.beans.login.IUsernameDecrypt;
import com.fairychar.security.core.manager.RedisTypeSessionManager;
import com.fairychar.security.core.mybatis.handler.SecurityAuditObjectHandler;
import com.fairychar.security.core.mybatis.handler.SecurityContextTenantHandler;
import com.fairychar.security.core.properties.AuditProperties;
import com.fairychar.security.core.properties.FairycharSecurityProperties;
import com.fairychar.security.core.properties.FilterProperties;
import com.fairychar.security.core.properties.TenantProperties;
import com.fairychar.security.core.verify.ICodeVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.config.SessionRepositoryCustomizer;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * 安全认证功能配置
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties({FairycharSecurityProperties.class, RedisProperties.class})
@AutoConfigureAfter(CommonBeansConfiguration.class)
@EnableWebSecurity
public class SecurityAutoConfigurer {


    @Configuration
    @EnableConfigurationProperties({FairycharSecurityProperties.class, RedisProperties.class})
    @ConditionalOnProperty(value = "fairychar.security.token-type", havingValue = "redis", matchIfMissing = true)
    protected static class RedisSessionConfiguration {
        @Autowired
        private FairycharSecurityProperties fairycharSecurityProperties;
        @Autowired
        private AuthenticationSuccessHandler authenticationSuccessHandler;
        @Autowired
        private AuthenticationFailureHandler authenticationFailureHandler;
        @Autowired
        private AuthenticationEntryPoint authenticationEntryPoint;
        @Autowired
        private AccessDeniedHandler accessDeniedHandler;
        @Autowired
        private InvalidSessionStrategy invalidSessionStrategy;
        @Autowired
        private FindByIndexNameSessionRepository indexNameSessionRepository;
        @Autowired
        private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;
        @Autowired(required = false)
        private IUsernameDecrypt usernameDecrypt;
        @Autowired(required = false)
        private IPasswordDecrypt passwordDecrypt;
        @Autowired(required = false)
        private VerifyCodeFilter verifyCodeFilter;
        @Autowired
        private LogoutSuccessHandler logoutSuccessHandler;
        @Autowired
        private ObjectMapper objectMapper;

        @Bean
        RedisTypeSessionManager sessionManager() {
            return new RedisTypeSessionManager(this.indexNameSessionRepository);
        }

        /**
         * <pre>redis session database重定向</pre>
         * 当redisConnectionFactory不为Jedis和Lettuce时,RedisSessionRepository无法配置到redisProperties<br>
         * 指定的db,需要手动定制指向
         *
         * @param redisProperties
         * @return {@link SessionRepositoryCustomizer}<{@link RedisIndexedSessionRepository}>
         */
        @Bean
        @ConditionalOnMissingBean(value = {LettuceConnectionFactory.class, JedisConnectionFactory.class, SessionRepositoryCustomizer.class})
        SessionRepositoryCustomizer<RedisIndexedSessionRepository> reWriteDatabaseCustomizer(RedisProperties redisProperties) {
            return sessionRepository -> sessionRepository.setDatabase(redisProperties.getDatabase());
        }

        @Bean
        public SessionRegistry springSessionBackedSessionRegistry() {
            return new SpringSessionBackedSessionRegistry(this.indexNameSessionRepository);
        }


        @Bean
        @ConditionalOnMissingBean
        HttpSessionIdResolver httpSessionIdResolver() {
            return new HeaderHttpSessionIdResolver(this.fairycharSecurityProperties.getStandard().getTokenHeaderName());
        }

        @Bean
        @ConditionalOnMissingBean(JsonAuthenticationFilter.class)
        JsonAuthenticationFilter jsonAuthenticationFilter(AuthenticationManager authenticationManager) throws Exception {
            Class<? extends IJsonLoginRequest> loginClass = this.fairycharSecurityProperties.getStandard().getFilter().getLogin().getLoginClass();
            JsonAuthenticationFilter filter = new JsonAuthenticationFilter<>(this.objectMapper, this.usernameDecrypt, this.passwordDecrypt, loginClass);
            filter.setAuthenticationManager(authenticationManager);
            filter.setFilterProcessesUrl(this.fairycharSecurityProperties.getUrl().getLogin());
            filter.setAuthenticationSuccessHandler(this.authenticationSuccessHandler);
            filter.setAuthenticationFailureHandler(this.authenticationFailureHandler);
            ConcurrentSessionControlAuthenticationStrategy concurrentSessionControlAuthenticationStrategy =
                    new ConcurrentSessionControlAuthenticationStrategy(this.springSessionBackedSessionRegistry());
            concurrentSessionControlAuthenticationStrategy.setMaximumSessions(this.fairycharSecurityProperties.getStandard().getMaxSession());
            filter.setSessionAuthenticationStrategy(concurrentSessionControlAuthenticationStrategy);
            filter.setSecurityContextRepository(new HttpSessionSecurityContextRepository());
            return filter;
        }

        @Bean
        @ConditionalOnMissingBean
        SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
            return new JsonSessionExpiredStrategy(this.indexNameSessionRepository, this.objectMapper);
        }


        @Bean
        @ConditionalOnMissingBean
        InvalidSessionStrategy simpleInvalidSessionStrategy() {
            return new JsonInvalidSessionStrategy(this.objectMapper);
        }


        @Bean
        @ConditionalOnProperty(value = "fairychar.security.standard.filter.verifyCode.enable", havingValue = "true")
        VerifyCodeFilter verifyCodeFilter(ICodeVerifier codeVerifier) {
            FilterProperties.VerifyCodeFilterProperties verifyCode = this.fairycharSecurityProperties.getStandard().getFilter().getVerifyCode();
            return new VerifyCodeFilter(verifyCode.getVerifyUrls(), this.authenticationFailureHandler, codeVerifier);
        }

        @Bean
        @SneakyThrows
        public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) {
            return authenticationConfiguration.getAuthenticationManager();
        }


        @Bean
        public SecurityFilterChain configure(HttpSecurity http, JsonAuthenticationFilter jsonAuthenticationFilter) throws Exception {
            HttpSecurity httpSecurity = http
                    .exceptionHandling(c -> c.accessDeniedHandler(this.accessDeniedHandler)
                            .authenticationEntryPoint(this.authenticationEntryPoint))
                    .logout(c -> c.logoutUrl(this.fairycharSecurityProperties.getUrl().getLogout()).logoutSuccessHandler(this.logoutSuccessHandler))
                    .sessionManagement(c -> c.invalidSessionStrategy(this.invalidSessionStrategy)
                            .maximumSessions(this.fairycharSecurityProperties.getStandard().getMaxSession())
                            .sessionRegistry(this.springSessionBackedSessionRegistry())
                            .expiredSessionStrategy(this.sessionInformationExpiredStrategy)
                    )
                    .securityContext(s -> s.securityContextRepository(new HttpSessionSecurityContextRepository()))
                    .addFilterAt(jsonAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
            if (this.fairycharSecurityProperties.getUrl().isDisableLoginCors()) {
                httpSecurity.cors(c -> c.disable());
            }
            if (this.fairycharSecurityProperties.getUrl().isDisableLoginCsrf()) {
                httpSecurity.csrf(c -> c.disable());
            }
            if (this.fairycharSecurityProperties.getStandard().getFilter().getVerifyCode().isEnable()) {
                http.addFilterBefore(this.verifyCodeFilter, JsonAuthenticationFilter.class);
            }
            String[] allowed = this.fairycharSecurityProperties.getUrl().getAllowed();
            if (allowed != null) {
                http.authorizeHttpRequests(c -> c.requestMatchers(allowed).permitAll().anyRequest().authenticated());
            } else {
                String[] authenticated = this.fairycharSecurityProperties.getUrl().getAuthenticated();
                http.authorizeHttpRequests(c -> c.requestMatchers(authenticated).authenticated().anyRequest().permitAll());
            }
            return http.build();
        }

        @Bean
        @ConditionalOnProperty(value = "fairychar.security.standard.filter.apiPermission.enable", havingValue = "true")
        ApiPermissionFilter apiPermissionFilter() {
            FilterProperties.ApiPermissionFilterProperties apiPermission = this.fairycharSecurityProperties.getStandard().getFilter().getApiPermission();
            return new ApiPermissionFilter(apiPermission.getIgnorePaths(), this.accessDeniedHandler);
        }

        @Bean
        @ConditionalOnProperty(name = "fairychar.security.plugins.audit.enable", havingValue = "true")
        SecurityAuditObjectHandler securityAuditObjectHandler() {
            AuditProperties audit = this.fairycharSecurityProperties.getPlugins().getAudit();
            return new SecurityAuditObjectHandler(audit.getCreateBy(), audit.getCreateTime()
                    , audit.getUpdateBy(), audit.getUpdateTime());
        }

        @Configuration
        @ConditionalOnProperty(name = "fairychar.security.plugins.tenant.enable", havingValue = "true")
        @EnableConfigurationProperties(FairycharSecurityProperties.class)
        protected static class TenantConfiguration {

            @Autowired
            private FairycharSecurityProperties securityProperties;

            @Bean
            @ConditionalOnMissingBean
            SecurityContextTenantHandler securityContextTenantHandler() {
                TenantProperties tenant = this.securityProperties.getPlugins().getTenant();
                return new SecurityContextTenantHandler(tenant.getIgnoreTables(), tenant.getColumnName());
            }

            @Bean
            @ConditionalOnMissingBean
            MybatisPlusInterceptor mybatisPlusInterceptor() {
                MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
                return interceptor;
            }


            @Bean
            String mybatisPlusInterceptorMarker(MybatisPlusInterceptor mybatisPlusInterceptor) {
                // 如果用了分页插件注意先 add TenantLineInnerInterceptor 再 add PaginationInnerInterceptor
                // 用了分页插件必须设置 MybatisConfiguration#useDeprecatedExecutor = false
                //interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
                List<InnerInterceptor> interceptors = mybatisPlusInterceptor.getInterceptors();
                boolean hasTenantInterceptor = interceptors.stream().anyMatch(s -> s instanceof TenantLineInnerInterceptor);
                if (!hasTenantInterceptor) {
                    //添加一个mp默认的
                    List<InnerInterceptor> sortedList = new ArrayList<>();
                    TenantLineInnerInterceptor tenantLineInnerInterceptor = new TenantLineInnerInterceptor(this.securityContextTenantHandler());
                    if (interceptors.isEmpty()) {
                        sortedList.add(tenantLineInnerInterceptor);
                    } else {
                        for (InnerInterceptor interceptor : interceptors) {
                            if (interceptor instanceof PaginationInnerInterceptor) {
                                sortedList.add(tenantLineInnerInterceptor);
                            }
                            sortedList.add(interceptor);
                        }
                    }
                    mybatisPlusInterceptor.setInterceptors(sortedList);
                }
                return "mybatisPlusInterceptorMarker";
            }
        }


    }


}
