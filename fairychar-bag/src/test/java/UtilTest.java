import cn.hutool.json.JSONUtil;
import com.fairychar.bag.beans.spring.mvc.FuzzyValue;
import com.fairychar.bag.domain.validator.rest.NotIn;
import com.fairychar.bag.function.Action;
import com.fairychar.bag.utils.ReflectUtil;
import com.fairychar.bag.utils.RequestUtil;
import com.fairychar.bag.utils.StringUtil;
import com.fairychar.bag.utils.base.FieldContainer;
import com.fairychar.bag.utils.test.TaskTestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author chiyo
 * @since 1.0.2
 */
@Slf4j
public class UtilTest {


    @Test
    public void testSearch() {
        List<Relation> datas = List.of(
                new Relation(1, 0),
                new Relation(2, 1),
                new Relation(3, 1),
                new Relation(4, 2),
                new Relation(5, 2),
                new Relation(6, 3),
                new Relation(7, 6),
                new Relation(8, 7)
        );
        List<Relation> r1s = ReflectUtil.recursiveSearchChild("id", 1, ids -> {
            List<Relation> list = datas.stream().filter(s -> ids.contains(s.getPid())).toList();
            return list;
        });
        System.out.println(JSONUtil.toJsonPrettyStr(r1s));
        List<Relation> r3s = ReflectUtil.recursiveSearchChild("id", 3, ids -> {
            List<Relation> list = datas.stream().filter(s -> ids.contains(s.getPid())).toList();
            return list;
        });
        System.out.println(JSONUtil.toJsonPrettyStr(r3s));

        List<Relation> r4s = ReflectUtil.recursiveSearchParent("pid", 7, ids -> {
            List<Relation> list = datas.stream().filter(s -> ids.contains(s.getId())).toList();
            return list;
        });
        System.out.println(JSONUtil.toJsonPrettyStr(r4s));

    }

    @AllArgsConstructor
    @Data
    static class Relation {
        private Integer id;
        private Integer pid;

    }


    @Test
    public void testFillString() {
        String source = "abcd";
        char c = '0';
        System.out.println(StringUtil.fillBegin(source, c, 8));
        System.out.println(StringUtil.fillEnd(source, c, 8));
    }


    @Test
    public void testRequestHeaders() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("A", "A");
        request.addHeader("A", "B");
        request.addHeader("C", "C");
        Map<String, String> headers = RequestUtil.getHeader(request);
        System.out.println(headers);
    }


    @Test
    public void testGetClassFields() {
        Set<Field> classFields = ReflectUtil.getClassFields(D.class, true, false, false);
        System.out.println(classFields.stream().map(c -> c.getName()).collect(Collectors.joining(",")));

        classFields = ReflectUtil.getClassFields(D.class, false, false, false);
        System.out.println(classFields.stream().map(c -> c.getName()).collect(Collectors.joining(",")));

        classFields = ReflectUtil.getClassFields(D.class, false, true, true);
        System.out.println(classFields.stream().map(c -> c.getName()).collect(Collectors.joining(",")));
    }

    static class D extends C {
        private String ddd;

        private static int p1;
        private final int p2 = 1;
        private static final int p3 = 1;
    }

    @Test
    @SneakyThrows
    public void testRun() {
        Action action = () -> {
            log.info("test run...");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        TaskTestUtil.concurrentRunAsync(Arrays.asList(action, action));
        log.info("bbbb");
    }

    @Test
    @SneakyThrows
    public void test1000kw() {
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);
        a.setA(a);
        C c = new C();
        b.setC(c);

        ObjectMapper objectMapper = new ObjectMapper();
        TimeUnit.SECONDS.sleep(4);
        long wasteMillis = TaskTestUtil.getWasteMillis(() ->
                ReflectUtil.recursiveSearchFieldValueByAnnotations(c, Arrays.asList(FuzzyValue.class)), 1000_0000);
        System.out.println(wasteMillis);//a=14796 , c=7761

//        long wasteMillis1 = TaskTestUtil.getWasteMillis(() -> {
//            try {
//                objectMapper.writeValueAsString(c);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//        }, 1000_0000);
//        System.out.println(wasteMillis1);//2360
    }

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
        @FuzzyValue
        private C c;

    }


    @Getter
    @Setter
    static class C {
        @FuzzyValue
        private String name = "ccc";
        private Long f1 = new Long(1);
        private Integer f2 = new Integer(2);
        private Boolean f3 = new Boolean(true);
        private Byte f4 = new Byte(((byte) 1));
//        private Object f5 = new Object();
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
                        return ((String) c.getField().get(c.getTargetObject()));
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
