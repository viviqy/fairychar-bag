package com.fairychar.security.core.verify;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
import com.aliyun.sdk.service.dysmsapi20180501.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20180501.models.SendMessageWithTemplateRequest;
import com.aliyun.sdk.service.dysmsapi20180501.models.SendMessageWithTemplateResponse;
import com.fairychar.security.core.properties.SmsVerifyProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 简单图片验证器,基于内存方式
 *
 * @author chiyo <br>
 */

@Slf4j
public class InMemPhoneCodeVerifier implements ICodeVerifier {
    private final Cache<String, SimpleImageCode> codeStore;
    private final AsyncClient client;
    private final SmsVerifyProperties.AliyunSmsProperties aliyunSmsProperties;
    private final ObjectMapper objectMapper;

    private String codeHeader = "verifyCode";
    private String keyHeader = "verifyKey";


    public InMemPhoneCodeVerifier(AsyncClient client, SmsVerifyProperties.AliyunSmsProperties aliyunSmsProperties, ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        Cache<String, SimpleImageCode> cache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .maximumSize(10_0000)
                .build();
        this.codeStore = cache;
        this.client = client;
        this.aliyunSmsProperties = aliyunSmsProperties;
    }

    public InMemPhoneCodeVerifier(Cache<String, SimpleImageCode> codeStore, AsyncClient client, SmsVerifyProperties.AliyunSmsProperties aliyunSmsProperties, ObjectMapper objectMapper) {
        this.codeStore = codeStore;
        this.client = client;
        this.aliyunSmsProperties = aliyunSmsProperties;
        this.objectMapper = objectMapper;
    }

    public InMemPhoneCodeVerifier(Cache<String, SimpleImageCode> codeStore, AsyncClient client, SmsVerifyProperties.AliyunSmsProperties aliyunSmsProperties, ObjectMapper objectMapper, String codeHeader, String keyHeader) {
        this.codeStore = codeStore;
        this.client = client;
        this.aliyunSmsProperties = aliyunSmsProperties;
        this.objectMapper = objectMapper;
        this.codeHeader = codeHeader;
        this.keyHeader = keyHeader;
    }

    @Override
    public void generateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String phone = request.getHeader("PHONE");
        Assert.notBlank(phone, () -> new IllegalArgumentException("手机号不能为空"));
        int randomInt = RandomUtil.randomInt(100_000, 999_999);
        String paramJson = this.objectMapper.writeValueAsString(Map.of(this.aliyunSmsProperties.getCodeParam(), randomInt));
        SendMessageWithTemplateRequest message = SendMessageWithTemplateRequest.builder()
                .templateCode(this.aliyunSmsProperties.getTemplateCode())    // 模板ID
                .to(phone)      // 收信人
                .templateParam(paramJson)
                .build();
        SendMessageWithTemplateResponse templateResponse = client.sendMessageWithTemplate(message).get();
        log.info("send sms response={}", templateResponse);
        this.codeStore.put(phone, new SimpleImageCode(null, String.valueOf(randomInt), LocalDateTime.now().plusMinutes(5)));
    }

    @Override
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String key = request.getHeader(this.keyHeader);
        String code = request.getHeader(this.codeHeader);
        if (key == null) {
            throw new BadCredentialsException("not provide validate code");
        }
        SimpleImageCode simpleImageCode = this.codeStore.getIfPresent(key);
        if (simpleImageCode == null) {
            throw new BadCredentialsException("not provide validate code");
        }
        LocalDateTime expireTime = simpleImageCode.getExpireTime();
        if (expireTime == null || !expireTime.isAfter(LocalDateTime.now())) {
            this.codeStore.invalidate(key);
            throw new BadCredentialsException("validate code expired");
        }
        if (!simpleImageCode.getValue().equals(code)) {
            throw new BadCredentialsException("validate code wrong");
        }
        this.codeStore.invalidate(key);
    }


}
