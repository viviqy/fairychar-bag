import com.fairychar.bag.domain.Consts;
import com.fairychar.bag.pojo.dto.NameValueDTO;
import com.fairychar.bag.utils.FileUtil;
import com.fairychar.bag.utils.ReflectUtil;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.File;

/**
 * Created with IDEA <br>
 * Date: 2021/06/24 <br>
 * time: 22:24 <br>
 *
 * @author chiyo <br>
 */
public class TestMain {


    @Test
    public void testConcatFile() {
        String sourceFilePath = "/users/chiyo/tmp/a1.txt";
        String sourceFilePath1 = "/users/chiyo/tmp/a2.txt";
        String sourceFilePath2 = "/users/chiyo/tmp/a3.txt";
        String sourceFilePath3 = "/users/chiyo/tmp/fake1.txt";
        FileUtil.concatFile("/users/chiyo/tmp/concat.txt", new File(sourceFilePath), new File(sourceFilePath1)
                , new File(sourceFilePath2), new File(sourceFilePath3));

    }

    @Test
    public void testCutFile() {
        String sourceFilePath = "/users/chiyo/tmp/fake.txt";
        FileUtil.cutFile(sourceFilePath, "/users/chiyo/tmp/fake1.txt", 0.5, 1.0);
    }

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
    public void testEncoding() {
        System.out.println("aaa");
        System.out.println("啊啊啊");
        System.out.println("123");
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