package com.fairychar.bag.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.util.AntPathMatcher;

/**
 * 常用单例属性类
 *
 * @author chiyo
 * @since 1.0.2
 */
public class Singletons {

    public static class PathMatcher {
        private PathMatcher() {

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


    public static class GSON {
        private Gson gson = new Gson();

        private GSON() {

        }

        private enum Singleton {
            INSTANCE;

            Singleton() {
                instance = new GSON();
            }

            private final GSON instance;

            public GSON getInstance() {
                return INSTANCE.instance;
            }
        }

        public static Gson getInstance() {
            return Singleton.INSTANCE.getInstance().gson;
        }
    }

    public static class JSON {
        private ObjectMapper mapper = new ObjectMapper();

        private JSON() {

        }

        private enum Singleton {
            INSTANCE;

            Singleton() {
                instance = new JSON();
            }

            private final JSON instance;

            public JSON getInstance() {
                return INSTANCE.instance;
            }
        }

        public static ObjectMapper getInstance() {
            return Singleton.INSTANCE.getInstance().mapper;
        }
    }
}
