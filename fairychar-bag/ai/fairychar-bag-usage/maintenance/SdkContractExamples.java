import com.fairychar.bag.beans.mybatis.handler.AesTypeHandler;
import com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler;
import com.fairychar.bag.beans.mybatis.interceptor.SimpleTenantSkipper;
import com.fairychar.bag.beans.redis.GzipStringSerializer;
import com.fairychar.bag.beans.redis.PrefixStringSerializer;
import com.fairychar.bag.domain.exceptions.FBException;
import com.fairychar.bag.domain.exceptions.FailToGetLockException;
import com.fairychar.bag.domain.exceptions.ParamErrorException;
import com.fairychar.bag.pojo.ao.TreeNode;
import com.fairychar.bag.template.CacheOperateTemplate;
import com.fairychar.bag.utils.BindingResultUtil;
import com.fairychar.bag.utils.CircularTaskUtil;
import com.fairychar.bag.utils.CollectionUtil;
import com.fairychar.bag.utils.ConcurrentUtil;
import com.fairychar.bag.utils.DateConvertUtil;
import com.fairychar.bag.utils.MappingObjectUtil;
import com.fairychar.bag.utils.RedisLockUtil;
import com.fairychar.bag.utils.RequestUtil;
import com.fairychar.bag.utils.SpelUtil;
import com.fairychar.bag.utils.StringUtil;
import org.apache.ibatis.type.JdbcType;
import org.redisson.api.RLock;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;

import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SdkContractExamples {
    public static void main(String[] args) throws Exception {
        verifyStrings();
        verifySerializers();
        verifyDates();
        verifyCollections();
        verifyMappings();
        verifyCache();
        verifyLocks();
        verifyContext();
        verifyFutures();
        verifyLoopLimit();
        verifyMybatisEmptyValues();
        System.out.println("JAR-only contract examples passed: 11 scenarios; no SDK source or external service required");
    }

    private static void verifyStrings() throws Exception {
        require(" ".equals(StringUtil.defaultText(" ", "fallback")), "Whitespace is not empty");
        require(StringUtil.defaultText(null, null) == null, "Fallback may be null");
        require("abc".equals(StringUtil.decompressByGzip(StringUtil.compressByGzip("a\nb\r\nc"))), "Newlines removed");
        expect(NullPointerException.class, () -> StringUtil.compressByGzip(null));
        expect(FBException.class, () -> StringUtil.decompressByGzip(new byte[0]));
    }

    private static void verifySerializers() throws Exception {
        GzipStringSerializer gzip = new GzipStringSerializer();
        require(gzip.serialize(null) == null && gzip.deserialize(null) == null, "Gzip null");
        require(gzip.deserialize(new byte[0]) == null && "".equals(gzip.deserialize(gzip.serialize(""))), "Empty bytes vs text");
        require("ab".equals(gzip.deserialize(gzip.serialize("a\nb"))), "Serializer newline loss");
        expect(FBException.class, () -> gzip.deserialize("plain".getBytes(StandardCharsets.UTF_8)));
        PrefixStringSerializer prefix = new PrefixStringSerializer("app:");
        require("app:id".equals(prefix.deserialize(prefix.serialize("id"))), "Prefix remains");
        require("app:".equals(prefix.deserialize(prefix.serialize(""))), "Empty key is prefixed");
        require(prefix.serialize(null) == null && prefix.deserialize(new byte[0]) == null, "Prefix null");
        expect(NullPointerException.class, () -> new PrefixStringSerializer(null).serialize("id"));
        expect(BeanCreationException.class, () -> new PrefixStringSerializer(StandardCharsets.UTF_8, null));
    }

    private static void verifyDates() throws Exception {
        require(LocalDate.of(2026, 2, 28).equals(DateConvertUtil.parseDate("2026-02-30")), "SMART date correction");
        require(DateConvertUtil.parseDate("not-a-date") == null, "Unparseable date");
        require(DateConvertUtil.parseDate(" 2026-01-02 ") == null, "No trim");
        expect(IllegalArgumentException.class, () -> DateConvertUtil.parseDate(" "));
        expect(IllegalArgumentException.class, () -> DateConvertUtil.parseTime(null));
        expect(NullPointerException.class, () -> DateConvertUtil.localdateToDate(null));
    }

    private static void verifyCollections() {
        List<Integer> source = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<List<Integer>> parts = CollectionUtil.splitList(source, 2);
        require(parts.equals(List.of(List.of(1, 2, 3), List.of(4, 5))), "Balanced split");
        parts.getFirst().clear();
        require(source.size() == 5, "Structural independence");
        require(CollectionUtil.splitList(List.of(1), 3).equals(List.of(List.of(1), List.of(), List.of())), "Padding");
    }

    private static void verifyMappings() {
        Node root = new Node(1, 0);
        Node leaf = new Node(2, 1);
        List<Node> source = List.of(root, leaf);
        List<TreeNode<Node>> wrapped = MappingObjectUtil.listToTree(source, "parentId", "id", 0);
        require(wrapped.size() == 1 && wrapped.getFirst().getCurrent() == root, "Shared current node");
        require(wrapped.getFirst().getChild().getFirst().getCurrent() == leaf, "Wrapped child");
        List<Node> stale = new ArrayList<>();
        leaf.children = stale;
        MappingObjectUtil.listToTree(source, "parentId", "id", "children", 0);
        require(root.children.getFirst() == leaf && leaf.children == stale, "Leaves not cleared");
    }

    private static void verifyCache() throws Exception {
        AtomicInteger reads = new AtomicInteger();
        List<String> writes = new ArrayList<>();
        String value = CacheOperateTemplate.get(() -> { reads.incrementAndGet(); return null; }, () -> "db", writes::add, new Object());
        require("db".equals(value) && reads.get() == 2 && writes.equals(List.of("db")), "Cache double read");
        writes.clear();
        require(CacheOperateTemplate.<String>get(() -> null, () -> null, writes::add, new Object()) == null
                && writes.isEmpty(), "No null cache");
        expect(IllegalStateException.class, () -> CacheOperateTemplate.get(() -> null, () -> "db",
                result -> { throw new IllegalStateException("write failed"); }, new Object()));
    }

    private static void verifyLocks() throws Exception {
        List<String> calls = new ArrayList<>();
        RLock lock = (RLock) Proxy.newProxyInstance(RLock.class.getClassLoader(), new Class<?>[]{RLock.class},
                (proxy, method, arguments) -> {
                    calls.add(method.getName());
                    return switch (method.getName()) {
                        case "tryLock" -> false;
                        case "isHeldByCurrentThread" -> true;
                        default -> null;
                    };
                });
        RedisLockUtil.lock(lock, () -> calls.add("before"), () -> calls.add("again"), () -> calls.add("action"),
                2, TimeUnit.SECONDS);
        require(calls.equals(List.of("before", "lock", "again", "action", "isHeldByCurrentThread", "unlock")), "Lock order");
        calls.clear();
        expect(FailToGetLockException.class, () -> RedisLockUtil.tryLock(lock, () -> calls.add("action")));
        require(!calls.contains("action") && calls.contains("unlock"), "Failed acquire and pre-held lock release");
        calls.clear();
        expect(IllegalStateException.class, () -> RedisLockUtil.lock(lock,
                () -> { throw new IllegalStateException("before failed"); }, () -> {}, () -> {}));
        require(calls.equals(List.of("isHeldByCurrentThread", "unlock")), "Before failure can release outer lock");
    }

    private static void verifyContext() throws Exception {
        RequestContextHolder.resetRequestAttributes();
        expect(FBException.class, RequestUtil::getCurrentRequest);
        Object result = SpelUtil.eval("'order:' + #p0", SdkContractExamples.class.getMethod("sample", String.class),
                new Object[]{"42"}, String.class);
        require("order:42".equals(result), "Positional expression");
        Object unconverted = SpelUtil.eval("1 + 1", SdkContractExamples.class.getMethod("sample", String.class),
                new Object[]{"42"}, String.class);
        require(unconverted instanceof Integer, "returnType does not convert");
        BeanPropertyBindingResult binding = new BeanPropertyBindingResult(new Object(), "query");
        BindingResultUtil.checkBindingErrors(binding);
        binding.addError(new FieldError("query", "name", "required"));
        expect(ParamErrorException.class, () -> BindingResultUtil.checkBindingErrors(binding));
    }

    private static void verifyFutures() throws Exception {
        CompletableFuture<Object> pending = new CompletableFuture<>();
        List<Future> futures = List.of(CompletableFuture.failedFuture(new IllegalStateException("failed")), pending);
        expect(FBException.class, () -> ConcurrentUtil.getFutures(futures));
        require(!pending.isCancelled() && !pending.isDone(), "No cancellation of remaining futures");
        CompletableFuture<Object> cancelled = new CompletableFuture<>();
        cancelled.cancel(false);
        expect(java.util.concurrent.CancellationException.class, () -> ConcurrentUtil.getFutures(List.of(cancelled)));
    }

    private static void verifyLoopLimit() {
        AtomicInteger count = new AtomicInteger();
        boolean matched = CircularTaskUtil.run(() -> { count.incrementAndGet(); return false; }, true, 2, 0);
        require(!matched && count.get() == 3, "Round limit is N plus one");
    }

    private static void verifyMybatisEmptyValues() throws Exception {
        List<String> calls = new ArrayList<>();
        PreparedStatement statement = (PreparedStatement) Proxy.newProxyInstance(PreparedStatement.class.getClassLoader(),
                new Class<?>[]{PreparedStatement.class}, (proxy, method, arguments) -> {
                    calls.add(method.getName());
                    return null;
                });
        new AesTypeHandler().setNonNullParameter(statement, 1, "", JdbcType.VARCHAR);
        require(calls.equals(List.of("setString")), "AES writes empty string");
        calls.clear();
        new RsaTypeHandler().setNonNullParameter(statement, 1, "", JdbcType.VARCHAR);
        require(calls.isEmpty(), "RSA does not bind empty string");
        SimpleTenantSkipper skipper = new SimpleTenantSkipper();
        try {
            require(skipper.getSkip(), "Default skips tenant");
            skipper.setSkip(false);
            require(!skipper.getSkip(), "Explicit enable tenant");
            skipper.cleanContext();
            require(skipper.getSkip(), "Clean restores skip default");
        } finally {
            skipper.cleanContext();
        }
    }

    public static void sample(String value) {}

    private static void require(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void expect(Class<? extends Throwable> expected, Probe probe) throws Exception {
        try {
            probe.run();
        } catch (Throwable error) {
            if (expected.isInstance(error)) {
                return;
            }
            throw new AssertionError("Expected " + expected.getName() + " but got " + error, error);
        }
        throw new AssertionError("Expected " + expected.getName());
    }

    private interface Probe {
        void run() throws Exception;
    }

    public static class Node {
        public Integer id;
        public Integer parentId;
        public List<Node> children;

        Node(Integer id, Integer parentId) {
            this.id = id;
            this.parentId = parentId;
        }
    }
}
