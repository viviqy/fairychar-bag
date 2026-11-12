package com.example.sdkdemo.service;

import com.fairychar.bag.domain.annotations.MethodLock;
import org.springframework.stereotype.Service;

@Service
public class SdkLockService {

    @MethodLock(lockType = MethodLock.Type.LOCAL, nameExpression = "'sdk-demo:operation'")
    public String execute() {
        return "completed";
    }
}
