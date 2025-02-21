import com.fairychar.bag.beans.spring.mvc.FuzzyValue;
import com.fairychar.bag.domain.validator.rest.IP;
import com.fairychar.bag.domain.validator.rest.Language;
import com.fairychar.bag.domain.validator.rest.StartWith;
import com.fairychar.bag.domain.validator.rest.Url;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * @author chiyo <br>
 * @since 1.0.2
 */
public class ValidatorTest {

    private static Validator validator;


    public static class FuzzyEntity {
        @FuzzyValue
        private String name;
    }

    @Test
    public void testIp() {
        Request request = new Request();
        request.setIp("1.1.1:1");
        request.setLanguage("哈哈哈ab12");
        request.setUrl("https://a.com.[]");
        request.setStartWith1("2");
        Set<ConstraintViolation<Request>> validate = validator.validate(request, Default.class);
        System.out.println(validate);
    }

    @Data
    static class Request {
        @IP
        private String ip;
        @Language(Language.LanguageType.CHINESE)
        private String language;
        @Url(message = "hahah")
        private String url;
        @StartWith({"12"})
        private String startWith1;
        @StartWith({"23"})
        private String startWith2;
        @StartWith({"34"})
        private String startWith3;
    }


    @Before
    public void init() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
}
