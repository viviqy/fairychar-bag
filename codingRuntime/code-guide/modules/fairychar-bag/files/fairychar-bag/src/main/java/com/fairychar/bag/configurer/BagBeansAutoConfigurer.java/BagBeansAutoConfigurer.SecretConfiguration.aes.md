# com.fairychar.bag.configurer.BagBeansAutoConfigurer.SecretConfiguration.aes

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../BagBeansAutoConfigurer.java.md)

[Lexical owner](BagBeansAutoConfigurer.SecretConfiguration.md#symbol-9b94061a5fea97fe)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-8831424b76251255"></a>
## com.fairychar.bag.configurer.BagBeansAutoConfigurer.SecretConfiguration.aes

```java
@Bean
        @ConditionalOnMissingBean
        @ConditionalOnProperty(name = "fairychar.bag.secret.aes.key")
        AES aes()
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/configurer/BagBeansAutoConfigurer.java:96`; evidence: `declaration-8831424b762512551ca4d2197cdcdf113a883ac74072a4169b03865face6aa14`.
Owner: `com.fairychar.bag.configurer.BagBeansAutoConfigurer.SecretConfiguration`; visibility: `package-private` (language default or unknown).
