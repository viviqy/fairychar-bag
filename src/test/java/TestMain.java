import com.fairychar.bag.pojo.ao.EchartsNode;
import com.fairychar.bag.pojo.ao.MappingAO;
import com.fairychar.bag.pojo.ao.MappingObjectAO;
import com.fairychar.bag.utils.EChartsUtil;
import com.fairychar.bag.utils.MappingObjectUtil;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IDEA <br>
 * User: lmq <br>
 * Date: 2020/3/24 <br>
 * time: 11:58 <br>
 *
 * @author lmq <br>
 * @since 1.0
 */
public class TestMain {
    private static Gson gson = new Gson();

    @Test
    public void run5() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
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