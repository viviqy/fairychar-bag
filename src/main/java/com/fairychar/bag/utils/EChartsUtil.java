package com.fairychar.bag.utils;

import com.fairychar.bag.pojo.ao.EChartsNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IDEA <br>
 * User: lmq <br>
 * Date: 2020/3/25 <br>
 * time: 15:13 <br>
 *
 * @author lmq <br>
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EChartsUtil {
    public final static List<EChartsNode<Integer>> mapToNode(Map<? extends Object, ? extends Object> groupingBy) {
        return wrapEcharsNode(groupingBy);
    }


    private static List<EChartsNode<Integer>> wrapEcharsNode(Map<? extends Object, ? extends Object> map) {
        List<EChartsNode<Integer>> collect = map.entrySet().stream().map(e -> {
            EChartsNode<Integer> node = new EChartsNode<>();
            node.setName(String.valueOf(e.getKey()));
            if (e.getValue() instanceof List) {
                node.setValue(((List) e.getValue()).size());
            } else {
                node.setValue(((Map) e.getValue()).size());
                node.setChild(wrapEcharsNode(((Map<? extends Object,? extends Object>) map.get(e.getKey()))));
            }
            return node;
        }).collect(Collectors.toList());
        return collect;
    }
}
