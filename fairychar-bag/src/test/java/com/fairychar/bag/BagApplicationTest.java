package com.fairychar.bag;

import com.fairychar.bag.beans.netty.server.SimpleNettyServer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IDEA <br>
 * Date: 2021/06/24 <br>
 * time: 21:07 <br>
 *
 * @author chiyo <br>
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BagApplicationTest {

    private static AnnotationConfigApplicationContext context;

    @Test
    public void testNettyAdvice() {
        SimpleNettyServer simpleNettyServer = context.getBean(SimpleNettyServer.class);
        System.out.println(simpleNettyServer);
    }


    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.refresh();


    }


    @ComponentScan(basePackages = "com.fairychar.bag")
    @Configuration
    static class Config {

    }
}
