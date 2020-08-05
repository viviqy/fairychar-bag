package com.fairychar.test.domain;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Datetime: 2020/7/1 16:02 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@RequestMapping("/hello")
public interface IHelloController {
    @PostMapping("hi")
    Object hi();

//    @PostMapping("list")
//    Object list(ArrayList<String> list);
}
