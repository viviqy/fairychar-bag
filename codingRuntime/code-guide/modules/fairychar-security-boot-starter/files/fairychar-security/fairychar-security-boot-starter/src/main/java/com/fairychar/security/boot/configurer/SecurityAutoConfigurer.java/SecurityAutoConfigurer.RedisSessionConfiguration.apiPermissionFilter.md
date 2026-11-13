# com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration.apiPermissionFilter

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SecurityAutoConfigurer.java.md)

[Lexical owner](SecurityAutoConfigurer.RedisSessionConfiguration.md#symbol-abd4dc8f99b72a20)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-3e86cc4ca4514a3e"></a>
## com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration.apiPermissionFilter

```java
@Bean
        @ConditionalOnProperty(value = "fairychar.security.standard.filter.apiPermission.enable", havingValue = "true")
        ApiPermissionFilter apiPermissionFilter()
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:217`; evidence: `declaration-3e86cc4ca4514a3e1c24f136b7d45777469c813ea6816e8f212812d4552608bc`.
Owner: `com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration`; visibility: `package-private` (language default or unknown).
