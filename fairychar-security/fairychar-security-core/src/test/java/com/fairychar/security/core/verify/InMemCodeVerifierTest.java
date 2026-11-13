package com.fairychar.security.core.verify;

import com.aliyun.sdk.service.dysmsapi20180501.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20180501.models.SendMessageWithTemplateResponse;
import com.fairychar.security.core.properties.SmsVerifyProperties;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.test.util.ReflectionTestUtils;
import tools.jackson.databind.json.JsonMapper;

import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RunWith(Parameterized.class)
public class InMemCodeVerifierTest {

    @Parameterized.Parameters(name = "{0}")
    public static List<String> verifierTypes() {
        return List.of("image", "phone");
    }

    private final String verifierType;
    private ICodeVerifier verifier;
    private Cache<String, SimpleImageCode> codeStore;
    private MockHttpServletResponse response;

    public InMemCodeVerifierTest(String verifierType) {
        this.verifierType = verifierType;
    }

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        if ("image".equals(this.verifierType)) {
            InMemImageCodeVerifier imageVerifier = new InMemImageCodeVerifier();
            imageVerifier.setExpireSeconds(60);
            this.verifier = imageVerifier;
        } else {
            AsyncClient client = (AsyncClient) Proxy.newProxyInstance(AsyncClient.class.getClassLoader(),
                    new Class<?>[]{AsyncClient.class}, (proxy, method, arguments) -> {
                        if ("sendMessageWithTemplate".equals(method.getName())) {
                            return CompletableFuture.completedFuture(SendMessageWithTemplateResponse.create());
                        }
                        throw new UnsupportedOperationException(method.getName());
                    });
            SmsVerifyProperties.AliyunSmsProperties properties = new SmsVerifyProperties.AliyunSmsProperties();
            properties.setCodeParam("code");
            this.verifier = new InMemPhoneCodeVerifier(Caffeine.newBuilder().build(), client, properties,
                    JsonMapper.builder().build());
        }
        this.codeStore = (Cache<String, SimpleImageCode>) ReflectionTestUtils.getField(this.verifier, "codeStore");
        this.response = new MockHttpServletResponse();
    }

    @Test
    public void generatedCodeHasExpiryAndCanBeVerified() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("PHONE", "test-phone");
        LocalDateTime before = LocalDateTime.now();
        this.verifier.generateCode(request, this.response);
        LocalDateTime after = LocalDateTime.now();
        String key = "image".equals(this.verifierType) ? this.response.getHeader("verifyKey") : "test-phone";
        SimpleImageCode stored = this.codeStore.getIfPresent(key);
        Assert.assertNotNull(stored);
        Assert.assertNotNull(stored.getExpireTime());
        int seconds = "image".equals(this.verifierType) ? 60 : 300;
        Assert.assertFalse(stored.getExpireTime().isBefore(before.plusSeconds(seconds)));
        Assert.assertFalse(stored.getExpireTime().isAfter(after.plusSeconds(seconds)));
        this.verifier.verifyCode(request(key, stored.getValue()), this.response);
        Assert.assertNull(this.codeStore.getIfPresent(key));
    }

    @Test
    public void rejectsAndRemovesCodeWithoutExpiry() {
        this.codeStore.put("key", new SimpleImageCode("key", "123456", null));
        assertRejected(request("key", "123456"), "validate code expired");
        Assert.assertNull(this.codeStore.getIfPresent("key"));
    }

    @Test
    public void rejectsAndRemovesExpiredCode() {
        this.codeStore.put("key", new SimpleImageCode("key", "123456", LocalDateTime.now().minusSeconds(1)));
        assertRejected(request("key", "123456"), "validate code expired");
        Assert.assertNull(this.codeStore.getIfPresent("key"));
    }

    @Test
    public void acceptsValidCodeOnlyOnce() {
        this.codeStore.put("key", new SimpleImageCode("key", "123456", LocalDateTime.now().plusMinutes(1)));
        this.verifier.verifyCode(request("key", "123456"), this.response);
        Assert.assertNull(this.codeStore.getIfPresent("key"));
        assertRejected(request("key", "123456"), "not provide validate code");
    }

    @Test
    public void rejectsWrongCodeWithoutConsumingValidEntry() {
        SimpleImageCode stored = new SimpleImageCode("key", "123456", LocalDateTime.now().plusMinutes(1));
        this.codeStore.put("key", stored);
        assertRejected(request("key", "wrong"), "validate code wrong");
        Assert.assertSame(stored, this.codeStore.getIfPresent("key"));
    }

    @Test
    public void rejectsMissingEntry() {
        assertRejected(request("missing", "123456"), "not provide validate code");
    }

    @Test
    public void rejectsMissingKey() {
        assertRejected(new MockHttpServletRequest(), "not provide validate code");
    }

    private MockHttpServletRequest request(String key, String code) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("verifyKey", key);
        request.addHeader("verifyCode", code);
        return request;
    }

    private void assertRejected(MockHttpServletRequest request, String message) {
        BadCredentialsException exception = Assert.assertThrows(BadCredentialsException.class,
                () -> this.verifier.verifyCode(request, this.response));
        Assert.assertEquals(message, exception.getMessage());
    }
}
