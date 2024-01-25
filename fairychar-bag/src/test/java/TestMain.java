import com.fairychar.bag.beans.spring.mvc.FuzzyValue;
import com.fairychar.bag.domain.Consts;
import com.fairychar.bag.pojo.dto.NameValueDTO;
import com.fairychar.bag.pojo.vo.HttpResult;
import com.fairychar.bag.utils.FileUtil;
import com.fairychar.bag.utils.ReflectUtil;
import com.fairychar.bag.utils.base.FieldContainer;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chiyo
 */
public class TestMain {


    @Test
    @SneakyThrows
    public void testObjectFieldType() {
        //获取一个Object对象的所有字段
        Object o = new Object();
        System.out.println(o.getClass().getDeclaredFields().length);

        HttpResult<UtilTest.User> result = new HttpResult<>();
        UtilTest.User user = new UtilTest.User();
        result.setData(user);
        Map<Class<? extends Annotation>, List<FieldContainer>> map = ReflectUtil
                .recursiveSearchFieldValueByAnnotations(user, Arrays.asList(FuzzyValue.class));
        List<FieldContainer> fieldContainers = map.get(FuzzyValue.class);
        List<String> collect = fieldContainers.stream().map(s -> s.getPath()).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


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