import cn.hutool.json.JSONUtil;
import com.fairychar.bag.beans.spring.mvc.FuzzyValue;
import com.fairychar.bag.domain.validator.rest.NotIn;
import com.fairychar.bag.function.Action;
import com.fairychar.bag.utils.*;
import com.fairychar.bag.utils.base.FieldContainer;
import com.fairychar.bag.utils.test.TaskTestUtil;
import com.google.common.base.Strings;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chiyo
 * @since 1.0.2
 */
@Slf4j
public class UtilTest {


    @Test
    @SneakyThrows
    public void testCycJob() {
        Thread t1 = new Thread(() -> {
            CircularTaskUtil.run(() -> {
                try {
                    log.info("aa");
                    TimeUnit.SECONDS.sleep(10);
                    log.info("bb");
                } catch (InterruptedException e) {
                    log.error("ee");
                    throw new RuntimeException(e);
                }
                log.info("dd");
                return false;
            }, true);
        });
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();

    }

    @Test
    public void testListPart() {
        List<Integer> l1 = List.of(1, 2, 3, 4, 5);
        List<List<Integer>> lists = CollectionUtil.splitList(l1, 4);
        lists.forEach(System.out::println);
    }

    @Test
    public void testListToTree() {
        List<Relation> r1s = MappingObjectUtil.listToTree(datas, "pid", "id", "child", 1);
        System.out.println(JSONUtil.toJsonPrettyStr(r1s));
    }

    @Test
    public void testSearch() {

        List<Relation> r1s = ReflectUtil.recursiveSearchChild("id", 1, ids -> {
            List<Relation> list = datas.stream().filter(s -> ids.contains(s.getPid())).toList();
            return list;
        });
        System.out.println(JSONUtil.toJsonPrettyStr(r1s));
        System.out.println("================");
        List<Relation> r3s = ReflectUtil.recursiveSearchChild("id", 3, ids -> {
            List<Relation> list = datas.stream().filter(s -> ids.contains(s.getPid())).toList();
            return list;
        });
        System.out.println(JSONUtil.toJsonPrettyStr(r3s));
        System.out.println("================");

        List<Relation> r4s = ReflectUtil.recursiveSearchParent("pid", 7, ids -> {
            List<Relation> list = datas.stream().filter(s -> ids.contains(s.getId())).toList();
            return list;
        });
        System.out.println(JSONUtil.toJsonPrettyStr(r4s));
        System.out.println("================");

//        List<Relation> r5s =
        List<Relation> r5s = ReflectUtil.recursiveSearchChild("id", List.of(1, 2), (Function<List<Integer>, List<Relation>>) pids -> {
            List<Relation> list = datas.stream().filter(s -> pids.contains(s.getPid())).toList();
            return list;
        });
        System.out.println(JSONUtil.toJsonPrettyStr(r5s));
        System.out.println("================");

    }

    private static List<Relation> datas = List.of(
            new Relation(1, 0),
            new Relation(2, 1),
            new Relation(3, 1),
            new Relation(4, 2),
            new Relation(5, 2),
            new Relation(6, 3),
            new Relation(7, 6),
            new Relation(8, 7)
    );

    @RequiredArgsConstructor
    @Data
    static class Relation {
        private final Integer id;
        private final Integer pid;
        private List<Relation> child;

    }


    @Test
    public void testFillString() {
        String source = "abcdabcdabcd";
        char c = '0';
        System.out.println(StringUtil.fillBegin(source, c, 8));
        System.out.println(StringUtil.fillEnd(source, c, 8));
        System.out.println(Strings.padStart(source, 8, c));
        System.out.println(Strings.padEnd(source, 8, c));
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
