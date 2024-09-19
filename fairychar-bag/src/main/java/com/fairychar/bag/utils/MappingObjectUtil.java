package com.fairychar.bag.utils;

import com.fairychar.bag.pojo.ao.MapObjectNode;
import com.fairychar.bag.pojo.ao.MappingAO;
import com.fairychar.bag.pojo.ao.MappingObjectAO;
import com.fairychar.bag.pojo.ao.TreeNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * http影响体渲染工具类
 *
 * @author chiyo
 * @since 0.0.1-SNAPSHOT
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MappingObjectUtil {


    public static <T, I> List<TreeNode<T>> listToTree(List<T> source, String pidField, String idField, I idValue)
            throws NoSuchFieldException, IllegalAccessException {
        List<TreeNode<T>> root = new ArrayList<>();
        for (T node : source) {
            Field pid = node.getClass().getDeclaredField(pidField);
            pid.setAccessible(true);
            I pidValue = (I) pid.get(node);
            if (pidValue.equals(idValue)) {
                TreeNode<T> child = new TreeNode<T>();
                child.setValue(node);
                Field id = node.getClass().getDeclaredField(idField);
                id.setAccessible(true);
                List<TreeNode<T>> treeNodes = listToTree(source, pidField, idField, ((I) id.get(node)));
                if (!treeNodes.isEmpty()) {
                    child.setChild(treeNodes);
                }
                root.add(child);
            }
        }
        return root;
    }


    public static <T> List<MapObjectNode<T>> mapToNode(Map<? extends Object, ? extends Object> groupingBy) {
        return wrapTreeNode(groupingBy);
    }

    private static <T> List<MapObjectNode<T>> wrapTreeNode(Map<? extends Object, ? extends Object> map) {
        List<MapObjectNode<T>> collect = map.entrySet().stream().map(e -> {
            MapObjectNode<T> node = new MapObjectNode<>();
            node.setName(String.valueOf(e.getKey()));
            if (e.getValue() instanceof List) {
                node.setCount(((List) e.getValue()).size());
                node.setValue(((List<T>) e.getValue()));
            } else {
                node.setCount(((Map) e.getValue()).size());
                node.setChild(wrapTreeNode(((Map<? extends Object, ? extends Object>) map.get(e.getKey()))));
            }
            return node;
        }).collect(Collectors.toList());
        return collect;
    }

    public static <K, V> List<MappingAO<K, V>> mapping(Map<K, V> map) {
        return map.entrySet().stream().map(e -> new MappingAO<K, V>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }


    public static <K, V> List<MappingObjectAO<K, V>> mappingList(Map<K, List<V>> maps) {
        return maps.entrySet().stream()
                .map(e -> new MappingObjectAO<K, V>(e.getKey(), e.getValue().size(), e.getValue()))
                .collect(Collectors.toList());
    }

}
