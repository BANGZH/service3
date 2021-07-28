package com.cloud.service3.retry;

import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @ClassName RetryService
 * @Description: RetryService 类（或接口）是
 * @Author: zhonghanbang
 * @Date: 2021/7/2316:27
 */
@Service
public class RetryService {

    @Retryable(include = RetryException.class, exclude = IllegalArgumentException.class,
            backoff = @Backoff(delay = 1000, maxDelay = 2000),
            maxAttempts = 3
    )
    public void retry(String p1, String p2) {
        int second = LocalDateTime.now().getSecond();
        int flag = second % 10;
        if (flag != 0) {
            System.out.println("进入重试" + flag);
            throw new RetryException("重试");
        }
        System.out.println("done");
    }

    @Recover
    public void recover(RetryException e, String p1, String p2) {
        e.printStackTrace();
        System.out.println(p1+p2);
        System.out.println("recover run");
    }
}
