import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.jar.JarFile;

public class GenerateSdkApiIndex {
    private static final Set<String> INTERNAL_TYPES = Set.of(
            "com.fairychar.bag.domain.spring.BeanAwareMarker",
            "com.fairychar.bag.beans.spring.advice.DefaultExceptionAdvice",
            "com.fairychar.bag.beans.spring.advice.InvalidateLog",
            "com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice",
            "com.fairychar.bag.domain.netty.advice.GlobalInboundEventAdvice",
            "com.fairychar.bag.pojo.vo.InvalidateFieldVO",
            "com.fairychar.bag.beans.spring.mvc.EraseValueAdvice",
            "com.fairychar.bag.beans.spring.mvc.FuzzyMiddleTextProcessor",
            "com.fairychar.bag.beans.spring.mvc.FuzzyValueAdvice",
            "com.fairychar.bag.beans.spring.mvc.FuzzyValueProcessor",
            "com.fairychar.bag.beans.spring.mvc.KeepValueAdvice",
            "com.fairychar.bag.beans.swagger.RequestIgnoreParameterPlugin",
            "com.fairychar.bag.beans.swagger.ShowParam",
            "com.fairychar.bag.configurer.BagBeansAutoConfigurer");

    private record ApiType(Class<?> type, List<String> constructors, List<String> methods, List<String> fields) {}

    public static void main(String[] args) throws Exception {
        Map<String, String> options = new TreeMap<>();
        boolean check = false;
        for (int index = 0; index < args.length; index++) {
            if (args[index].equals("--check")) {
                check = true;
            } else if ((args[index].equals("--sdk-path") || args[index].equals("--output-root")) && index + 1 < args.length) {
                options.put(args[index], args[++index]);
            } else {
                throw new IllegalArgumentException("Unknown or incomplete option: " + args[index]);
            }
        }
        if (!options.containsKey("--sdk-path") || !options.containsKey("--output-root")) {
            throw new IllegalArgumentException("Required: --sdk-path <classes directory or jar> --output-root <api directory> [--check]");
        }
        Path sdk = Path.of(options.get("--sdk-path")).toAbsolutePath().normalize();
        Path output = Path.of(options.get("--output-root")).toAbsolutePath().normalize();
        Map<String, byte[]> binaries = readClasses(sdk);
        List<ApiType> types = new ArrayList<>();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        for (var entry : binaries.entrySet()) {
            digest.update(entry.getKey().getBytes(StandardCharsets.UTF_8));
            digest.update((byte) 0);
            digest.update(entry.getValue());
            String className = entry.getKey().replace('/', '.').replaceAll("\\.class$", "");
            if (className.startsWith("com.fairychar.bag.aop.") || INTERNAL_TYPES.contains(className.split("\\$", 2)[0])) {
                continue;
            }
            Class<?> type = Class.forName(className, false, GenerateSdkApiIndex.class.getClassLoader());
            try (var stream = type.getResourceAsStream("/" + entry.getKey())) {
                if (stream == null || !Arrays.equals(entry.getValue(), stream.readAllBytes())) {
                    throw new IllegalStateException("Classpath differs from --sdk-path: " + className);
                }
            }
            if (!isPublic(type) || type.isSynthetic() || type.isAnonymousClass() || type.isLocalClass()) {
                continue;
            }
            List<String> constructors = Arrays.stream(type.getDeclaredConstructors())
                    .filter(member -> Modifier.isPublic(member.getModifiers()) && !member.isSynthetic())
                    .map(Constructor::toGenericString).sorted().toList();
            List<String> methods = Arrays.stream(type.getDeclaredMethods())
                    .filter(member -> Modifier.isPublic(member.getModifiers()) && !member.isSynthetic() && !member.isBridge())
                    .map(member -> (member.isAnnotationPresent(Deprecated.class) ? "@Deprecated " : "")
                            + member.toGenericString() + annotationDefault(member)).sorted().toList();
            List<String> fields = Arrays.stream(type.getDeclaredFields())
                    .filter(member -> Modifier.isPublic(member.getModifiers()) && !member.isSynthetic())
                    .map(member -> member.toGenericString() + (member.isEnumConstant() ? " [enum constant]" : ""))
                    .sorted().toList();
            types.add(new ApiType(type, constructors, methods, fields));
        }
        if (types.isEmpty()) {
            throw new IllegalStateException("No public com.fairychar.bag types found");
        }
        String fingerprint = HexFormat.of().formatHex(digest.digest());
        Map<String, String> documents = render(types, fingerprint);
        if (check) {
            List<String> errors = new ArrayList<>();
            for (var entry : documents.entrySet()) {
                Path file = output.resolve(entry.getKey());
                if (!Files.isRegularFile(file) || !Files.readString(file).replace("\r\n", "\n").equals(entry.getValue())) {
                    errors.add("Missing or stale: " + entry.getKey());
                }
            }
            if (Files.isDirectory(output)) {
                try (var paths = Files.list(output)) {
                    paths.filter(Files::isRegularFile).filter(path -> path.toString().endsWith(".md"))
                            .filter(path -> !documents.containsKey(path.getFileName().toString()))
                            .forEach(path -> errors.add("Unexpected: " + path.getFileName()));
                }
            }
            if (!errors.isEmpty()) {
                throw new IllegalStateException(String.join("\n", errors));
            }
        } else {
            Files.createDirectories(output);
            for (var entry : documents.entrySet()) {
                Path temporary = Files.createTempFile(output, ".api-index-", ".tmp");
                try {
                    Files.writeString(temporary, entry.getValue());
                    Files.move(temporary, output.resolve(entry.getKey()), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                } finally {
                    Files.deleteIfExists(temporary);
                }
            }
        }
        System.out.printf("%s: %d public types, %d constructors, %d declared methods, %d fields; SDK SHA-256 %s%n",
                check ? "Verified" : "Generated", types.size(),
                types.stream().mapToInt(type -> type.constructors().size()).sum(),
                types.stream().mapToInt(type -> type.methods().size()).sum(),
                types.stream().mapToInt(type -> type.fields().size()).sum(), fingerprint);
    }

    private static Map<String, byte[]> readClasses(Path sdk) throws IOException {
        Map<String, byte[]> result = new TreeMap<>();
        if (Files.isDirectory(sdk)) {
            Path packageRoot = sdk.resolve("com/fairychar/bag");
            try (var paths = Files.walk(packageRoot)) {
                for (Path path : paths.filter(Files::isRegularFile).filter(path -> path.toString().endsWith(".class")).toList()) {
                    result.put(sdk.relativize(path).toString().replace('\\', '/'), Files.readAllBytes(path));
                }
            }
        } else {
            try (JarFile jar = new JarFile(sdk.toFile())) {
                for (var entry : jar.stream().filter(entry -> entry.getName().startsWith("com/fairychar/bag/"))
                        .filter(entry -> entry.getName().endsWith(".class")).toList()) {
                    try (var stream = jar.getInputStream(entry)) {
                        result.put(entry.getName(), stream.readAllBytes());
                    }
                }
            }
        }
        result.keySet().removeIf(name -> name.endsWith("package-info.class") || name.endsWith("module-info.class"));
        return result;
    }

    private static boolean isPublic(Class<?> type) {
        return Modifier.isPublic(type.getModifiers()) && (type.getEnclosingClass() == null || isPublic(type.getEnclosingClass()));
    }

    private static String annotationDefault(Method method) {
        Object value = method.getDefaultValue();
        if (value == null) {
            return "";
        }
        return " default " + defaultValue(value);
    }

    private static String defaultValue(Object value) {
        if (value.getClass().isArray()) {
            List<String> values = new ArrayList<>();
            for (int index = 0; index < java.lang.reflect.Array.getLength(value); index++) {
                values.add(defaultValue(java.lang.reflect.Array.get(value, index)));
            }
            return "{" + String.join(", ", values) + "}";
        }
        if (value instanceof Class<?> type) {
            return type.getCanonicalName() + ".class";
        }
        if (value instanceof Enum<?> constant) {
            return constant.getDeclaringClass().getCanonicalName() + "." + constant.name();
        }
        if (value instanceof String text) {
            return "\"" + text.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r") + "\"";
        }
        return String.valueOf(value);
    }

    private static Map<String, String> render(List<ApiType> types, String fingerprint) {
        Map<String, List<ApiType>> packages = new TreeMap<>();
        for (ApiType type : types) {
            packages.computeIfAbsent(type.type().getPackageName(), name -> new ArrayList<>()).add(type);
        }
        Map<String, String> documents = new TreeMap<>();
        StringBuilder catalog = new StringBuilder("# 公共 SDK API 索引\n\n");
        catalog.append("[返回使用指南](../fairychar-bag-usage-guide.md) · [API 查询与兼容边界](../features/setup/api-compatibility.md)\n\n");
        catalog.append("本目录由实际 SDK 字节码生成；只陈列可调用签名，不代表每项行为已验证。请按包定位后，再阅读关联的使用说明。\n\n");
        catalog.append("仅有签名不代表推荐接入；按类型的使用说明确认采用状态，基本语义未闭合的入口不默认采用。\n\n");
        catalog.append("## 覆盖边界\n\n");
        catalog.append("- 在下述排除范围之外，包含外部可访问的 public 顶层与嵌套类型、显式及生成的 public 构造器、当前类型声明的 public 方法与字段。\n");
        catalog.append("- 包含接口 default 方法、注解属性及默认值、枚举常量、Lombok 生成方法与枚举生成方法。\n");
        catalog.append("- 排除不可访问外部类中的类型、匿名类、局部类、synthetic 与 bridge 成员，以及非 public 成员。\n");
        catalog.append("- 排除 `com.fairychar.bag.aop` 包及子包的内部实现，即使类型或方法为 public 也不作为调用方 API。\n");
        catalog.append("- 排除约定的内部类型、废弃组件及其嵌套类型，范围见 [覆盖口径](../features/setup/api-compatibility.md)。\n");
        catalog.append("  请求日志和方法锁的使用方式见 [请求日志](../features/web/request-logging.md) 与 [方法锁](../features/locking/method-lock.md)；注解、配置和扩展接口仍保留。\n");
        catalog.append("- 继承方法通过父类/接口导航查找，不重复计数；第三方父类的 API 不展开，POM 与依赖坐标不索引。\n");
        catalog.append("- 不主动读取静态字段值；本索引不是线程安全、默认配置或运行行为证明。\n\n");
        catalog.append("## 快照\n\nSDK class 内容 SHA-256：`").append(fingerprint).append("`。\n\n");
        catalog.append("| public 类型 | public 构造器 | 声明的 public 方法 | public 字段/枚举常量 |\n| ---: | ---: | ---: | ---: |\n");
        catalog.append("| ").append(types.size()).append(" | ")
                .append(types.stream().mapToInt(type -> type.constructors().size()).sum()).append(" | ")
                .append(types.stream().mapToInt(type -> type.methods().size()).sum()).append(" | ")
                .append(types.stream().mapToInt(type -> type.fields().size()).sum()).append(" |\n\n");
        catalog.append("## 按包加载\n\n| 包 | 类型数 | 类型目录 |\n| --- | ---: | --- |\n");
        for (var entry : packages.entrySet()) {
            String packageName = entry.getKey();
            String fileName = packageFile(packageName);
            StringBuilder body = new StringBuilder("# `" + packageName + "`\n\n[返回 API 索引](README.md)\n\n");
            String names = entry.getValue().stream().map(type -> "[" + type.type().getSimpleName() + "](#" + anchor(type.type()) + ")")
                    .collect(java.util.stream.Collectors.joining(" · "));
            body.append(names).append("\n\n");
            List<String> declarationBodies = new ArrayList<>();
            for (ApiType api : entry.getValue()) {
                int declarationStart = body.length();
                Class<?> type = api.type();
                body.append("<a id=\"").append(anchor(type)).append("\"></a>\n\n## `").append(type.getCanonicalName()).append("`\n\n");
                body.append("类型声明：\n\n```java\n").append(type.toGenericString()).append("\n```\n\n");
                if (type.isAnnotationPresent(Deprecated.class)) {
                    body.append("**已废弃**：不建议新项目引入。\n\n");
                }
                body.append("使用说明：[").append(reference(type)).append("](../").append(reference(type)).append(")。\n\n");
                if (type.getGenericSuperclass() != null) {
                    body.append("父类：`").append(type.getGenericSuperclass().getTypeName()).append("`");
                    appendParentLink(body, type.getSuperclass());
                    body.append("。\n\n");
                }
                for (var parent : type.getGenericInterfaces()) {
                    body.append("接口：`").append(parent.getTypeName()).append("`。\n\n");
                }
                for (Class<?> parent : type.getInterfaces()) {
                    if (parent.getName().startsWith("com.fairychar.bag.")) {
                        body.append("继承接口导航：");
                        appendParentLink(body, parent);
                        body.append("。\n\n");
                    }
                }
                appendMembers(body, "public 构造器", api.constructors());
                appendMembers(body, "当前类型声明的 public 方法", api.methods());
                appendMembers(body, "public 字段 / 枚举常量", api.fields());
                declarationBodies.add(body.substring(declarationStart));
            }
            String catalogNames = names.replace("](#", "](" + fileName + "#");
            if (body.toString().getBytes(StandardCharsets.UTF_8).length > 12000) {
                StringBuilder packageIndex = new StringBuilder("# `" + packageName + "`\n\n[返回 API 索引](README.md)\n\n");
                List<String> directLinks = new ArrayList<>();
                for (int index = 0; index < entry.getValue().size(); index++) {
                    Class<?> type = entry.getValue().get(index).type();
                    String declarationFile = fileName.replace(".md", "--")
                            + type.getName().substring(packageName.length() + 1).replace('$', '-').toLowerCase(java.util.Locale.ROOT) + ".md";
                    String directLink = "[" + type.getSimpleName() + "](" + declarationFile + "#" + anchor(type) + ")";
                    directLinks.add(directLink);
                    packageIndex.append("<a id=\"").append(anchor(type)).append("\"></a>\n\n- ").append(directLink).append("\n\n");
                    documents.put(declarationFile, "# `" + type.getCanonicalName() + "`\n\n[返回包目录](" + fileName + ")\n\n" + declarationBodies.get(index));
                }
                documents.put(fileName, packageIndex.toString());
                catalogNames = String.join(" · ", directLinks);
            } else {
                documents.put(fileName, body.toString());
            }
            catalog.append("| [`").append(packageName).append("`](").append(fileName).append(") | ")
                    .append(entry.getValue().size()).append(" | ").append(catalogNames).append(" |\n");
        }
        documents.put("README.md", catalog.toString());
        return documents;
    }

    private static void appendParentLink(StringBuilder body, Class<?> parent) {
        if (parent != null && parent.getName().startsWith("com.fairychar.bag.") && isPublic(parent)) {
            body.append(" [查看声明](").append(packageFile(parent.getPackageName())).append("#").append(anchor(parent)).append(")");
        }
    }

    private static void appendMembers(StringBuilder body, String title, List<String> members) {
        body.append("### ").append(title).append("\n\n");
        if (members.isEmpty()) {
            body.append("无。\n\n");
        } else {
            body.append("```java\n").append(String.join("\n", members)).append("\n```\n\n");
        }
    }

    private static String packageFile(String packageName) {
        return packageName.substring("com.fairychar.bag".length()).replaceFirst("^\\.", "").replace('.', '-') + ".md";
    }

    private static String anchor(Class<?> type) {
        return type.getName().substring("com.fairychar.bag.".length()).replace('.', '-').replace('$', '-').toLowerCase(java.util.Locale.ROOT);
    }

    private static String reference(Class<?> type) {
        return switch (type.getCanonicalName()) {
            case "com.fairychar.bag.beans.aop.IgnoreContentLoggingHandler",
                    "com.fairychar.bag.beans.aop.JsonLoggingHandler",
                    "com.fairychar.bag.beans.aop.LoggingHandler",
                    "com.fairychar.bag.beans.aop.SimpleLoggingHanlder",
                    "com.fairychar.bag.beans.aop.SwaggerLoggingHandler",
                    "com.fairychar.bag.domain.annotations.RequestLog.Level",
                    "com.fairychar.bag.domain.annotations.RequestLog" -> "features/web/request-logging.md";
            case "com.fairychar.bag.beans.mybatis.handler.AesTypeHandler",
                    "com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler" -> "features/data/mybatis-crypto.md";
            case "com.fairychar.bag.beans.mybatis.interceptor.ITenantSkipper",
                    "com.fairychar.bag.beans.mybatis.interceptor.ITenantSwitcher",
                    "com.fairychar.bag.beans.mybatis.interceptor.SimpleTenantSkipper",
                    "com.fairychar.bag.beans.mybatis.interceptor.SkipableTenantLineInnerInterceptor",
                    "com.fairychar.bag.beans.mybatis.interceptor.SwitchableTenantLineInnerInterceptor",
                    "com.fairychar.bag.beans.mybatis.interceptor.TenantSwitcher" -> "features/data/tenant-isolation.md";
            case "com.fairychar.bag.beans.netty.client.SimpleNettyClient" -> "features/netty/client.md";
            case "com.fairychar.bag.beans.netty.decoder.DelimitersHeadTailFrameDecoder",
                    "com.fairychar.bag.domain.netty.frame.HeadTailFrame" -> "features/netty/frame-decoder.md";
            case "com.fairychar.bag.beans.netty.server.SimpleNettyServer",
                    "com.fairychar.bag.domain.enums.RunState" -> "features/netty/server.md";
            case "com.fairychar.bag.beans.redis.GzipStringSerializer" -> "features/data/redis-gzip.md";
            case "com.fairychar.bag.beans.redis.PrefixStringSerializer" -> "features/data/redis-prefix.md";
            case "com.fairychar.bag.beans.spring.mvc.EraseValue" -> "features/field-processing/erase-value.md";
            case "com.fairychar.bag.beans.spring.mvc.FuzzyResult",
                    "com.fairychar.bag.beans.spring.mvc.FuzzyValue" -> "features/field-processing/fuzzy-value.md";
            case "com.fairychar.bag.beans.spring.mvc.KeepValue",
                    "com.fairychar.bag.beans.spring.mvc.PropertyValueAdvice" -> "features/field-processing/keep-value.md";
            case "com.fairychar.bag.domain.abstracts.AbstractBalkingReference",
                    "com.fairychar.bag.domain.concurrent.IBalkingReference" -> "features/concurrency/balking-reference.md";
            case "com.fairychar.bag.domain.abstracts.AbstractScheduleAction",
                    "com.fairychar.bag.extension.concurrent.ActionSchedule" -> "features/concurrency/action-schedule.md";
            case "com.fairychar.bag.domain.annotations.CauseHandler",
                    "com.fairychar.bag.domain.annotations.EventHandler",
                    "com.fairychar.bag.domain.annotations.NettyCauseAdvice",
                    "com.fairychar.bag.domain.annotations.NettyEventAdvice" -> "features/netty/handler-annotations.md";
            case "com.fairychar.bag.domain.annotations.MethodLock.Type",
                    "com.fairychar.bag.domain.annotations.MethodLock" -> "features/locking/method-lock.md";
            case "com.fairychar.bag.domain.conditional.ConditionalOnDateTime",
                    "com.fairychar.bag.domain.conditional.ConditionalOnPingHost",
                    "com.fairychar.bag.domain.conditional.ConditionalOnRandomNumber",
                    "com.fairychar.bag.domain.conditional.ConditionalOnSystemOS.OS",
                    "com.fairychar.bag.domain.conditional.ConditionalOnSystemOS",
                    "com.fairychar.bag.domain.conditional.ConditionalOnSystemProperty" -> "features/setup/conditional-beans.md";
            case "com.fairychar.bag.domain.exceptions.AcceptedException",
                    "com.fairychar.bag.domain.exceptions.DataAlreadyExistException",
                    "com.fairychar.bag.domain.exceptions.FBException",
                    "com.fairychar.bag.domain.exceptions.RestException" -> "features/web/exception-handling.md";
            case "com.fairychar.bag.domain.exceptions.FailToGetLockException",
                    "com.fairychar.bag.utils.RedisLockUtil" -> "features/locking/redis-lock.md";
            case "com.fairychar.bag.domain.exceptions.IRestErrorCode",
                    "com.fairychar.bag.domain.exceptions.RestErrorCode" -> "features/web/error-code.md";
            case "com.fairychar.bag.domain.exceptions.ParamErrorException",
                    "com.fairychar.bag.utils.BindingResultUtil" -> "features/validation/binding-result.md";
            case "com.fairychar.bag.domain.spring.expression.SimpleEvaluationContext",
                    "com.fairychar.bag.domain.spring.expression.SimpleExpressionRootObject",
                    "com.fairychar.bag.utils.SpelUtil" -> "features/utilities/spel.md";
            case "com.fairychar.bag.listener.SpringContextHolder" -> "features/setup/spring-context.md";
            case "com.fairychar.bag.domain.validator.rest.DateBetween",
                    "com.fairychar.bag.domain.validator.rest.DateValidator",
                    "com.fairychar.bag.domain.validator.rest.EndWith",
                    "com.fairychar.bag.domain.validator.rest.EndWithValidator",
                    "com.fairychar.bag.domain.validator.rest.FileSize.Unit",
                    "com.fairychar.bag.domain.validator.rest.FileSize",
                    "com.fairychar.bag.domain.validator.rest.FileSizeValidator",
                    "com.fairychar.bag.domain.validator.rest.IdCard",
                    "com.fairychar.bag.domain.validator.rest.IdCardValidator",
                    "com.fairychar.bag.domain.validator.rest.In",
                    "com.fairychar.bag.domain.validator.rest.InValidator",
                    "com.fairychar.bag.domain.validator.rest.IP",
                    "com.fairychar.bag.domain.validator.rest.IpValidator",
                    "com.fairychar.bag.domain.validator.rest.Language.LanguageType",
                    "com.fairychar.bag.domain.validator.rest.Language",
                    "com.fairychar.bag.domain.validator.rest.LanguageValidator",
                    "com.fairychar.bag.domain.validator.rest.NotIn",
                    "com.fairychar.bag.domain.validator.rest.NotInValidator",
                    "com.fairychar.bag.domain.validator.rest.Phone",
                    "com.fairychar.bag.domain.validator.rest.PhoneValidator",
                    "com.fairychar.bag.domain.validator.rest.StartWith",
                    "com.fairychar.bag.domain.validator.rest.StartWithValidator",
                    "com.fairychar.bag.domain.validator.rest.TimeBetween",
                    "com.fairychar.bag.domain.validator.rest.TimeValidator",
                    "com.fairychar.bag.domain.validator.rest.Url",
                    "com.fairychar.bag.domain.validator.rest.UrlValidator",
                    "com.fairychar.bag.domain.validator.rest.abstracts.AbstractPatternValidator",
                    "com.fairychar.bag.domain.validator.rest.group.DeleteVali",
                    "com.fairychar.bag.domain.validator.rest.group.IdVali",
                    "com.fairychar.bag.domain.validator.rest.group.InsertOrUpdateVali",
                    "com.fairychar.bag.domain.validator.rest.group.InsertVali",
                    "com.fairychar.bag.domain.validator.rest.group.SearchVali",
                    "com.fairychar.bag.domain.validator.rest.group.UniqueVali",
                    "com.fairychar.bag.domain.validator.rest.group.UpdateVali" -> "features/validation/constraints.md";
            case "com.fairychar.bag.domain.Consts.OAuth2",
                    "com.fairychar.bag.domain.Consts.Regex",
                    "com.fairychar.bag.domain.Consts" -> "features/utilities/constants.md";
            case "com.fairychar.bag.domain.Singletons.GsonBean",
                    "com.fairychar.bag.domain.Singletons.JsonBean",
                    "com.fairychar.bag.domain.Singletons.PathMatcherBean",
                    "com.fairychar.bag.domain.Singletons.RandomBean",
                    "com.fairychar.bag.domain.Singletons.RestTemplateBean",
                    "com.fairychar.bag.domain.Singletons" -> "features/setup/shared-objects.md";
            case "com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow",
                    "com.fairychar.bag.extension.action.condition.bool.ActionFlow",
                    "com.fairychar.bag.extension.action.condition.bool.FlowBuilder",
                    "com.fairychar.bag.extension.action.condition.bool.ParentActionCondition",
                    "com.fairychar.bag.extension.action.condition.bool.RootAction" -> "features/extensions/action-flow.md";
            case "com.fairychar.bag.extension.calculator.BaseCalculator",
                    "com.fairychar.bag.extension.calculator.Operator",
                    "com.fairychar.bag.function.IDataBaseShardingProcessor",
                    "com.fairychar.bag.function.IShardingProcessor",
                    "com.fairychar.bag.function.ITableShardingProcessor" -> "features/extensions/sharding.md";
            case "com.fairychar.bag.extension.collection.BiPredicateList" -> "features/utilities/predicate-list.md";
            case "com.fairychar.bag.extension.concurrent.AssignableFactory" -> "features/concurrency/weighted-permits.md";
            case "com.fairychar.bag.extension.concurrent.RepeatTaskExecutor" -> "features/concurrency/repeat-tasks.md";
            case "com.fairychar.bag.extension.concurrent.RoundTaskExecutor" -> "features/concurrency/round-tasks.md";
            case "com.fairychar.bag.extension.request.CloneServletInputStream",
                    "com.fairychar.bag.extension.request.ClonedServletRequest",
                    "com.fairychar.bag.extension.request.EmptyServletRequest" -> "features/web/request-wrapper.md";
            case "com.fairychar.bag.function.Action" -> "features/function/action.md";
            case "com.fairychar.bag.pojo.ao.MapObjectNode",
                    "com.fairychar.bag.pojo.ao.MappingAO",
                    "com.fairychar.bag.pojo.ao.MappingObjectAO",
                    "com.fairychar.bag.pojo.ao.TreeNode",
                    "com.fairychar.bag.utils.MappingObjectUtil" -> "features/utilities/tree-mapping.md";
            case "com.fairychar.bag.pojo.dto.KeyValuePair",
                    "com.fairychar.bag.pojo.query.body.ByteBodyQuery",
                    "com.fairychar.bag.pojo.query.body.ByteListQuery",
                    "com.fairychar.bag.pojo.query.body.IntegerBodyQuery",
                    "com.fairychar.bag.pojo.query.body.IntegerListQuery",
                    "com.fairychar.bag.pojo.query.body.LongBodyQuery",
                    "com.fairychar.bag.pojo.query.body.LongListQuery",
                    "com.fairychar.bag.pojo.query.body.ShortBodyQuery",
                    "com.fairychar.bag.pojo.query.body.ShortListQuery",
                    "com.fairychar.bag.pojo.query.body.StringBodyQuery",
                    "com.fairychar.bag.pojo.query.body.StringListQuery",
                    "com.fairychar.bag.pojo.query.DateBetweenQuery",
                    "com.fairychar.bag.pojo.query.SimpleTypeQuery",
                    "com.fairychar.bag.pojo.query.TimeBetweenQuery" -> "features/web/request-models.md";
            case "com.fairychar.bag.pojo.vo.HttpResult" -> "features/web/http-result.md";
            case "com.fairychar.bag.properties.AopProperties.Lock",
                    "com.fairychar.bag.properties.AopProperties.Log",
                    "com.fairychar.bag.properties.AopProperties",
                    "com.fairychar.bag.properties.FairycharBagProperties",
                    "com.fairychar.bag.properties.NettyServerClientProperties.ClientProperties",
                    "com.fairychar.bag.properties.NettyServerClientProperties.ServerProperties",
                    "com.fairychar.bag.properties.NettyServerClientProperties",
                    "com.fairychar.bag.properties.SecretProperties.AesProperties",
                    "com.fairychar.bag.properties.SecretProperties.RsaProperties",
                    "com.fairychar.bag.properties.SecretProperties",
                    "com.fairychar.bag.properties.WebProperties.Advice",
                    "com.fairychar.bag.properties.WebProperties.PropertyProcessor",
                    "com.fairychar.bag.properties.WebProperties" -> "features/setup/configuration.md";
            case "com.fairychar.bag.proxy.FeignFallbackProxy" -> "features/web/feign-fallback.md";
            case "com.fairychar.bag.template.ActionSelectorTemplate" -> "features/concurrency/task-selector.md";
            case "com.fairychar.bag.template.CacheOperateTemplate" -> "features/data/cache-read-through.md";
            case "com.fairychar.bag.utils.CircularTaskUtil" -> "features/concurrency/polling.md";
            case "com.fairychar.bag.utils.CollectionUtil" -> "features/utilities/collection-split.md";
            case "com.fairychar.bag.utils.ConcurrentUtil" -> "features/concurrency/future-wait.md";
            case "com.fairychar.bag.utils.DateConvertUtil" -> "features/utilities/date-time.md";
            case "com.fairychar.bag.utils.FileUtil" -> "features/utilities/file-operations.md";
            case "com.fairychar.bag.utils.ReflectUtil" -> "features/utilities/reflection.md";
            case "com.fairychar.bag.utils.RequestUtil" -> "features/utilities/request-context.md";
            case "com.fairychar.bag.utils.StringUtil" -> "features/utilities/string.md";
            case "com.fairychar.bag.utils.TransactionUtil" -> "features/concurrency/async-transactions.md";
            case "com.fairychar.bag.utils.base.FieldContainer" -> "features/utilities/reflection.md";
            case "com.fairychar.bag.utils.test.TaskTestUtil" -> "features/concurrency/task-test.md";
            default -> "features/setup/api-compatibility.md";
        };
    }
}
