import com.example.sdkdemo.controller.SdkQuickStartController;
import com.fairychar.bag.beans.spring.advice.DefaultExceptionAdvice;
import com.fairychar.bag.beans.spring.mvc.EraseValue;
import com.fairychar.bag.beans.spring.mvc.EraseValueAdvice;
import com.fairychar.bag.beans.spring.mvc.FuzzyValueAdvice;
import com.fairychar.bag.beans.spring.mvc.KeepValue;
import com.fairychar.bag.beans.spring.mvc.KeepValueAdvice;
import com.fairychar.bag.domain.Consts;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.domain.exceptions.RestException;
import com.fairychar.bag.extension.collection.BiPredicateList;
import com.fairychar.bag.function.ITableShardingProcessor;
import com.fairychar.bag.pojo.vo.HttpResult;
import com.fairychar.bag.proxy.FeignFallbackProxy;
import com.fairychar.bag.utils.DateConvertUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class SdkUsageExamples {

    public static void main(String[] args) throws Exception {
        verifyDefaultErase();
        verifyDefaultKeep();
        verifyGroupedFields();
        verifyDuplicateGroups();
        verifyQuickStart();
        verifyListReplacement();
        verifyDateConversion();
        verifySharding();
        verifyFallback();
        verifyConstants();
        System.out.println("SDK examples passed: 10 scenarios");
    }

    private static void verifyConstants() throws Exception {
        if (Math.multiplyExact(10L, Consts.MB_PER_B) != 10485760L
                || !LocalDateTime.of(2026, 1, 2, 3, 4, 5).format(Consts.SIMPLE_DATE_TIME_FORMATTER)
                .equals("2026-01-02 03:04:05")
                || !"client_credentials".equals(Consts.OAuth2.CLIENT_CREDENTIALS)
                || !"999.999.999.999".matches(Consts.Regex.IP)
                || "https://example.com:8443/path?q=1".matches(Consts.Regex.URL)) {
            throw new AssertionError("Constant values or documented usage boundaries differ");
        }
        if (Consts.class.getField("TB_PER_B").getLong(null) != 0L
                || Consts.class.getField("PB_PER_B").getLong(null) != 0L) {
            throw new AssertionError("Recheck capacity constant limitations against the actual SDK");
        }
        long documentedFields = java.util.stream.Stream.of(Consts.class, Consts.OAuth2.class, Consts.Regex.class)
                .flatMap(type -> java.util.Arrays.stream(type.getDeclaredFields()))
                .filter(field -> java.lang.reflect.Modifier.isPublic(field.getModifiers())).count();
        if (documentedFields != 20L) {
            throw new AssertionError("Update the constant guide for the SDK field inventory");
        }
    }

    private static void verifyDefaultErase() throws Exception {
        Fields body = new Fields();
        new EraseValueAdvice().afterBodyRead(body, null, parameter("erase"), Fields.class, StringHttpMessageConverter.class);
        require(body.name == null && "admin".equals(body.roleCode) && "plain".equals(body.plain), "default erase");
    }

    private static void verifyDefaultKeep() throws Exception {
        Fields body = new Fields();
        new KeepValueAdvice().afterBodyRead(body, null, parameter("keep"), Fields.class, StringHttpMessageConverter.class);
        require("Alice".equals(body.name) && body.roleCode == null && body.plain == null, "default keep");
    }

    private static void verifyGroupedFields() throws Exception {
        Fields erased = new Fields();
        new EraseValueAdvice().afterBodyRead(erased, null, parameter("eraseAdmin"), Fields.class, StringHttpMessageConverter.class);
        require("Alice".equals(erased.name) && erased.roleCode == null && "plain".equals(erased.plain), "grouped erase");
        Fields kept = new Fields();
        new KeepValueAdvice().afterBodyRead(kept, null, parameter("keepAdmin"), Fields.class, StringHttpMessageConverter.class);
        require(kept.name == null && "admin".equals(kept.roleCode) && kept.plain == null, "grouped keep");
    }

    private static void verifyDuplicateGroups() throws Exception {
        Fields body = new Fields();
        new EraseValueAdvice().afterBodyRead(body, null, parameter("eraseDuplicate"), Fields.class, StringHttpMessageConverter.class);
        require("admin".equals(body.roleCode), "duplicate groups are not an intersection");
    }

    private static void verifyQuickStart() throws Exception {
        SdkQuickStartController controller = new SdkQuickStartController();
        SdkQuickStartController.CreateUserQuery query = new SdkQuickStartController.CreateUserQuery();
        query.name = "Alice";
        query.roleCode = "admin";
        MethodParameter request = new MethodParameter(SdkQuickStartController.class.getMethod("create", query.getClass()), 0);
        new KeepValueAdvice().afterBodyRead(query, null, request, query.getClass(), StringHttpMessageConverter.class);
        require(controller.create(query).getData().roleCode == null, "quick-start field whitelist");
        HttpResult<SdkQuickStartController.ContactVO> response = controller.contact();
        MethodParameter result = new MethodParameter(SdkQuickStartController.class.getMethod("contact"), -1);
        new FuzzyValueAdvice().beforeBodyWrite(response, result, MediaType.APPLICATION_JSON,
                StringHttpMessageConverter.class, null, null);
        require("138****5678".equals(response.getData().phone), "quick-start response masking");
        try {
            controller.failure();
            throw new AssertionError("quick-start should throw a business exception");
        } catch (RestException exception) {
            HttpResult<?> failed = new DefaultExceptionAdvice().handleRestException(exception);
            require(failed.getCode() == RestErrorCode.DATA_NOT_EXIST.getCode(), "quick-start error code");
        }
    }

    private static void verifyListReplacement() {
        BiPredicateList<String> names = new BiPredicateList<>(List.of("alice"), String::equalsIgnoreCase);
        names.add("ALICE");
        names.add("Bob");
        require(names.size() == 2 && "ALICE".equals(names.getFirst()), "predicate list replacement");
    }

    private static void verifyDateConversion() {
        LocalDateTime local = LocalDateTime.of(2026, 1, 2, 3, 4, 5);
        Date date = Date.from(local.atZone(ZoneId.systemDefault()).toInstant());
        require(local.equals(DateConvertUtil.dateToLocaldateTime(date)), "date/time round trip");
        require(LocalDate.of(2026, 1, 2).equals(DateConvertUtil.dateToLocaldate(date)), "date conversion");
        LocalDate day = LocalDate.of(2026, 1, 2);
        require(day.equals(DateConvertUtil.dateToLocaldate(DateConvertUtil.localdateToDate(day))), "local date round trip");
        require(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().equals(local), "system timezone contract");
    }

    private static void verifySharding() {
        ITableShardingProcessor<Integer, String> processor = key -> Math.floorMod(key.hashCode(), 4);
        int shard = processor.calculate("order-123");
        require(shard >= 0 && shard < 4, "explicit sharding implementation");
    }

    private static void verifyFallback() {
        FallbackClient client = FeignFallbackProxy.createDefault(FallbackClient.class, new IllegalStateException("unavailable"));
        ResponseEntity<HttpResult<String>> response = client.load();
        require(response.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE, "fallback HTTP status");
        require(response.getBody() != null && response.getBody().getCode() == RestErrorCode.FALLBACK.getCode(), "fallback body");
    }

    private static MethodParameter parameter(String name) throws Exception {
        return new MethodParameter(Endpoints.class.getDeclaredMethod(name, Fields.class), 0);
    }

    private static void require(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public interface FallbackClient {
        ResponseEntity<HttpResult<String>> load();
    }

    private interface AdminGroup {}

    private interface OtherGroup {}

    private static class Fields {
        @EraseValue
        @KeepValue
        private String name = "Alice";
        @EraseValue(AdminGroup.class)
        @KeepValue(AdminGroup.class)
        private String roleCode = "admin";
        private String plain = "plain";
    }

    private static class Endpoints {
        void erase(@EraseValue Fields body) {}

        void keep(@KeepValue Fields body) {}

        void eraseAdmin(@EraseValue(AdminGroup.class) Fields body) {}

        void keepAdmin(@KeepValue(AdminGroup.class) Fields body) {}

        void eraseDuplicate(@EraseValue({OtherGroup.class, OtherGroup.class}) Fields body) {}
    }
}
