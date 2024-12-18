package com.fairychar.bag.beans.spring.advice;

import com.fairychar.bag.pojo.vo.InvalidateFieldVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * @author chiyo <br>
 * @since 1.3.2
 */
@AllArgsConstructor
@Getter
public class InvalidateLog implements Serializable {
    private String tag;
    private String uri;
    private List<InvalidateFieldVO> errorFields;
}
