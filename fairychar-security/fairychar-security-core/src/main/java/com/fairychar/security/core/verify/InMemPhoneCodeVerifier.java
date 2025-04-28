package com.fairychar.security.core.verify;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
import com.aliyun.sdk.service.dysmsapi20180501.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20180501.models.SendMessageWithTemplateRequest;
import com.aliyun.sdk.service.dysmsapi20180501.models.SendMessageWithTemplateResponse;
import com.fairychar.security.core.properties.SmsVerifyProperties;
import com.github.benmanes.caffeine.cache.Cache;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 简单图片验证器,基于内存方式
 *
 * @author chiyo <br>
 */

@Slf4j
public class InMemPhoneCodeVerifier implements ICodeVerifier {
    private final Cache<String, SimpleImageCode> codeStore;
    //    = Caffeine.newBuilder()
//            .expireAfterWrite(5, TimeUnit.MINUTES)
//            .maximumSize(10_0000)
//            .build();
    private final AsyncClient client;
    private final SmsVerifyProperties.AliyunSmsProperties aliyunSmsProperties;

    private String codeHeader = "verifyCode";
    private String keyHeader = "verifyKey";

    private final static Gson gson = new Gson();

    public InMemPhoneCodeVerifier(Cache<String, SimpleImageCode> codeStore, AsyncClient client, SmsVerifyProperties.AliyunSmsProperties aliyunSmsProperties) {
        this.codeStore = codeStore;
        this.client = client;
        this.aliyunSmsProperties = aliyunSmsProperties;
    }

    public InMemPhoneCodeVerifier(Cache<String, SimpleImageCode> codeStore, AsyncClient client, SmsVerifyProperties.AliyunSmsProperties aliyunSmsProperties, String codeHeader, String keyHeader) {
        this.codeStore = codeStore;
        this.client = client;
        this.aliyunSmsProperties = aliyunSmsProperties;
        this.codeHeader = codeHeader;
        this.keyHeader = keyHeader;
    }

    @Override
    public void generateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String phone = request.getHeader("PHONE");
        Assert.notBlank(phone, () -> new IllegalArgumentException("手机号不能为空"));
        int randomInt = RandomUtil.randomInt(100_000, 999_999);
        String paramJson = gson.toJson(Map.of(this.aliyunSmsProperties.getCodeParam(), randomInt));
        SendMessageWithTemplateRequest message = SendMessageWithTemplateRequest.builder()
                .templateCode(this.aliyunSmsProperties.getTemplateCode())    // 模板ID
                .to(phone)      // 收信人
                .templateParam(paramJson)
                .build();
        SendMessageWithTemplateResponse templateResponse = client.sendMessageWithTemplate(message).get();
        log.info("send sms response={}", templateResponse);
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
        if (simpleImageCode.getExpireTime().isBefore(LocalDateTime.now())) {
            throw new BadCredentialsException("validate code expired");
        }
        if (!simpleImageCode.getValue().equals(code)) {
            throw new BadCredentialsException("validate code wrong");
        }
        this.codeStore.invalidate(key);
    }


}
