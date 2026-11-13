# com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration.reWriteDatabaseCustomizer

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SecurityAutoConfigurer.java.md)

[Lexical owner](SecurityAutoConfigurer.RedisSessionConfiguration.md#symbol-abd4dc8f99b72a20)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-7f174a8d57f6aba2"></a>
## com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration.reWriteDatabaseCustomizer

```java
@Bean
        @ConditionalOnMissingBean(value = {LettuceConnectionFactory.class, JedisConnectionFactory.class, SessionRepositoryCustomizer.class})
        SessionRepositoryCustomizer<RedisIndexedSessionRepository> reWriteDatabaseCustomizer(RedisProperties redisProperties)
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:122`; evidence: `declaration-7f174a8d57f6aba2a1613ef5e926d809155cfa782d17b70d35dc3bbb6cea5e27`.
Owner: `com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration`; visibility: `package-private` (language default or unknown).

Source docstring (unreviewed):
```text
<pre>redis session database重定向</pre>
 当redisConnectionFactory不为Jedis和Lettuce时,RedisSessionRepository无法配置到redisProperties<br>
 指定的db,需要手动定制指向

 @param redisProperties
 @return {@link SessionRepositoryCustomizer}<{@link RedisIndexedSessionRepository}>
```
