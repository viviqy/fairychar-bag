package com.fairychar.bag.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 常用单例属性类
 *
 * @author chiyo
 * @since 1.0.2
 */
public class Singletons {


    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class RestTemplateBean {
        private enum Singleton {
            INSTANCE;

            Singleton() {
                instance = new RestTemplate();
            }

            private final transient RestTemplate instance;

            public RestTemplate getInstance() {
                return INSTANCE.instance;
            }
        }

        public static RestTemplate getInstance() {
            return Singleton.INSTANCE.getInstance();
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class RandomBean {
        private enum Singleton {
            INSTANCE;

            Singleton() {
                instance = new Random(System.currentTimeMillis());
            }

            private final transient Random instance;

            public Random getInstance() {
                return INSTANCE.instance;
            }
        }

        public static Random getInstance() {
            return Singleton.INSTANCE.getInstance();
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class PathMatcherBean {
        private enum Singleton {
            INSTANCE;

            Singleton() {
                instance = new AntPathMatcher();
            }

            private final transient AntPathMatcher instance;

            public AntPathMatcher getInstance() {
                return INSTANCE.instance;
            }
        }

        public static AntPathMatcher getInstance() {
            return Singleton.INSTANCE.getInstance();
        }
    }


    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class GsonBean {
        private enum Singleton {
            INSTANCE;

            private final transient Gson gson = new Gson();

            public Gson getGsonInstance() {
                return gson;
            }
        }

        public static Gson getInstance() {
            return Singleton.INSTANCE.getGsonInstance();
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class JsonBean {

        private enum Singleton {
            INSTANCE;

            private final transient ObjectMapper instance;

            Singleton() {
                ObjectMapper objectMapper = new ObjectMapper(); //对象的所有字段全部列入
                objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
                //取消默认转换timestamps形式
                objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
                //忽略空Bean转json的错误
                objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                //所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss
                objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                //忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                // 关闭未知属性异常
                objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                objectMapper.registerModule(new JavaTimeModule());
                this.instance = objectMapper;
            }

            public ObjectMapper getInstance() {
                return instance;
            }
        }

        public static ObjectMapper getInstance() {
            return Singleton.INSTANCE.getInstance();
        }
    }
}
