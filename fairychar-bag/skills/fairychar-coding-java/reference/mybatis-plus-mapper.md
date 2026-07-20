# MyBatis-Plus Mapper 与 XML 规范

适用于应用模块中的 MyBatis-Plus Mapper 接口和 mapper XML。不要把本规范套到 `fairychar-bag/src` 可复用库代码中。

## 硬性规则

- Mapper 接口只声明方法、继承 `BaseMapper<Entity>`、写 `@Param` 参数名；不能在 Mapper 接口中写 SQL。
- 禁止在 Mapper 接口中使用 `@Select`、`@Update`、`@Insert`、`@Delete`、`@SelectProvider`、`@UpdateProvider`、`@InsertProvider`、`@DeleteProvider`。
- 所有自定义 SQL、动态条件、`resultMap`、批量插入、分组统计都写到 XML mapper 中。
- XML 的 `<mapper namespace="...">` 必须等于 Mapper 接口全限定名。
- XML statement 的 `id` 必须与 Mapper 接口方法名一致。

## Mapper 接口

- 命名为 `<Entity>Mapper`，例如 `SysDictMapper`。
- 继承 `BaseMapper<Entity>`，保留 MyBatis-Plus 基础 CRUD 能力。
- 自定义方法参数显式写 `@Param`，常用命名：
  - 实体筛选条件：`@Param("e") Entity entity`
  - 分页参数：`@Param("page") IPage page`
  - 批量数据：`@Param("list") List<Entity> entities`
  - 指定字段：`@Param("fields") String[] fields` 或 `@Param("fields") String fields`
- 返回类型按场景选择：单条 `Entity`，列表 `List<Entity>`，分页 `Page<Entity>`，计数 `int`。
- Mapper 接口中不要出现 SQL 字符串、表名拼接或动态 SQL 片段。

## XML Mapper

- XML 放在 `code/src/resources/mapper/<MapperName>.xml` 样例路径；业务模块按项目资源目录等价放置。
- 顶部使用 MyBatis mapper DTD。
- 定义 `BaseResultMap` 显式映射字段，非表字段可用注释说明用途。
- 常用 SQL 片段抽到 `<sql>`：
  - `Base_Column_List`
  - `Prefix_Column_List`
  - `where_sql`
  - `query_one_where_sql`
  - `conditional_sql`
  - `query_one_conditional_sql`
- 查询类 statement 使用 `<select id="..." resultMap="BaseResultMap">`。
- 批量插入使用 XML `<insert>` + `<foreach collection="list" item="item" separator=",">`。
- 动态条件使用 `<where>`、`<if test="...">`、`<include refid="...">`，不要在 Java Mapper 中拼接。

## 字段选择与安全

- XML 中 `${field}` / `${fields}` 只适合字段名、分组字段等 SQL 标识符场景；调用前必须保证字段来自白名单或可信枚举。
- 普通值条件必须使用 `#{...}` 绑定，不能用 `${...}` 拼接用户输入。
- 模糊查询沿用样例中的 `INSTR(column, #{e.field})` 写法；精确查询使用 `column = #{e.field}`。

## 样例

- Mapper 接口：`code/src/main/java/com/fairychar/bag/mapper/SysDictMapper.java`
- Mapper XML：`code/src/resources/mapper/SysDictMapper.xml`
