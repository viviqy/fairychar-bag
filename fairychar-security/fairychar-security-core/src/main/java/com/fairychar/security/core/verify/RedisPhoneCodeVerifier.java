package com.fairychar.security.core.verify;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
import com.aliyun.sdk.service.dysmsapi20180501.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20180501.models.SendMessageWithTemplateRequest;
import com.aliyun.sdk.service.dysmsapi20180501.models.SendMessageWithTemplateResponse;
import com.fairychar.security.core.properties.SmsVerifyProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 基于redis的验证码校验器
 *
 * @author chiyo <br>
 */
@Slf4j
public class RedisPhoneCodeVerifier implements ICodeVerifier {
    private final RedisTemplate<String, String> redisTemplate;
    private final AsyncClient client;
    private final SmsVerifyProperties.AliyunSmsProperties aliyunSmsProperties;
    private final ObjectMapper objectMapper;

    /**
     * 验证码存储空间的redis前缀
     */
    private final String prefix;
    /**
     * 前端传输验证码header的名称
     */
    private final String codeHeader;
    /**
     * 验证码唯一标识返回的header名称
     */
    private final String keyHeader;
    /**
     * 验证码有效期(秒)
     */
    @Setter
    @Getter
    private int expireSeconds = 300;

    @Setter
    @Getter
    private int width = 140;
    @Setter
    @Getter
    private int height = 60;


    public RedisPhoneCodeVerifier(RedisTemplate<String, String> redisTemplate, AsyncClient client, SmsVerifyProperties.AliyunSmsProperties aliyunSmsProperties, ObjectMapper objectMapper) {
        this(redisTemplate, client, aliyunSmsProperties, objectMapper, "verifyCode:", "verifyCode", "verifyKey");
    }

    public RedisPhoneCodeVerifier(RedisTemplate<String, String> redisTemplate, AsyncClient client, SmsVerifyProperties.AliyunSmsProperties aliyunSmsProperties, ObjectMapper objectMapper, String prefix, String codeHeader, String keyHeader) {
        this.redisTemplate = redisTemplate;
        this.client = client;
        this.aliyunSmsProperties = aliyunSmsProperties;
        this.objectMapper = objectMapper;
        this.prefix = prefix;
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
        this.redisTemplate.opsForValue().set(this.prefix.concat(phone)
                , String.valueOf(randomInt), this.expireSeconds, TimeUnit.SECONDS);
    }

    @Override
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String key = request.getHeader(this.keyHeader);
        String code = request.getHeader(this.codeHeader);
        Assert.notBlank(key, () -> new IllegalArgumentException("not provide phone"));
        Assert.notBlank(code, () -> new IllegalArgumentException("not provide code"));
        String redisCode = this.redisTemplate.opsForValue().get(this.prefix + key);
        if (redisCode == null || !redisCode.equals(code)) {
            throw new BadCredentialsException("code expired or invalid");
        }
        this.redisTemplate.delete(this.prefix + key);
    }
}
