# Spring 上下文访问

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。优先构造器注入；只有无法注入的工具场景才按生命周期使用 holder。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## 入口与生命周期

`com.fairychar.bag.listener.SpringContextHolder.getInstance()` 返回共享 holder，不代表 ApplicationContext 已就绪。委托上下文要等刷新事件后才可用。Bean 查询、事件、资源和环境访问完整签名见 [API](../../api/listener.md)。不要用 holder 保存请求上下文，不用它规避初始化顺序。

框架事件回调不作为业务手动调用入口。

## 类型与完整签名

- [`com.fairychar.bag.listener.SpringContextHolder`](../../api/listener.md)
