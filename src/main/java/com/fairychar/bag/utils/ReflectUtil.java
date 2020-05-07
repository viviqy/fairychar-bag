package com.fairychar.bag.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created with IDEA <br>
 * User: lmq <br>
 * Date: 2020/3/24 <br>
 * time: 11:17 <br>
 *
 * @author lmq <br>
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReflectUtil {
    public static <T> T mapToEntity(Map<String, Object> map, Class<T> tClass) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        return mapToEntity(map, tClass, false, false);
    }

    public static <T> T mapToEntity(Map<String, Object> map, Class<T> tClass, boolean mushMatchAll, boolean matchNull) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        T t = tClass.newInstance();
        for (Map.Entry<String, Object> e : map.entrySet()) {
            if ((e.getValue() == null) && !matchNull) {
                continue;
            }
            String key = e.getKey();
            try {
                Field declaredField = t.getClass().getDeclaredField(key);
                declaredField.set(t, e.getValue());
            } catch (NoSuchFieldException ex) {
                if (mushMatchAll) {
                    throw ex;
                }
            }
        }
        return t;
    }

    public static Map<String, Object> entityToMap(Object source) {
        return entityToMap(source, false);
    }

    public static Map<String, Object> entityToMap(Object source, boolean matchNull) {
        Field[] declaredFields = source.getClass().getDeclaredFields();
        accessFields(declaredFields);
        HashMap<String, Object> map = new HashMap<>(declaredFields.length);
        for (int i = 0; i < declaredFields.length; i++) {
            try {
                Object value = declaredFields[i].get(source);
                if ((value == null) && !matchNull) {
                    continue;
                }
                map.put(declaredFields[i].getName(), value);
            } catch (IllegalAccessException ignore) {
            }
        }
        return map;
    }

    public static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Object o = theUnsafe.get(null);
            return ((Unsafe) o);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Set<Field> getObjFields(Class<?> source, boolean getParent, boolean getStatic) throws InstantiationException, IllegalAccessException {
        Set<Field> fields = new HashSet<>();
        Object temp = source.newInstance();
        if (!getParent) {
            fields.addAll(getObjFields(temp, getStatic));
        } else {
            while (temp.getClass() != Object.class) {
                fields.addAll(getObjFields(temp, getStatic));
                temp = temp.getClass().getSuperclass().newInstance();
            }
        }
        return fields;
    }

    private static Set<Field> getObjFields(Object object, boolean getStatic) throws IllegalAccessException, InstantiationException {
        HashSet<Field> fields = new HashSet<>();
        Class<?> aClass = object.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        if (getStatic) {
            fields.addAll(Arrays.asList(declaredFields));
        } else {
            for (int i = 0; i < declaredFields.length; i++) {
                if (!Modifier.isStatic(declaredFields[i].getModifiers())) {
                    fields.add(declaredFields[i]);
                }
            }
        }
        return fields;
    }

    public static void copyProperties(Object source, Object target, boolean matchNull) {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        for (Field sourceField : sourceFields) {
            try {
                Field targetField = target.getClass().getDeclaredField(sourceField.getName());
                Object value = sourceField.get(source);
                if ((value == null) != matchNull) {
                    continue;
                }
                sourceField.setAccessible(true);
                targetField.setAccessible(true);
                targetField.set(target, value);
            } catch (NoSuchFieldException ignore) {
            } catch (IllegalAccessException ignore) {
            }
        }
    }

    public static <T> T copyProperties(Object source, Class<T> tClass, boolean matchNull) {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        T t = null;
        try {
            t = tClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (Field sourceField : sourceFields) {
            try {
                Field targetField = tClass.getDeclaredField(sourceField.getName());
                sourceField.setAccessible(true);
                targetField.setAccessible(true);
                Object value = sourceField.get(source);
                if ((value == null) && !matchNull) {
                    continue;
                }
                targetField.set(t, value);
            } catch (NoSuchFieldException ignore) {
            } catch (IllegalAccessException ignore) {
            }
        }
        return t;
    }

    private static void accessFields(Field... fields) {
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
        }
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