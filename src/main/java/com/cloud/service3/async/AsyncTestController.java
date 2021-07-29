package com.cloud.service3.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @ClassName AsyncTestController
 * @Description: AsyncTestController 类（或接口）是
 * @Author: zhonghanbang
 * @Date: 2021/7/2910:22
 */
@RestController
@RequestMapping("/api/async")
public class AsyncTestController {

    @Autowired
    AsyncService asyncService;

    @GetMapping()
    public void getVoice(String name) throws ExecutionException, InterruptedException {
        System.out.println("run begin");

        asyncService.asyncFirst(name);
        asyncService.asyncSecond(name);
        Future<String> task1 = asyncService.asyncFourth();
        System.out.println(task1.get());
        asyncService.asyncThird(name);

        System.out.println("run end");
    }

}
