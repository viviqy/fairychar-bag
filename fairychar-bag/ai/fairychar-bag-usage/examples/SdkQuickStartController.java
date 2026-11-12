package com.example.sdkdemo.controller;

import com.fairychar.bag.beans.spring.mvc.FuzzyResult;
import com.fairychar.bag.beans.spring.mvc.FuzzyValue;
import com.fairychar.bag.beans.spring.mvc.KeepValue;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.domain.exceptions.RestException;
import com.fairychar.bag.pojo.vo.HttpResult;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sdk-demo")
public class SdkQuickStartController {

    @PostMapping("/users")
    public HttpResult<CreateUserQuery> create(@RequestBody @Valid @KeepValue CreateUserQuery query) {
        return HttpResult.ok(query);
    }

    @GetMapping("/contact")
    @FuzzyResult(field = "data")
    public HttpResult<ContactVO> contact() {
        ContactVO contact = new ContactVO();
        contact.phone = "13812345678";
        return HttpResult.ok(contact);
    }

    @GetMapping("/failure")
    public HttpResult<Void> failure() {
        throw new RestException(RestErrorCode.DATA_NOT_EXIST);
    }

    public static class CreateUserQuery {
        @KeepValue
        @NotBlank
        public String name;
        public String roleCode;
    }

    public static class ContactVO {
        @FuzzyValue(beginAt = 3, endAt = 7)
        public String phone;
    }
}
