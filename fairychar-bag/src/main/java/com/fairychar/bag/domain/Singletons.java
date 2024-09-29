package com.fairychar.bag.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.client.RestTemplate;

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

            private final transient ObjectMapper instance = new ObjectMapper();


            public ObjectMapper getInstance() {
                return instance;
            }
        }

        public static ObjectMapper getInstance() {
            return Singleton.INSTANCE.getInstance();
        }
    }
}
