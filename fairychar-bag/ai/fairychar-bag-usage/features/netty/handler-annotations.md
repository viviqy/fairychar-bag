# Netty 处理标记与回调

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：仅签名可查**。仅供定位 CauseHandler / EventHandler / NettyCauseAdvice / NettyEventAdvice；不自动推荐接入。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## 采用边界

public 注解存在不证明业务 handler 已注册或失败传播、线程和资源契约已闭合。需要这些入口时先明确协议与注册条件；本页不提供未经确认的生产模板。优先业务已有 Netty handler 链。完整属性见 [注解 API](../../api/domain-annotations.md)。

## 类型与完整签名

- [`com.fairychar.bag.domain.annotations.CauseHandler`](../../api/domain-annotations.md)
- [`com.fairychar.bag.domain.annotations.EventHandler`](../../api/domain-annotations.md)
- [`com.fairychar.bag.domain.annotations.NettyCauseAdvice`](../../api/domain-annotations.md)
- [`com.fairychar.bag.domain.annotations.NettyEventAdvice`](../../api/domain-annotations.md)
