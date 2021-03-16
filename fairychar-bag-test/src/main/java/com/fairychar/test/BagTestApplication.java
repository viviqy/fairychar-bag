package com.fairychar.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Datetime: 2020/6/2 16:28 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@SpringBootApplication
public class BagTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(BagTestApplication.class, args);
    }
}
