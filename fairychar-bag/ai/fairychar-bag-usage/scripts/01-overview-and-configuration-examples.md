# Overview And Configuration Examples

> 返回主入口: [fairychar-bag-usage-guide.md](../fairychar-bag-usage-guide.md)。说明和约束见 `../references/` 中对应文档。

## Example 1: 推荐配置

```yaml
fairychar:
  bag:
    aop:
      log:
        enable: true
        global-level: info
        global-before: jsonLoggingHandler
        global-after: jsonLoggingHandler
      lock:
        enable: true
        default-lock: local
        global-timeout: 1
        time-unit: seconds
    web:
      advice:
        enable: true
      property-processor:
        enable: true
    convert:
      mvc:
        enable: true
    secret:
      aes:
        key: "1234567890123456"
      rsa:
        pub-key: "..."
        pri-key: "..."
    server-client:
      server:
        port: 10000
        boss-size: 1
        worker-size: 4
      client:
        host: 127.0.0.1
        port: 10000
        event-loop-size: 2
```

