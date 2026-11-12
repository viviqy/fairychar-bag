package com.example.sdkdemo.controller;

import com.example.sdkdemo.service.SdkLockService;
import com.fairychar.bag.domain.annotations.RequestLog;
import com.fairychar.bag.pojo.vo.HttpResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sdk-demo/features")
@RequiredArgsConstructor
public class SdkFeatureController {
    private final SdkLockService lockService;

    @GetMapping("/local-lock")
    @RequestLog
    public HttpResult<String> localLock() {
        return HttpResult.ok(lockService.execute());
    }
}
