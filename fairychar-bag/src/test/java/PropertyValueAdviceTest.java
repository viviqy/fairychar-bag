import com.fairychar.bag.beans.spring.mvc.EraseValue;
import com.fairychar.bag.beans.spring.mvc.EraseValueAdvice;
import com.fairychar.bag.beans.spring.mvc.KeepValue;
import com.fairychar.bag.beans.spring.mvc.KeepValueAdvice;
import com.fairychar.bag.beans.spring.mvc.PropertyValueAdvice;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.MethodParameter;

public class PropertyValueAdviceTest {

    @Test
    public void eraseDefaultGroup() throws Exception {
        RequestBody body = apply(new EraseValueAdvice(), "eraseDefault");

        Assert.assertNull(body.defaultValue);
        Assert.assertEquals("admin", body.adminValue);
        Assert.assertEquals("plain", body.plainValue);
    }

    @Test
    public void eraseMatchingGroupsOnly() throws Exception {
        RequestBody body = apply(new EraseValueAdvice(), "eraseAdmin");

        Assert.assertEquals("default", body.defaultValue);
        Assert.assertNull(body.adminValue);
        Assert.assertNull(body.multiValue);
        Assert.assertEquals("other", body.otherValue);
        Assert.assertEquals("duplicate", body.duplicateValue);
        Assert.assertEquals("plain", body.plainValue);
    }

    @Test
    public void duplicateParameterGroupsDoNotMatchOtherGroups() throws Exception {
        RequestBody body = apply(new EraseValueAdvice(), "eraseDuplicateAdmin");

        Assert.assertNull(body.adminValue);
        Assert.assertEquals("other", body.otherValue);
        Assert.assertEquals("duplicate", body.duplicateValue);
    }

    @Test
    public void keepDefaultGroupAndEraseUnannotatedFields() throws Exception {
        RequestBody body = apply(new KeepValueAdvice(), "keepDefault");

        Assert.assertEquals("default", body.defaultValue);
        Assert.assertNull(body.adminValue);
        Assert.assertNull(body.otherValue);
        Assert.assertNull(body.multiValue);
        Assert.assertNull(body.duplicateValue);
        Assert.assertNull(body.plainValue);
    }

    @Test
    public void keepMatchingGroupsOnly() throws Exception {
        RequestBody body = apply(new KeepValueAdvice(), "keepAdmin");

        Assert.assertNull(body.defaultValue);
        Assert.assertEquals("admin", body.adminValue);
        Assert.assertEquals("multi", body.multiValue);
        Assert.assertNull(body.otherValue);
        Assert.assertNull(body.duplicateValue);
        Assert.assertNull(body.plainValue);
    }

    @Test
    public void keepDoesNotModifyStaticOrFinalFields() throws Exception {
        RequestBody body = apply(new KeepValueAdvice(), "keepDefault");

        Assert.assertEquals("static", RequestBody.staticValue);
        Assert.assertEquals("final", body.finalValue);
    }

    @Test
    public void eraseDoesNotModifyStaticOrFinalFields() throws Exception {
        RequestBody body = apply(new EraseValueAdvice(), "eraseDefault");

        Assert.assertEquals("static", RequestBody.staticValue);
        Assert.assertEquals("final", body.finalValue);
    }

    @Test
    public void erasePrimitiveFieldsToJavaDefaults() throws Exception {
        PrimitiveBody body = new PrimitiveBody();
        apply(new EraseValueAdvice(), "erasePrimitives", PrimitiveBody.class, body);

        assertPrimitiveDefaults(body);
        Assert.assertEquals(42, body.unannotated);
    }

    @Test
    public void keepResetsUnmatchedPrimitiveFields() throws Exception {
        PrimitiveBody body = new PrimitiveBody();
        apply(new KeepValueAdvice(), "keepPrimitives", PrimitiveBody.class, body);

        assertPrimitiveDefaults(body);
        Assert.assertEquals(0, body.unannotated);
    }

    @Test
    public void onlyAnnotatedParametersAreSupported() throws Exception {
        MethodParameter plain = parameter("plain", RequestBody.class);

        Assert.assertFalse(new EraseValueAdvice().supports(plain, RequestBody.class, null));
        Assert.assertFalse(new KeepValueAdvice().supports(plain, RequestBody.class, null));
        Assert.assertTrue(new EraseValueAdvice().supports(parameter("eraseDefault", RequestBody.class), RequestBody.class, null));
        Assert.assertTrue(new KeepValueAdvice().supports(parameter("keepDefault", RequestBody.class), RequestBody.class, null));
    }

    private RequestBody apply(PropertyValueAdvice<?> advice, String methodName) throws Exception {
        RequestBody body = new RequestBody();
        apply(advice, methodName, RequestBody.class, body);
        return body;
    }

    private void apply(PropertyValueAdvice<?> advice, String methodName, Class<?> bodyType, Object body) throws Exception {
        Assert.assertSame(body, advice.afterBodyRead(body, null, parameter(methodName, bodyType), bodyType, null));
    }

    private MethodParameter parameter(String methodName, Class<?> bodyType) throws Exception {
        return new MethodParameter(Endpoints.class.getDeclaredMethod(methodName, bodyType), 0);
    }

    private void assertPrimitiveDefaults(PrimitiveBody body) {
        Assert.assertFalse(body.flag);
        Assert.assertEquals(0, body.byteValue);
        Assert.assertEquals(0, body.shortValue);
        Assert.assertEquals(0, body.intValue);
        Assert.assertEquals(0L, body.longValue);
        Assert.assertEquals('\0', body.charValue);
        Assert.assertEquals(0F, body.floatValue, 0F);
        Assert.assertEquals(0D, body.doubleValue, 0D);
    }

    private interface AdminGroup {}

    private interface OtherGroup {}

    private static class RequestBody {
        @EraseValue
        @KeepValue
        private String defaultValue = "default";
        @EraseValue(AdminGroup.class)
        @KeepValue(AdminGroup.class)
        private String adminValue = "admin";
        @EraseValue(OtherGroup.class)
        @KeepValue(OtherGroup.class)
        private String otherValue = "other";
        @EraseValue({OtherGroup.class, AdminGroup.class})
        @KeepValue({OtherGroup.class, AdminGroup.class})
        private String multiValue = "multi";
        @EraseValue({OtherGroup.class, OtherGroup.class})
        @KeepValue({OtherGroup.class, OtherGroup.class})
        private String duplicateValue = "duplicate";
        private String plainValue = "plain";
        @EraseValue
        private static String staticValue = "static";
        @EraseValue
        private final String finalValue = new String("final");
    }

    private static class PrimitiveBody {
        @EraseValue
        private boolean flag = true;
        @EraseValue
        private byte byteValue = 1;
        @EraseValue
        private short shortValue = 2;
        @EraseValue
        private int intValue = 3;
        @EraseValue
        private long longValue = 4L;
        @EraseValue
        private char charValue = 'a';
        @EraseValue
        private float floatValue = 5F;
        @EraseValue
        private double doubleValue = 6D;
        private int unannotated = 42;
    }

    private static class Endpoints {
        void eraseDefault(@EraseValue RequestBody body) {}

        void eraseAdmin(@EraseValue(AdminGroup.class) RequestBody body) {}

        void eraseDuplicateAdmin(@EraseValue({AdminGroup.class, AdminGroup.class}) RequestBody body) {}

        void keepDefault(@KeepValue RequestBody body) {}

        void keepAdmin(@KeepValue(AdminGroup.class) RequestBody body) {}

        void plain(RequestBody body) {}

        void erasePrimitives(@EraseValue PrimitiveBody body) {}

        void keepPrimitives(@KeepValue PrimitiveBody body) {}
    }
}
