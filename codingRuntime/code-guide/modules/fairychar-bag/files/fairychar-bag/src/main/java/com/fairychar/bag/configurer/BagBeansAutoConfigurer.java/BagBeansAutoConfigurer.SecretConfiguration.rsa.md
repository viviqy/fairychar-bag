# com.fairychar.bag.configurer.BagBeansAutoConfigurer.SecretConfiguration.rsa

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../BagBeansAutoConfigurer.java.md)

[Lexical owner](BagBeansAutoConfigurer.SecretConfiguration.md#symbol-9b94061a5fea97fe)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-f81b9a783eb1337c"></a>
## com.fairychar.bag.configurer.BagBeansAutoConfigurer.SecretConfiguration.rsa

```java
@Bean
        @ConditionalOnMissingBean
        @ConditionalOnProperty(name = {"fairychar.bag.secret.rsa.pri-key", "fairychar.bag.secret.rsa.pub-key"})
        RSA rsa()
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/configurer/BagBeansAutoConfigurer.java:104`; evidence: `declaration-f81b9a783eb1337c3651fd05b6ec3233b099e198827b49abe93921b3b0ccb84f`.
Owner: `com.fairychar.bag.configurer.BagBeansAutoConfigurer.SecretConfiguration`; visibility: `package-private` (language default or unknown).
