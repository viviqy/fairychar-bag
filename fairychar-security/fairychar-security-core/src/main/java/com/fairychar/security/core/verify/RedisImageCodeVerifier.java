package com.fairychar.security.core.verify;

import com.fairychar.security.core.utils.ImageVerifyCodeUtil;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 基于redis的验证码校验器
 *
 * @author chiyo <br>
 */
public class RedisImageCodeVerifier implements ICodeVerifier {
    private final RedisTemplate<String, String> redisTemplate;
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


    public RedisImageCodeVerifier(RedisTemplate<String, String> redisTemplate) {
        this(redisTemplate, "verifyCode:", "verifyCode", "verifyKey");
    }

    public RedisImageCodeVerifier(RedisTemplate<String, String> redisTemplate, String prefix, String codeHeader, String keyHeader) {
        this.redisTemplate = redisTemplate;
        this.prefix = prefix;
        this.codeHeader = codeHeader;
        this.keyHeader = keyHeader;
    }

    @Override
    public void generateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletOutputStream outputStream = response.getOutputStream();
        Map<String, Object> imageCode = ImageVerifyCodeUtil.genImageCode(this.width, this.height);
        String code = (String) imageCode.get("strEnsure");
        String key = UUID.randomUUID().toString();
        this.redisTemplate.opsForValue().set(this.prefix + key, code, this.expireSeconds, TimeUnit.SECONDS);
        response.setHeader(this.keyHeader, key);
        ImageIO.write((BufferedImage) imageCode.get("image"), "jpg", outputStream);
        outputStream.flush();
    }

    @Override
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String key = request.getHeader(this.keyHeader);
        String code = request.getHeader(this.codeHeader);
        String redisCode = this.redisTemplate.opsForValue().get(this.prefix + key);
        if (redisCode == null) {
            throw new BadCredentialsException("not provide validate code");
        }
        if (!redisCode.equals(code)) {
            throw new BadCredentialsException("validate code wrong");
        }
        this.redisTemplate.delete(this.prefix + key);
    }
}
