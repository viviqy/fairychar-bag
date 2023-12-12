import com.fairychar.bag.beans.spring.mvc.FuzzyValue;
import com.fairychar.bag.domain.validator.rest.NotIn;
import com.fairychar.bag.utils.ReflectUtil;
import com.fairychar.bag.utils.base.FieldContainer;
import lombok.Data;
import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chiyo <br>
 * @since 1.0.2
 */
public class UtilTest {


    @Test
    @SneakyThrows
    public void testRecursiveSearchByAnnotations() {
        User user = new User();

        Map<Class<? extends Annotation>, List<FieldContainer>> containerMap = ReflectUtil.recursiveSearchFieldValueByAnnotations(user, Arrays.asList(NotIn.class));
        System.out.println(containerMap);
        List<String> stringValue = containerMap.get(NotIn.class).stream()
                .filter(c -> c.getField().getType() == String.class)
                .map(c -> {
                    try {
                        return ((String) c.getField().get(c.getSourceObject()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
        System.out.println(stringValue);
    }


    @Data
    public static class User {
        private Integer id;
        @NotIn
        @FuzzyValue(beginAt = 1, endAt = 3)
        private String name = "user";
        @NotIn
        @FuzzyValue
        Role role = new Role();
        User child = null;
        @FuzzyValue
        List<Role> roleList = new ArrayList<Role>() {{
            add(new Role());
        }};

        @FuzzyValue
        Map<String, Role> roleMap = new HashMap<String, Role>() {{
            put("xiaoqi", new Role());
        }};
    }

    @Data
    public static class Role {
        private Integer id;
        @FuzzyValue(beginAt = 1, endAt = 3)
        private String userId = "12345";
        @NotIn
        @FuzzyValue
        private Menu menu = new Menu();

    }

    @Data
    public static class Menu {
        private Integer id;
        private String roleId;
        @NotIn
        @FuzzyValue(beginAt = 1, endAt = 3)
        private String name = "menu";
        @NotIn
        private Object entity;

    }
}
