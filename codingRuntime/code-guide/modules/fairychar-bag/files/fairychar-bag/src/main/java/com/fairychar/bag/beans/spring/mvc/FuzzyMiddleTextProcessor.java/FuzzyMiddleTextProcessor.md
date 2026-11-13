# com.fairychar.bag.beans.spring.mvc.FuzzyMiddleTextProcessor

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FuzzyMiddleTextProcessor.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-011be9d6adb349a2"></a>
## com.fairychar.bag.beans.spring.mvc.FuzzyMiddleTextProcessor

```java
public class FuzzyMiddleTextProcessor implements FuzzyValueProcessor
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/spring/mvc/FuzzyMiddleTextProcessor.java:32`; evidence: `declaration-011be9d6adb349a29bbf86304130ec72f5e5cfababb089af29e5a5eb2f930af8`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>模糊加密字符串</p>
 beginAt=从左往右数几位,
 endAt=从右往左数几位,
 模糊加密这之间的字符
 <pre>
     {@code
     @Configuration
     class BeansConfiguration{
          @Bean
          FuzzyValueProcessor middleFuzzy(){
              return new FuzzyMiddleTextProcessor();
          }
     }

     class Sample{
         @FuzzyValue(beginAt=1,endAt=1,processor={FuzzyMiddleTextProcessor.class})
         private String text="1234";
     }

     }
 </pre>
 模糊加密后结果为text="1**4";

 @author chiyo
 @since 1.0.2
```


## Members

- [fuzzyValue](FuzzyMiddleTextProcessor.fuzzyValue.md#symbol-2bd8efb9b6032883) — `function`, source line 33
