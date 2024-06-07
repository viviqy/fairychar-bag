# 只发布parent

> mvn clean deploy -pl '!fairychar-bag,!fairychar-micro-service,!fairychar-micro-service/__rootArtifactId__-api,!
> fairychar-micro-service/__rootArtifactId__-app'

'!fairychar-bag' 代表要排除的子模块

# 发布fairychar-bag

> 直接点deploy即可