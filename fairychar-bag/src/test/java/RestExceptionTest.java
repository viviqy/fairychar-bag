import com.fairychar.bag.beans.spring.advice.DefaultExceptionAdvice;
import com.fairychar.bag.domain.exceptions.IRestErrorCode;
import com.fairychar.bag.domain.exceptions.RestException;
import com.fairychar.bag.pojo.vo.HttpResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chiyo
 * @since 0.0.1
 */
public class RestExceptionTest {

    @Test
    public void supportCustomRestErrorCodeInterface() {
        RestException exception = new RestException(CustomRestErrorCode.USER_PHONE_BOUND);
        HttpResult result = new DefaultExceptionAdvice().handleRestException(exception);

        Assert.assertSame(CustomRestErrorCode.USER_PHONE_BOUND, exception.getErrorCode());
        Assert.assertEquals(CustomRestErrorCode.USER_PHONE_BOUND.getCode(), result.getCode());
        Assert.assertEquals(CustomRestErrorCode.USER_PHONE_BOUND.getMessage(), result.getMsg());
    }

    @AllArgsConstructor
    @Getter
    private enum CustomRestErrorCode implements IRestErrorCode {
        USER_PHONE_BOUND(30001, "手机号已绑定");

        private final int code;
        private final String message;
    }
}
