# Balking 状态引用

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：仅签名及局部语义可查**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## AbstractBalkingReference

位置: `com.fairychar.bag.domain.abstracts.AbstractBalkingReference`

用于“状态有变更才保存”的 balking 模式。

```java
class ConfigRef extends AbstractBalkingReference<Config> {
    ConfigRef(Config config) {
        super(config);
    }

    @Override
    public boolean doSave() {
        repository.save(t);
        return true;
    }
}

ConfigRef ref = new ConfigRef(config);
ref.save();       // 首次保存
ref.change(newConfig);
ref.save();       // 有变更才保存
```

## 类型与完整签名

- [`com.fairychar.bag.domain.abstracts.AbstractBalkingReference`](../../api/domain-abstracts.md)
- [`com.fairychar.bag.domain.concurrent.IBalkingReference`](../../api/domain-concurrent.md)
