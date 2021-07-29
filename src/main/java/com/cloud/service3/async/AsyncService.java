package com.cloud.service3.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @ClassName AsyncDemo
 * @Description: AsyncDemo 类（或接口）是
 * @Author: zhonghanbang
 * @Date: 2021/7/2910:19
 */
@Service
public class AsyncService {

    /**
     * 异步执行,调用方无需等待其执行完成.
     * @param name
     */
    @Async
    public void asyncFirst(String name) {
        System.out.println("first run " + name);

    }

    @Async
    public void asyncSecond(String name) {
        System.out.println("second run " + name);

    }

    @Async
    public void asyncThird(String name) {
        System.out.println("third run " + name);

    }

    /**
     * 异步执行,调用需要等待执行完成.
     * @return
     */
    @Async
    public Future<String> asyncFourth() {
        System.out.println("开始做任务4");
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        System.out.println("完成任务4，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务4完成");
    }
}
