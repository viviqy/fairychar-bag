import com.fairychar.bag.domain.Consts;
import com.fairychar.bag.pojo.dto.NameValueDTO;
import com.fairychar.bag.utils.FileUtil;
import com.fairychar.bag.utils.ReflectUtil;
import lombok.SneakyThrows;
import org.junit.Test;

/**
 * Created with IDEA <br>
 * Date: 2021/06/24 <br>
 * time: 22:24 <br>
 *
 * @author chiyo <br>
 */
public class TestMain {


    @Test
    @SneakyThrows
    public void testFakeFile() {
        FileUtil.createFakeFileByNio("/users/chiyo/tmp/fake.txt", Consts.MB_PER_B);
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