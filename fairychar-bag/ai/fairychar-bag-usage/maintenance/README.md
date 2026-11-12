# SDK 文档维护（业务开发不加载）

只在维护文档、生成索引或验证配套示例时读取。本目录与业务调用材料物理隔离；回归驱动可以使用内部协作者，这不代表业务接入方式。

## 文档结构与唯一归属

- [功能入口](../fairychar-bag-usage-guide.md) 只按需求直接路由；功能页是对应能力的行为说明，采用状态就地标注。
- features 按可独立使用的能力拆分，任务步骤、输入输出、失败、副作用与小示例在同页，不另建任务卡或契约汇编。
- [api](../api/README.md) 只提供字节码签名和到功能页的路由；不承担第二套行为说明。
- examples 存放完整业务模板和可选组合示例；维护回归、生成器、检查器只在 maintenance。

## 索引范围

签名覆盖不等于行为测试覆盖。包含约定调用方范围内的 public 类型、构造器、声明方法、字段、枚举与注解默认值，以及生成成员。排除内部切面包、约定内部类型及其嵌套类型、synthetic/bridge 和非 public 成员；完整机器排除规则以生成器和检查器集合为准。不索引 POM、依赖版本或第三方继承成员。

SDK class 指纹覆盖完整输入字节码，不因消费者排除规则缩小，也不是发行版本号。行为受限的能力仍可查签名，但必须路由到对应功能页的限制或明确的查询边界，不能因 public 就推荐。

## 生成与核验（从模块目录执行）

```powershell
$sdk = 'C:\sdk\fairychar-bag.jar'
$runtimeClasspath = 'C:\sdk\runtime\*'
$classpath = "$sdk;$runtimeClasspath"
$guide = 'ai\fairychar-bag-usage'
java -cp $classpath "$guide\maintenance\GenerateSdkApiIndex.java" `
  --sdk-path $sdk --output-root "$guide\api"
if ($LASTEXITCODE -ne 0) { throw 'API generation failed' }
java -cp $classpath "$guide\maintenance\GenerateSdkApiIndex.java" `
  --sdk-path $sdk --output-root "$guide\api" --check
if ($LASTEXITCODE -ne 0) { throw 'API index is stale' }
python "$guide\maintenance\verify-sdk-guide.py"
if ($LASTEXITCODE -ne 0) { throw 'Guide verification failed' }
```

路径仅为占位，使用实际 JAR 与已有运行类路径；不要求业务生成索引。生成器需要 JDK 21。发布前优先在独立候选目录生成、检查，不能将半次生成当作有效发布。索引输出目录专供生成文件，不放手工 Markdown；删除或改包后核对多余文件再删除，不盲目递归清理。

检查器验证本地链接与锚点、API 数量及唯一性、内部类型排除、业务路径不进入维护目录、每个功能页从入口直接可达、采用边界与签名入口存在，并拒绝旧 references/scripts 平行目录重新出现。它不证明每句文字正确，也不代替字节码 --check 或真实集成测试。

## 示例回归

[SdkUsageExamples.java](SdkUsageExamples.java) 是 10 个场景的离线回归驱动；[SdkContractExamples.java](SdkContractExamples.java) 是 11 组参数、返回、异常、副作用与调用顺序断言。代理锁/JDBC 探针不证明真实互斥或数据库落盘；不运行已知可能泄漏或不终止的 Netty/decoder 路径。

```powershell
$out = Join-Path $env:TEMP ('fairychar-sdk-examples-' + [guid]::NewGuid().ToString('N'))
New-Item -ItemType Directory -Path $out | Out-Null
javac -proc:none -encoding UTF-8 -cp $classpath -d $out `
  "$guide\examples\SdkQuickStartController.java" `
  "$guide\maintenance\SdkUsageExamples.java" "$guide\maintenance\SdkContractExamples.java"
if ($LASTEXITCODE -ne 0) { throw 'Example compilation failed' }
java -cp "$out;$classpath" SdkUsageExamples
if ($LASTEXITCODE -ne 0) { throw 'Usage assertions failed' }
java -cp "$out;$classpath" SdkContractExamples
if ($LASTEXITCODE -ne 0) { throw 'Contract assertions failed' }
javac -encoding UTF-8 -cp $classpath -d $out `
  -processor 'lombok.launch.AnnotationProcessorHider$AnnotationProcessor' `
  "$guide\examples\SdkLoggingConfiguration.java" "$guide\examples\SdkLockService.java" `
  "$guide\examples\SdkFeatureController.java"
if ($LASTEXITCODE -ne 0) { throw 'Logging and lock example compilation failed' }
```

完整示例使用 Lombok 的一组需开启注解处理。编译或离线回归不替代 Spring 自动装配、HTTP/AOP、Redis/ZK、多租户 SQL、Netty 及跨事务测试；未执行层次必须明确写未验证。旧的 verify-fairychar-bag-compile.ps1 仅为库维护编译脚本，不是消费者验收。
