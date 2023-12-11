import com.fairychar.bag.beans.spring.mvc.FuzzyResult;
import com.fairychar.bag.beans.spring.mvc.FuzzyValueAdvice;
import com.fairychar.bag.pojo.vo.HttpResult;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.core.MethodParameter;

/**
 * @author chiyo <br>
 * @since
 */
public class AdviceTest {


    @Test
    @SneakyThrows
    public void testFuzzyValueAdvice() {
        FuzzyValueAdvice fuzzyValueAdvice = new FuzzyValueAdvice();
        MethodParameter methodParameter = new MethodParameter(AdviceTest.class.getDeclaredMethod("testAdvice", null), -1);
        HttpResult<UtilTest.User> ok = HttpResult.ok(new UtilTest.User());
        fuzzyValueAdvice.beforeBodyWrite(ok, methodParameter, null, null, null, null);
        System.out.println(ok);

        MethodParameter methodParameter1 = new MethodParameter(AdviceTest.class.getDeclaredMethod("testAdviceUser", null), -1);
        UtilTest.User ok1 = new UtilTest.User();
        fuzzyValueAdvice.beforeBodyWrite(ok1, methodParameter1, null, null, null, null);
        System.out.println(ok1);


    }


    @FuzzyResult(field = "data")
    public HttpResult<UtilTest.User> testAdvice() {
        return HttpResult.ok(new UtilTest.User());
    }

    @FuzzyResult()
    public UtilTest.User testAdviceUser() {
        return new UtilTest.User();
    }

}
