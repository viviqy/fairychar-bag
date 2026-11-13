# com.fairychar.security.boot.configurer.SecurityAutoConfigurer

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SecurityAutoConfigurer.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-77cad787ca19a767"></a>
## com.fairychar.security.boot.configurer.SecurityAutoConfigurer

```java
@Configuration
@EnableConfigurationProperties({FairycharSecurityProperties.class, RedisProperties.class})
@AutoConfigureAfter(CommonBeansConfiguration.class)
@EnableWebSecurity
public class SecurityAutoConfigurer
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:69`; evidence: `declaration-77cad787ca19a76799411a9f2a33cacdb7e0961bae4a38c43774ebdd44245341`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
安全认证功能配置

 @author chiyo <br>
 @since 1.0
```


## Members

- [RedisSessionConfiguration](SecurityAutoConfigurer.RedisSessionConfiguration.md#symbol-abd4dc8f99b72a20) — `class`, source line 76
