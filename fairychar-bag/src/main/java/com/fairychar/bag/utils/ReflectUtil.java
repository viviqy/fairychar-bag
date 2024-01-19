package com.fairychar.bag.utils;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.utils.base.FieldContainer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import sun.misc.Unsafe;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.*;

/**
 * 反射工具类
 *
 * @author chiyo
 * @since 0.0.1-SNAPSHOT
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReflectUtil {

    private static final String regexAll = "*";

    /**
     * 递归搜索带有指定注解的字段值
     * 该代码以对象和注解类的集合作为输入，并返回一个包含注解作为键和字段容器列表作为值的映射。
     * 字段容器包含有关带有指定注解的字段的信息。
     * 支持字段为集合类{@link Collection},{@link Map}支持,如果为集合类则会循环解析获取所有集合内对象的字段
     */
    public static Map<Class<? extends Annotation>, List<FieldContainer>> recursiveSearchFieldValueByAnnotations(Object e, Collection<Class<? extends Annotation>> annotations) {
        HashMap<Class<? extends Annotation>, List<FieldContainer>> ref = new HashMap<>();
        HashSet<Integer> mappedBeans = new HashSet<>();
        recursiveSearchFieldValueByAnnotations(e, annotations, ref, mappedBeans);
        return ref;
    }


    private static void recursiveSearchFieldValueByAnnotations(Object e, Collection<Class<? extends Annotation>> annotations, Map<Class<? extends Annotation>
            , List<FieldContainer>> ref, HashSet<Integer> mappedBeans) {
        if (e == null || mappedBeans.contains(System.identityHashCode(e))) {
            return;
        }
        if (e instanceof Collection) {
            Collection<?> collection = (Collection<?>) e;
            for (Object item : collection) {
                recursiveSearchFieldValueByAnnotations(item, annotations, ref, mappedBeans);
            }
            return;
        } else if (e instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) e;
            for (Object item : map.values()) {
                recursiveSearchFieldValueByAnnotations(item, annotations, ref, mappedBeans);
            }
            return;
        }
        Field[] declaredFields = e.getClass().getDeclaredFields();
        //mark mapped,处理已经解析过的object,通过identityHashCode防止两个对象的hashcode计算相同
        mappedBeans.add(System.identityHashCode(e));
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
//            declaredField.setAccessible(true);
            for (Class<? extends Annotation> annotation : annotations) {
                if (declaredField.getAnnotation(annotation) != null) {
                    List<FieldContainer> fieldContainers = ref.get(annotation);
                    if (fieldContainers == null) {
                        fieldContainers = new ArrayList<>();
                        ref.put(annotation, fieldContainers);
                    }
                    fieldContainers.add(new FieldContainer(e, declaredField));
                    declaredField.setAccessible(true);
                }
            }
            if (!(!(declaredField.getGenericType() instanceof TypeVariable) && declaredField.getType() == Object.class) &&
                    !declaredField.getType().isPrimitive() &&
                    !Modifier.isStatic(declaredField.getModifiers()) &&
                    !Modifier.isFinal(declaredField.getModifiers()) ||
                    declaredField.getType().isMemberClass()
            ) {
                Object filedObject = null;
                declaredField.setAccessible(true);
                try {
                    filedObject = declaredField.get(e);
                    if (filedObject == null || (filedObject.getClass().getPackage() != null &&
                            (
                                    filedObject.getClass().getPackage().getName().startsWith("java") ||
                                            filedObject.getClass().getPackage().getName().startsWith("sun")
                            )
                    )
                    ) {
                        continue;
                    }
                } catch (IllegalAccessException ignore) {
                }
                recursiveSearchFieldValueByAnnotations(filedObject, annotations, ref, mappedBeans);
            }
        }
    }


    /**
     * 递归搜索带有指定注解集合的字段。
     * 它接受一个对象和一个注解类的集合作为输入，并返回一个将每个注解类映射到带有该注解的字段列表的Map。
     */
    public static Map<Class<? extends Annotation>, List<Field>> recursiveSearchFieldByAnnotations(Class clazz, Collection<Class<? extends Annotation>> annotations) {
        HashMap<Class<? extends Annotation>, List<Field>> ref = new HashMap<>();
        recursiveSearchFieldByAnnotations(clazz, annotations, ref);
        return ref;
    }


    private static void recursiveSearchFieldByAnnotations(Class clazz, Collection<Class<? extends Annotation>> annotations, Map<Class<? extends Annotation>, List<Field>> ref) {
        if (clazz == null) {
            return;
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field filedObject = declaredFields[i];
            filedObject.setAccessible(true);
            for (Class<? extends Annotation> annotation : annotations) {
                if (filedObject.getAnnotation(annotation) != null) {
                    List<Field> fields = ref.get(annotation);
                    if (fields == null) {
                        fields = new ArrayList<>();
                        ref.put(annotation, fields);
                    }
                    fields.add(filedObject);
                }
            }
            if (!(filedObject.getType() == Object.class) &&
                    !filedObject.getType().isPrimitive() &&
                    !Modifier.isStatic(filedObject.getModifiers()) &&
                    !Modifier.isFinal(filedObject.getModifiers()) &&
                    (
                            (
                                    filedObject.getType().getPackage() != null &&
                                            (
                                                    filedObject.getClass().getPackage().getName().startsWith("java") ||
                                                            filedObject.getClass().getPackage().getName().startsWith("sun")
                                            )
                            ) || filedObject.getType().isMemberClass())
            ) {
                recursiveSearchFieldByAnnotations(filedObject.getType(), annotations, ref);
            }
        }
    }


    /**
     * 递归查询指定id的所有子项
     *
     * @param source   源数据
     * @param pidField 代表id的字段名称
     * @param idField  代表pid的字段名称
     * @param idValue  id值
     * @param <T>      数据类型
     * @param <I>      id类型
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static <T, I> List<T> recursiveSearchParent(List<T> source, String pidField, String idField, I idValue) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<T> ref = new ArrayList<>();
        recursiveSearch(source, ref, pidField, idField, idValue);
        return ref;
    }

    /**
     * 递归查询指定id的所有子项
     *
     * @param source   源数据
     * @param idField  代表id的字段名称
     * @param pidField 代表pid的字段名称
     * @param idValue  id值
     * @param <T>      数据类型
     * @param <I>      id类型
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static <T, I> List<T> recursiveSearchChild(List<T> source, String idField, String pidField, I idValue) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<T> ref = new ArrayList<>();
        recursiveSearch(source, ref, idField, pidField, idValue);
        return ref;
    }

    /**
     * 递归查询指定id的所有子项/父项
     *
     * @param source   源数据
     * @param ref      out list
     * @param idFiled  代表id的字段名称
     * @param pidFiled 代表pid的字段名称;
     * @param idValue  id值
     * @param <T>      数据类型
     * @param <I>      id类型
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static <T, I> void recursiveSearch(List<T> source, List<T> ref, String idFiled, String pidFiled, I idValue) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<T> childList = new ArrayList<>();
        for (T child : source) {
            try {
                Field pid = child.getClass().getDeclaredField(pidFiled);
                pid.setAccessible(true);
                I pidValue = (I) pid.get(child);
                if (pidValue.equals(idValue)) {
                    childList.add(child);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw e;
            }
        }
        if (childList.isEmpty()) {
            return;
        }
        ref.addAll(childList);
        for (T parent : childList) {
            try {
                Field childId = parent.getClass().getDeclaredField(idFiled);
                childId.setAccessible(true);
                I childIdValue = (I) childId.get(parent);
                recursiveSearch(source, ref, idFiled, pidFiled, childIdValue);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw e;
            }
        }
    }


    public static void keepValue(Object o, String fields) throws IllegalAccessException {
        Assert.notNull(fields, "fields can not be null");
        Assert.notEmpty(fields, "fields can not be empty");
        String[] matchFields = fields.split(",");
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            for (int i1 = 0; i1 < matchFields.length; i1++) {
                if (!declaredFields[i].getName().equals(matchFields[i1])) {
                    declaredFields[i].setAccessible(true);
                    declaredFields[i].set(o, null);
                }
            }
        }
    }

    public static void eraseValue(Object o, Class<?>... fieldTypes) throws IllegalAccessException {
        for (Class<?> fieldClass : fieldTypes) {
            Assert.notNull(fieldClass, "fields can not be null");
        }
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            for (Class<?> fieldClass : fieldTypes) {
                if (declaredFields[i].getType() == fieldClass) {
                    declaredFields[i].setAccessible(true);
                    declaredFields[i].set(o, null);
                }
            }
        }
    }

    public static void eraseValue(Object o, String fields) throws IllegalAccessException {
        Assert.notNull(fields, "fields can not be null");
        Assert.notEmpty(fields, "fields can not be empty");
        Field[] declaredFields = o.getClass().getDeclaredFields();
        if (regexAll.equals(fields)) {
            for (int i = 0; i < declaredFields.length; i++) {
                declaredFields[i].setAccessible(true);
                declaredFields[i].set(o, null);
            }
            return;
        }
        String[] matchFields = fields.split(",");
        for (int i = 0; i < declaredFields.length; i++) {
            for (int i1 = 0; i1 < matchFields.length; i1++) {
                if (declaredFields[i].getName().equals(matchFields[i1])) {
                    declaredFields[i].setAccessible(true);
                    declaredFields[i].set(o, null);
                }
            }
        }
    }


    public static void swapLong(Long a, Long b) {
        Unsafe unsafe = getUnsafe();
        long c = a ^ b;
        try {
            unsafe.compareAndSwapLong(a
                    , unsafe.objectFieldOffset(Integer.class.getDeclaredField("value"))
                    , a, c ^ a);
            unsafe.compareAndSwapLong(b
                    , unsafe.objectFieldOffset(Integer.class.getDeclaredField("value"))
                    , b, c ^ b);
        } catch (NoSuchFieldException ignore) {
            //never happened
        }
    }


    public static void swapInteger(Integer a, Integer b) {
        Unsafe unsafe = getUnsafe();
        int c = a ^ b;
        try {
            unsafe.compareAndSwapInt(a
                    , unsafe.objectFieldOffset(Integer.class.getDeclaredField("value"))
                    , a, c ^ a);
            unsafe.compareAndSwapInt(b
                    , unsafe.objectFieldOffset(Integer.class.getDeclaredField("value"))
                    , b, c ^ b);
        } catch (NoSuchFieldException ignore) {
            //never happened
        }
    }


    public static <T> T mapToEntity(Map<String, Object> map, Class<T> tClass) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        return mapToEntity(map, tClass, false, false);
    }

    public static <T> T mapToEntity(Map<String, Object> map, Class<T> tClass, boolean mustMatchAll, boolean matchNull) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
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
                if (mustMatchAll) {
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

    public static Set<Field> getClassFields(Class<?> clazz, boolean getParent, boolean getStatic, boolean getFinal) {
        Set<Field> fields = new HashSet<>();
        Class<?> temp = clazz;
        if (!getParent) {
            fields.addAll(getClassFields(temp, getStatic, getFinal));
        } else {
            while (temp != Object.class) {
                fields.addAll(getClassFields(temp, getStatic, getFinal));
                temp = temp.getSuperclass();
            }
        }
        return fields;
    }

    private static Set<Field> getClassFields(Class<?> clazz, boolean getStatic, boolean getFinal) {
        HashSet<Field> fields = new HashSet<>();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            if (!getStatic && Modifier.isStatic(declaredFields[i].getModifiers())) {
                continue;
            } else if (!getFinal && Modifier.isFinal(declaredFields[i].getModifiers())) {
                continue;
            } else {
                fields.add(declaredFields[i]);
            }
        }
        return fields;
    }

    public static void copyProperties(Object source, Object target, boolean matchNull) {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        for (Field sourceField : sourceFields) {
            try {
                Field targetField = target.getClass().getDeclaredField(sourceField.getName());
                sourceField.setAccessible(true);
                Object value = sourceField.get(source);
                if ((value == null) != matchNull) {
                    continue;
                }
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
                Object value = sourceField.get(source);
                if ((value == null) && !matchNull) {
                    continue;
                }
                targetField.setAccessible(true);
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