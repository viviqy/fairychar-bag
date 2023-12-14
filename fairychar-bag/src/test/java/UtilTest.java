import com.fairychar.bag.beans.spring.mvc.FuzzyValue;
import com.fairychar.bag.domain.validator.rest.NotIn;
import com.fairychar.bag.utils.ReflectUtil;
import com.fairychar.bag.utils.base.FieldContainer;
import lombok.*;
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
    public void testAb() {
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);
        a.setA(a);
        Map<Class<? extends Annotation>, List<FieldContainer>> classListMap = ReflectUtil.recursiveSearchFieldValueByAnnotations(a, Arrays.asList(FuzzyValue.class));
        List<String> fieldNames = classListMap.values().stream().flatMap(f -> f.stream())
                .map(f -> f.getField().getDeclaringClass().getName().concat(":").concat(f.getField().getName()))
                .collect(Collectors.toList());
        System.out.println(fieldNames);
    }

    @Getter
    @Setter
    static class A {
        @FuzzyValue
        private String name = "aaaaa";
        private B b;
        @FuzzyValue
        private A a;
    }

    @Getter
    @Setter
    static class B {
        @FuzzyValue
        private String name = "bbb";
        @FuzzyValue
        private A a;

    }

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

    //    @Getter
//    @Setter
//    @ToString
//    @EqualsAndHashCode(doNotUseGetters = true)
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
    @EqualsAndHashCode(doNotUseGetters = true)
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
