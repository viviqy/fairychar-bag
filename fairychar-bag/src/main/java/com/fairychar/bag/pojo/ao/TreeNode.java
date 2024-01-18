package com.fairychar.bag.pojo.ao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Datetime: 2021/12/8 23:39
 *
 * @author chiyo
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class TreeNode<T> implements Serializable {
    private static final long serialVersionUID = 374862911861656958L;
    private T value;
    private List<TreeNode<T>> child;
}
