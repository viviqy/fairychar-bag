package com.fairychar.bag.utils;

import com.fairychar.bag.pojo.ao.TreeNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/3/25 <br>
 * time: 15:13 <br>
 *
 * @author chiyo <br>
 * @since 0.0.1-SNAPSHOT
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TreeNodeUtil {
    public static <T> List<TreeNode<T>> mapToNode(Map<? extends Object, ? extends Object> groupingBy) {
        return wrapTreeNode(groupingBy);
    }

    private static <T> List<TreeNode<T>> wrapTreeNode(Map<? extends Object, ? extends Object> map) {
        List<TreeNode<T>> collect = map.entrySet().stream().map(e -> {
            TreeNode<T> node = new TreeNode<>();
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

//    private static List<EchartsNode<Integer>> wrapEcharsNode(Map<? extends Object, ? extends Object> map) {
//        List<EchartsNode<Integer>> collect = map.entrySet().stream().map(e -> {
//            EchartsNode<Integer> node = new EchartsNode<>();
//            node.setName(String.valueOf(e.getKey()));
//            if (e.getValue() instanceof List) {
//                node.setValue(((List) e.getValue()).size());
//            } else {
//                node.setValue(((Map) e.getValue()).size());
//                node.setChild(wrapEcharsNode(((Map<? extends Object,? extends Object>) map.get(e.getKey()))));
//            }
//            return node;
//        }).collect(Collectors.toList());
//        return collect;
//    }
}
