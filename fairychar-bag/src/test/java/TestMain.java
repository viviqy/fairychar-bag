import com.fairychar.bag.beans.netty.server.SimpleNettyServer;
import com.fairychar.bag.pojo.ao.EchartsNode;
import com.fairychar.bag.pojo.ao.MappingAO;
import com.fairychar.bag.pojo.ao.MappingObjectAO;
import com.fairychar.bag.pojo.vo.HttpResult;
import com.fairychar.bag.template.CacheOperateTemplate;
import com.fairychar.bag.utils.CircularTaskUtil;
import com.fairychar.bag.utils.EChartsUtil;
import com.fairychar.bag.utils.MappingObjectUtil;
import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/3/24 <br>
 * time: 11:58 <br>
 *
 * @author chiyo <br>
 * @since 0.0.1-SNAPSHOT
 */
public class TestMain {
    private static Gson gson = new Gson();

    @Test
    public void run12() {
        HttpResult.ok();
        HttpResult.response(HttpStatus.BAD_REQUEST, "user");
    }

    @Test
    public void run11() {
        HashMap<String, String> map = new HashMap<>(1);
        Object lock = new Object();
        String value = CacheOperateTemplate.get(() -> {
                    //从缓存读数据
                    return map.get("a");
                }
                , () -> {
                    //假装从数据库读取到了一个"1"花了1秒钟
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    return "1";
                }
                , s -> {
                    //把1放到缓存里
                    map.put("a", s);
                }
                , lock
        );
        System.out.println(value);
    }

    @Test
    public void test1() {
        boolean result = CircularTaskUtil.run(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            return false;
        }, true, 0, 5_000);
        System.out.println(result);
    }

    @Test
    public void run10() {
        List<User> users = Arrays.asList(new User(1, "1"), new User(2, "2"));
        User[] array = users.toArray(new User[]{});
        for (User user : array) {
            System.out.println(user);
        }
    }

    @Test
    public void run9() throws InterruptedException {
        Object lock = new Object();
        new Thread(() -> {
            CacheOperateTemplate.get(() -> null, () -> "1", s -> {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                }
                System.out.println(s);
            }, lock);
        }, "a").start();
        TimeUnit.MILLISECONDS.sleep(100L);
        Object lock1 = new Object();
        System.out.println(1111);
        new Thread(() -> {
            CacheOperateTemplate.get(() -> null, () -> "2", s -> {
                System.out.println(s);
            }, lock1);
        }, "a").start();
        Thread.currentThread().join();
    }

    @Test
    public void run8() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        CountDownLatch countDownLatch = new CountDownLatch(50);
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(1);
        Object lock = new Object();
        for (int i = 0; i < 50; i++) {
            executorService.execute(() -> {
                countDownLatch.countDown();
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName);
                Supplier<String> supplier = () -> map.get("a");
                String s1 = CacheOperateTemplate.get(supplier
                        , () -> "1", s -> {
                            System.out.println("a");
                            map.put("a", s);
                        }, lock);
                System.out.println(threadName + "获取到了" + s1);
            });
        }
        Thread.currentThread().join();
    }

    @Test
    public void run7() {
    }

    @Test
    public void run6() throws Exception {
        SimpleNettyServer simpleNettyServer = new SimpleNettyServer(1, 1, 8080);
        simpleNettyServer.afterPropertiesSet();
//        TimeUnit.SECONDS.sleep(3);
//        SimpleNettyClient simpleNettyClient = new SimpleNettyClient(1, 10000, "localhost");
//        simpleNettyClient.afterPropertiesSet();
        Thread.currentThread().join();
    }

    @Test
    public void run5() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        List<MappingAO<String, Integer>> list = MappingObjectUtil.mapping(map);
        System.out.println(list);
    }


    @Test
    public void run4() {
        List<User> users = Arrays.asList(
                new User(1, "a"),
                new User(1, "a"),
                new User(2, "a"),
                new User(2, "b"),
                new User(3, "a"),
                new User(3, "c"),
                new User(14, "d")
        );
        Map<Integer, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getId));
        List<MappingObjectAO<Integer, User>> mapping = MappingObjectUtil.mappingList(collect);
        System.out.println(gson.toJson(mapping));
    }

    @Test
    public void run3() {
        List<User> users = Arrays.asList(
                new User(1, "a"),
                new User(1, "a"),
                new User(2, "a"),
                new User(2, "b"),
                new User(3, "a"),
                new User(3, "c"),
                new User(14, "d")
        );
        Map<String, Map<Integer, List<User>>> collect = users.stream().collect(
                Collectors.groupingBy(u -> u.getName()
                        , Collectors.groupingBy(u -> u.getId())));
        System.out.println(collect);
        List<EchartsNode<User>> list = EChartsUtil.mapToNode(collect);
        System.out.println(gson.toJson(list));
    }

    @Test
    public void run2() {
        User a = new User(1, "a");
        User b = new User(1, "aa");
        TreeMap<User, String> map = new TreeMap<>();
        map.put(a, "1");
        map.put(b, "2");
        System.out.println(map);
    }

    @Test
    public void run1() {
        TreeMap<String, Object> stringMap = new TreeMap<>(Comparator.comparingInt(String::length));
        TreeMap<Integer, Object> intMap = new TreeMap<>();
        stringMap.put("b", 1);
        stringMap.put("a", 2);
        System.out.println(stringMap);
        intMap.put(1, 2);
        intMap.put(2, 1);
        System.out.println(intMap);
    }

}
/*
                                      /[-])//  ___        
                                 __ --\ `_/~--|  / \      
                               /_-/~~--~~ /~~~\\_\ /\     
                               |  |___|===|_-- | \ \ \    
____________ _/~~~~~~~~|~~\,   ---|---\___/----|  \/\-\   
____________ ~\________|__/   / // \__ |  ||  / | |   | | 
                      ,~-|~~~~~\--, | \|--|/~|||  |   | | 
                      [3-|____---~~ _--'==;/ _,   |   |_| 
                                  /   /\__|_/  \  \__/--/ 
                                 /---/_\  -___/ |  /,--|  
                                 /  /\/~--|   | |  \///   
                                /  / |-__ \    |/         
                               |--/ /      |-- | \        
                              \^~~\\/\      \   \/- _     
                               \    |  \     |~~\~~| \    
                                \    \  \     \   \  | \  
                                  \    \ |     \   \    \ 
                                   |~~|\/\|     \   \   | 
                                  |   |/         \_--_- |\
                                  |  /            /   |/\/
                                   ~~             /  /    
                                                 |__/   W<

*/