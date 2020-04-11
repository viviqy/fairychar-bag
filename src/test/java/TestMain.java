import com.fairychar.bag.pojo.ao.EChartsNode;
import com.fairychar.bag.utils.EChartsUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
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
    @Test
    public void run4(){
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
        List<EChartsNode<Integer>> list = EChartsUtil.mapToNode(collect);
        System.out.println(list);
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

    @AllArgsConstructor
    @Data
    static class User implements Comparable {
        private int id;
        private String name;


        @Override
        public int hashCode() {
            return name.length();
        }

        @Override
        public int compareTo(Object o) {
            return -(this.hashCode() - o.hashCode());
        }
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