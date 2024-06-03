package com.fairychar.bag.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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


    public static class RestTemplateBean {
        private RestTemplateBean() {

        }

        private enum Singleton {
            INSTANCE;

            Singleton() {
                instance = new RestTemplate();
            }

            private final RestTemplate instance;

            public RestTemplate getInstance() {
                return INSTANCE.instance;
            }
        }

        public static RestTemplate getInstance() {
            return Singleton.INSTANCE.getInstance();
        }
    }

    public static class RandomBean {
        private RandomBean() {

        }

        private enum Singleton {
            INSTANCE;

            Singleton() {
                instance = new Random(System.currentTimeMillis());
            }

            private final Random instance;

            public Random getInstance() {
                return INSTANCE.instance;
            }
        }

        public static Random getInstance() {
            return Singleton.INSTANCE.getInstance();
        }
    }

    public static class PathMatcherBean {
        private PathMatcherBean() {

        }

        private enum Singleton {
            INSTANCE;

            Singleton() {
                instance = new AntPathMatcher();
            }

            private final AntPathMatcher instance;

            public AntPathMatcher getInstance() {
                return INSTANCE.instance;
            }
        }

        public static AntPathMatcher getInstance() {
            return Singleton.INSTANCE.getInstance();
        }
    }


    public static class GsonBean {
        private Gson gson = new Gson();

        private GsonBean() {

        }

        private enum Singleton {
            INSTANCE;

            Singleton() {
                instance = new GsonBean();
            }

            private final GsonBean instance;

            public GsonBean getInstance() {
                return INSTANCE.instance;
            }
        }

        public static Gson getInstance() {
            return Singleton.INSTANCE.getInstance().gson;
        }
    }

    public static class JsonBean {
        private ObjectMapper mapper = new ObjectMapper();

        private JsonBean() {

        }

        private enum Singleton {
            INSTANCE;

            Singleton() {
                instance = new JsonBean();
            }

            private final JsonBean instance;

            public JsonBean getInstance() {
                return INSTANCE.instance;
            }
        }

        public static ObjectMapper getInstance() {
            return Singleton.INSTANCE.getInstance().mapper;
        }
    }
}
