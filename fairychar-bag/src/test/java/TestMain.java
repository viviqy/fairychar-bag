import com.fairychar.bag.pojo.dto.NameValueDTO;
import com.fairychar.bag.utils.ClassUtil;
import com.fairychar.bag.utils.ReflectUtil;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.List;

/**
 * Created with IDEA <br>
 * Date: 2021/06/24 <br>
 * time: 22:24 <br>
 *
 * @author chiyo <br>
 */
public class TestMain {


    @Test
    public void fincClass(){
        List<Class<?>> classes = ClassUtil.getClasses("com.fairychar.bag.extension", true);
        classes.stream().map(c->c.getName()).forEach(System.out::println);
    }

    @Test
    public void testMappingTree() {

    }

 
    @Test
    @SneakyThrows
    public void testKeepValue() {
        NameValueDTO<String> dto = new NameValueDTO<>();
        dto.setName("a");
        dto.setValue("b");
        ReflectUtil.keepValue(dto, "name");
        System.out.println(dto);
    }


    @Test
    public void throwEx() {
        try {
            this.ex("a");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("aa");
    }

    private void ex(String a) throws IllegalAccessException {
        throw new IllegalAccessException("aa");
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