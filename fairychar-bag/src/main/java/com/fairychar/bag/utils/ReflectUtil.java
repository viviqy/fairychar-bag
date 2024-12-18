package com.fairychar.bag.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import com.fairychar.bag.utils.base.FieldContainer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.*;
import java.util.function.Function;

/**
 * 反射工具类
 *
 * @author chiyo
 * @since 0.0.1-SNAPSHOT
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class ReflectUtil {

    private static final String REGEX_ALL = "*";


    /**
     * 递归搜索带有指定注解的字段值
     * 该代码以对象和注解类的集合作为输入，并返回一个包含注解作为键和字段容器列表作为值的映射。
     * 字段容器包含有关带有指定注解的字段的信息。
     * 支持字段为集合类{@link Collection},{@link Map}支持,如果为集合类则会循环解析获取所有集合内对象的字段
     */
    public static Map<Class<? extends Annotation>, List<FieldContainer>> recursiveSearchFieldValueByAnnotations(Object e
            , Collection<Class<? extends Annotation>> annotations) {
        HashMap<Class<? extends Annotation>, List<FieldContainer>> ref = new HashMap<>();
        HashSet<Integer> mappedBeans = new HashSet<>();
        recursiveSearchFieldValueByAnnotations(e.getClass().getSimpleName(), e, annotations, ref, mappedBeans);
        return ref;
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
     */
    public static <T, I> List<T> recursiveSearchParent(List<T> source, String pidField
            , String idField, I idValue) {
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
     */
    public static <T, I> List<T> recursiveSearchChild(List<T> source, String idField
            , String pidField, I idValue) {
        ArrayList<T> ref = new ArrayList<>();
        recursiveSearch(source, ref, idField, pidField, idValue);
        return ref;
    }


    /**
     * 递归搜索父项
     *
     * @param idValue              PID 值
     * @param pidField             id 字段
     * @param parentSearchSupplier 父项搜索供应商
     * @return {@link List }<{@link T }>
     */
    public static <T, I> List<T> recursiveSearchParent(String pidField, I idValue, Function<List<I>, List<T>> parentSearchSupplier) {
        List<I> idValues = List.of(idValue);
        //通过查找子项逆转id和pid实现
        return recursiveSearchChild(pidField, idValues, parentSearchSupplier);
    }


    /**
     * 递归搜索父项
     *
     * @param idValues             ID 值
     * @param pidField             pid 字段
     * @param parentSearchSupplier 父项搜索供应商
     * @return {@link List }<{@link T }>
     */
    public static <T, I> List<T> recursiveSearchParent(String pidField, List<I> idValues, Function<List<I>, List<T>> parentSearchSupplier) {
        LinkedList<T> ref = new LinkedList<>();
        recursiveSearchUntilEmpty(pidField, idValues, parentSearchSupplier, ref);
        return ref;
    }

    /**
     * 递归搜索子项
     * <pre>
     *     {@code
     *         List<Relation> datas = List.of(
     *                 new Relation(1, 0),
     *                 new Relation(2, 1),
     *                 new Relation(3, 1),
     *                 new Relation(4, 2),
     *                 new Relation(5, 2),
     *                 new Relation(6, 3),
     *                 new Relation(7, 6),
     *                 new Relation(8, 7)
     *         );
     *         List<Relation> r1s = ReflectUtil.recursiveSearchChild("id", 1, ids -> {
     *             List<Relation> list = datas.stream().filter(s -> ids.contains(s.getPid())).toList();
     *             return list;
     *         });
     *     }
     * </pre>
     *
     * @param pidValue            PID 值
     * @param idField             id 字段
     * @param childSearchSupplier 子项搜索供应商
     * @return {@link List }<{@link T }>
     */
    public static <T, P> List<T> recursiveSearchChild(String idField, P pidValue, Function<List<P>, List<T>> childSearchSupplier) {
        List<P> pidValues = List.of(pidValue);
        return recursiveSearchChild(idField, pidValues, childSearchSupplier);
    }


    /**
     * 递归搜索子项
     *
     * @param pidValues           PID 值
     * @param idField             id 字段
     * @param childSearchSupplier 子项搜索供应商
     * @return {@link List }<{@link T }>
     */
    public static <T, P> List<T> recursiveSearchChild(String idField, List<P> pidValues, Function<List<P>, List<T>> childSearchSupplier) {
        LinkedList<T> ref = new LinkedList<>();
        recursiveSearchUntilEmpty(idField, pidValues, childSearchSupplier, ref);
        return ref;
    }

    /**
     * 递归搜索带有指定注解集合的字段。
     * 它接受一个对象和一个注解类的集合作为输入，并返回一个将每个注解类映射到带有该注解的字段列表的Map。
     */
    public static Map<Class<? extends Annotation>, List<Field>> recursiveSearchFieldByAnnotations(Class clazz
            , Collection<Class<? extends Annotation>> annotations) {
        HashMap<Class<? extends Annotation>, List<Field>> ref = new HashMap<>();
        recursiveSearchFieldByAnnotations(clazz, annotations, ref);
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
    public static <T, I> void recursiveSearch(List<T> source, List<T> ref, String idFiled
            , String pidFiled, I idValue) {
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
                throw new RuntimeException(e);
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
                throw new RuntimeException(e);
            }
        }
    }


    public static void keepValue(Object o, String fields) {
        Assert.notNull(fields, "fields can not be null");
        Assert.notEmpty(fields, "fields can not be empty");
        String[] matchFields = fields.split(",");
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            for (int i1 = 0; i1 < matchFields.length; i1++) {
                if (!declaredFields[i].getName().equals(matchFields[i1])) {
                    declaredFields[i].setAccessible(true);
                    try {
                        declaredFields[i].set(o, null);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void eraseValue(Object o, Class<?>... fieldTypes) {
        for (Class<?> fieldClass : fieldTypes) {
            Assert.notNull(fieldClass, "fields can not be null");
        }
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            for (Class<?> fieldClass : fieldTypes) {
                if (declaredFields[i].getType() == fieldClass) {
                    declaredFields[i].setAccessible(true);
                    try {
                        declaredFields[i].set(o, null);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void eraseValue(Object o, String fields) {
        Assert.notNull(fields, "fields can not be null");
        Assert.notEmpty(fields, "fields can not be empty");
        Field[] declaredFields = o.getClass().getDeclaredFields();
        if (REGEX_ALL.equals(fields)) {
            for (int i = 0; i < declaredFields.length; i++) {
                declaredFields[i].setAccessible(true);
                try {
                    declaredFields[i].set(o, null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            return;
        }
        String[] matchFields = fields.split(",");
        for (int i = 0; i < declaredFields.length; i++) {
            for (int i1 = 0; i1 < matchFields.length; i1++) {
                if (declaredFields[i].getName().equals(matchFields[i1])) {
                    declaredFields[i].setAccessible(true);
                    try {
                        declaredFields[i].set(o, null);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
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


    public static <T> T mapToEntity(Map<String, Object> map, Class<T> tClass) {
        return mapToEntity(map, tClass, false, false);
    }

    public static <T> T mapToEntity(Map<String, Object> map, Class<T> tClass, boolean mustMatchAll, boolean matchNull) {
        T t = null;
        try {
            t = tClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (Map.Entry<String, Object> e : map.entrySet()) {
            if ((e.getValue() == null) && !matchNull) {
                continue;
            }
            String key = e.getKey();
            try {
                Field declaredField = t.getClass().getDeclaredField(key);
                declaredField.set(t, e.getValue());
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                if (mustMatchAll) {
                    throw new RuntimeException(ex);
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
                //ignore
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
            } catch (NoSuchFieldException | IllegalAccessException ignore) {
                //ignore
            }
        }
    }

    public static <T> T copyProperties(Object source, Class<T> tClass, boolean matchNull) {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        T t = null;
        try {
            t = tClass.getDeclaredConstructor().newInstance();
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
            } catch (NoSuchFieldException | IllegalAccessException ignore) {
                //ignore
            }
        }
        return t;
    }


    private static void recursiveSearchFieldValueByAnnotations(String path, Object e
            , Collection<Class<? extends Annotation>> annotations, Map<Class<? extends Annotation>
                    , List<FieldContainer>> ref, HashSet<Integer> mappedBeans) {
        if (e == null || mappedBeans.contains(System.identityHashCode(e))) {
            return;
        }
        if (searchIfInstanceOfCollection(path, e, annotations, ref, mappedBeans)) {
            return;
        }
        Field[] declaredFields = e.getClass().getDeclaredFields();
        //mark mapped,处理已经解析过的object,通过identityHashCode防止两个对象的hashcode计算相同
        mappedBeans.add(System.identityHashCode(e));
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            String indexPath = path.concat(".").concat(declaredField.getName());
            log.trace("analyze field,object={},indexPath={}", e.getClass().getName(), indexPath);
//            declaredField.setAccessible(true);
            for (Class<? extends Annotation> annotation : annotations) {
                if (declaredField.getAnnotation(annotation) != null) {
                    //解析到注解
                    List<FieldContainer> fieldContainers = ref.get(annotation);
                    if (fieldContainers == null) {
                        fieldContainers = new ArrayList<>();
                        ref.put(annotation, fieldContainers);
                    }
                    fieldContainers.add(new FieldContainer(e, declaredField, indexPath));
                    declaredField.setAccessible(true);
                }
            }
            if (isSimpleField(declaredField)) {
                Object filedObject = null;
                declaredField.setAccessible(true);
                try {
                    filedObject = declaredField.get(e);
                    if (filedObject != null && ((filedObject instanceof Collection) || (filedObject instanceof Map))) {
                        recursiveSearchFieldValueByAnnotations(indexPath, filedObject, annotations, ref, mappedBeans);
                    } else if (isNotJavaClass(filedObject)) {
                        recursiveSearchFieldValueByAnnotations(indexPath, filedObject, annotations, ref, mappedBeans);
                    }
                } catch (IllegalAccessException ignore) {
                    //ignore
                }
            }
        }
    }

    private static boolean isNotJavaClass(Object filedObject) {
        return filedObject != null &&
                !(filedObject.getClass().getPackage() != null
                        && (
                        filedObject.getClass().getPackage().getName().startsWith("java") ||
                                filedObject.getClass().getPackage().getName().startsWith("sun")
                )
                );
    }

    private static boolean isSimpleField(Field declaredField) {
        return (
                !(declaredField.getGenericType() instanceof TypeVariable)//不是泛型
                        && declaredField.getType() != Object.class //不是Object class
        )
                && !declaredField.getType().isPrimitive() //不是基础类型
                && !Modifier.isStatic(declaredField.getModifiers())//不是static
                && !Modifier.isFinal(declaredField.getModifiers())//不是final
                || declaredField.getType().isMemberClass();//或者可以是匿名内部类
    }

    private static boolean searchIfInstanceOfCollection(String path, Object e, Collection<Class<? extends Annotation>> annotations
            , Map<Class<? extends Annotation>, List<FieldContainer>> ref, HashSet<Integer> mappedBeans) {
        if (e instanceof Collection) {
            Collection<?> collection = (Collection<?>) e;
            int index = 0;
            for (Object item : collection) {
                String indexPath = path.concat("[").concat(String.valueOf(index++)).concat("]");
                if (isNotJavaClass(item)) {
                    recursiveSearchFieldValueByAnnotations(indexPath, item, annotations, ref, mappedBeans);
                }
            }
            return true;
        } else if (e instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) e;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                String indexPath = path.concat("<").concat(entry.getKey().toString()).concat(">");
                if (isNotJavaClass(entry.getValue())) {
                    recursiveSearchFieldValueByAnnotations(indexPath, entry.getValue(), annotations, ref, mappedBeans);
                }
            }
            return true;
        }
        return false;
    }


//
//    /**
//     * 递归搜索带有指定注解的字段值
//     * 该代码以对象和注解类的集合作为输入，并返回一个包含注解作为键和字段容器列表作为值的映射。
//     * 字段容器包含有关带有指定注解的字段的信息。
//     * 支持字段为集合类{@link Collection},{@link Map}支持,如果为集合类则会循环解析获取所有集合内对象的字段
//     */
//    public static Map<Class<? extends Annotation>, List<FieldContainer>> recursiveSearchFieldValueByAnnotations(Object e
//    , Collection<Class<? extends Annotation>> annotations) {
//        HashMap<Class<? extends Annotation>, List<FieldContainer>> ref = new HashMap<>();
//        HashSet<Integer> mappedBeans = new HashSet<>();
//        recursiveSearchFieldValueByAnnotations(e, annotations, ref, mappedBeans);
//        return ref;
//    }
//
//
//    private static void recursiveSearchFieldValueByAnnotations(Object e, Collection<Class<? extends Annotation>> annotations
//    , Map<Class<? extends Annotation>
//            , List<FieldContainer>> ref, HashSet<Integer> mappedBeans) {
//        if (e == null || mappedBeans.contains(System.identityHashCode(e))) {
//            return;
//        }
//        if (e instanceof Collection) {
//            Collection<?> collection = (Collection<?>) e;
//            for (Object item : collection) {
//                recursiveSearchFieldValueByAnnotations(item, annotations, ref, mappedBeans);
//            }
//            return;
//        } else if (e instanceof Map) {
//            Map<?, ?> map = (Map<?, ?>) e;
//            for (Object item : map.values()) {
//                recursiveSearchFieldValueByAnnotations(item, annotations, ref, mappedBeans);
//            }
//            return;
//        }
//        Field[] declaredFields = e.getClass().getDeclaredFields();
//        //mark mapped,处理已经解析过的object,通过identityHashCode防止两个对象的hashcode计算相同
//        mappedBeans.add(System.identityHashCode(e));
//        for (int i = 0; i < declaredFields.length; i++) {
//            Field declaredField = declaredFields[i];

    /// /            declaredField.setAccessible(true);
//            for (Class<? extends Annotation> annotation : annotations) {
//                if (declaredField.getAnnotation(annotation) != null) {
//                    List<FieldContainer> fieldContainers = ref.get(annotation);
//                    if (fieldContainers == null) {
//                        fieldContainers = new ArrayList<>();
//                        ref.put(annotation, fieldContainers);
//                    }
//                    fieldContainers.add(new FieldContainer(e, declaredField));
//                    declaredField.setAccessible(true);
//                }
//            }
//            if (!(!(declaredField.getGenericType() instanceof TypeVariable) && declaredField.getType() == Object.class) &&
//                    !declaredField.getType().isPrimitive() &&
//                    !Modifier.isStatic(declaredField.getModifiers()) &&
//                    !Modifier.isFinal(declaredField.getModifiers()) ||
//                    declaredField.getType().isMemberClass()
//            ) {
//                Object filedObject = null;
//                declaredField.setAccessible(true);
//                try {
//                    filedObject = declaredField.get(e);
//                    if (filedObject == null || (filedObject.getClass().getPackage() != null &&
//                            (
//                                    filedObject.getClass().getPackage().getName().startsWith("java") ||
//                                            filedObject.getClass().getPackage().getName().startsWith("sun")
//                            )
//                    )
//                    ) {
//                        continue;
//                    }
//                } catch (IllegalAccessException ignore) {
//                }
//                recursiveSearchFieldValueByAnnotations(filedObject, annotations, ref, mappedBeans);
//            }
//        }
//    }
//
    private static void recursiveSearchFieldByAnnotations(Class clazz, Collection<Class<? extends Annotation>> annotations
            , Map<Class<? extends Annotation>, List<Field>> ref) {
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


    private static <P, T> void recursiveSearchUntilEmpty(String idField
            , List<P> pidValues, Function<List<P>, List<T>> childSearchSupplier, List<T> ref) {
        List<T> child = childSearchSupplier.apply(pidValues);
        if (CollectionUtil.isNotEmpty(child)) {
            ref.addAll(child);
            List<P> childIdValues = child.stream().map(c -> {
                try {
                    Field id = c.getClass().getDeclaredField(idField);
                    accessFields(id);
                    Object idValue = id.get(c);
                    return ((P) idValue);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).toList();
            if (childIdValues.isEmpty()) {
                return;
            }
            recursiveSearchUntilEmpty(idField, childIdValues, childSearchSupplier, ref);
        }
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

    private static void accessFields(Field... fields) {
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
        }
    }
}
