# fairychar骨架

## 模块说明

### api

包含对外提供的微服务调用功能接口

### app

模块实际业务

## 构建方式

模块下执行
maven->fairychar-micro-service->plugins->archetype->archetype:create-from-project
进入
cd target/generated-sources/archetype
执行本地安装
mvn clean install
发布到中央仓库
mvn clean deploy