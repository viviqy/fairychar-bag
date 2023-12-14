import com.fairychar.bag.beans.spring.mvc.*;
import com.fairychar.bag.pojo.vo.HttpResult;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.core.MethodParameter;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chiyo <br>
 * @since
 */
public class AdviceTest {


    @Test
    public void testFuzzyMiddle() {
        FuzzyMiddleTextProcessor textProcessor = new FuzzyMiddleTextProcessor();
        String fuzzyValue = textProcessor.fuzzyValue("12345", new FuzzyValue() {
            @Override
            public int beginAt() {
                return 1;
            }

            @Override
            public int endAt() {
                return 2;
            }

            @Override
            public String replaceSymbol() {
                return "*";
            }

            @Override
            public Class<? extends FuzzyValueProcessor>[] processor() {
                return new Class[0];
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }
        });
        System.out.println(fuzzyValue);
    }

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

        MethodParameter methodParameter2 = new MethodParameter(AdviceTest.class.getDeclaredMethod("testAdviceList"), -1);
        HttpResult<List<UtilTest.User>> ok2 = HttpResult.ok(Arrays.asList(new UtilTest.User()));
        fuzzyValueAdvice.beforeBodyWrite(ok2, methodParameter2, null, null, null, null);
        System.out.println(ok2);


        MethodParameter methodParameter3 = new MethodParameter(AdviceTest.class.getDeclaredMethod("testAdviceMap"), -1);
        HttpResult<Map<String, UtilTest.User>> ok3 = testAdviceMap();
        fuzzyValueAdvice.beforeBodyWrite(ok3, methodParameter3, null, null, null, null);
        System.out.println(ok3);


    }


    @FuzzyResult
    public HttpResult<Map<String, UtilTest.User>> testAdviceMap() {
        UtilTest.User user = new UtilTest.User();
        HashMap<String, UtilTest.User> map = new HashMap<>();
        map.put("test", user);
        return HttpResult.ok(map);
    }

    @FuzzyResult
    public HttpResult<List<UtilTest.User>> testAdviceList() {
        return HttpResult.ok(Arrays.asList(new UtilTest.User()));
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
