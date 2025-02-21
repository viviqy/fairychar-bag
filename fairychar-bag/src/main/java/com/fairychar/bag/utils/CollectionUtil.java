package com.fairychar.bag.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chiyo <br>
 * @since 1.3.2
 */
public class CollectionUtil {


    /**
     * 将一个 List 尽量平均分成指定份数
     *
     * @param originalList  原始列表
     * @param numberOfParts 指定数量
     * @return {@link List }<{@link List }<{@link T }>>
     */
    public static <T> List<List<T>> splitList(List<T> originalList, int numberOfParts) {
        List<List<T>> result = new ArrayList<>();
        if (originalList.size() <= numberOfParts) {
            for (int i = 0; i < originalList.size(); i++) {
                ArrayList<T> sub = new ArrayList<>(1);
                sub.add(originalList.get(i));
                result.add(sub);
            }
            for (int i = originalList.size(); i < numberOfParts; i++) {
                result.add(new ArrayList<>(0));
            }
        } else {
            int size = originalList.size();
            int partSize = size / numberOfParts;  // 每份的最小大小
            int remainder = size % numberOfParts; // 余数，分配给前面几份
            int startIndex = 0;
            for (int i = 0; i < numberOfParts; i++) {
                // 计算当前分段的大小，如果有余数，则前几段大小加 1
                int currentPartSize = partSize + (i < remainder ? 1 : 0);
                int endIndex = startIndex + currentPartSize;
                List<T> part = new ArrayList<>(originalList.subList(startIndex, endIndex));
                result.add(part);
                startIndex = endIndex; // 更新起始索引
            }
        }
        return result;
    }
}
