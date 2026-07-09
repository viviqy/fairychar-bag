# 只install parent
根目录执行
```shell
 mvn install -N "-Dgpg.skip=true"
 ```
# 只发布parent
根目录执行
```shell
 mvn clean deploy -N 
 ```

'!fairychar-bag' 代表要排除的子模块

# 发布fairychar-bag

> 直接点deploy即可