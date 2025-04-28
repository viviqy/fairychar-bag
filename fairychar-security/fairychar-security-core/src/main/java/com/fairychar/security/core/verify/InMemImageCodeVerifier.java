package com.fairychar.security.core.verify;

import com.fairychar.security.core.utils.ImageVerifyCodeUtil;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 简单图片验证器,基于内存方式
 *
 * @author chiyo <br>
 */
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class InMemImageCodeVerifier implements ICodeVerifier {
    private final Cache<String, SimpleImageCode> codeStore = Caffeine.newBuilder()
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .maximumSize(10_0000)
            .build();

    private String codeHeader = "verifyCode";
    private String keyHeader = "verifyKey";


    @Override
    public void generateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletOutputStream outputStream = response.getOutputStream();
        Map<String, Object> imageCode = ImageVerifyCodeUtil.genImageCode(135, 55);
        String code = (String) imageCode.get("strEnsure");
        String key = UUID.randomUUID().toString();
        this.codeStore.put(key, new SimpleImageCode(key, code, null));
        response.setHeader(this.keyHeader, key);
        ImageIO.write((BufferedImage) imageCode.get("image"), "jpg", outputStream);
        outputStream.flush();
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
