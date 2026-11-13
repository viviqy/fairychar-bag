# com.fairychar.bag.configurer.BagBeansAutoConfigurer.WebConfiguration.defaultExceptionAdvice

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../BagBeansAutoConfigurer.java.md)

[Lexical owner](BagBeansAutoConfigurer.WebConfiguration.md#symbol-43040ffb3edf4564)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-1d61bd33bed3640d"></a>
## com.fairychar.bag.configurer.BagBeansAutoConfigurer.WebConfiguration.defaultExceptionAdvice

```java
@ConditionalOnProperty(prefix = "fairychar.bag.web.advice", name = "enable", havingValue = "true")
        @Bean
        DefaultExceptionAdvice defaultExceptionAdvice()
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/configurer/BagBeansAutoConfigurer.java:42`; evidence: `declaration-1d61bd33bed3640dd2fc014773204465bb0903e4fc3f56abd38f205ee47b8e89`.
Owner: `com.fairychar.bag.configurer.BagBeansAutoConfigurer.WebConfiguration`; visibility: `package-private` (language default or unknown).
