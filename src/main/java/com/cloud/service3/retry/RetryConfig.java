package com.cloud.service3.retry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @ClassName retry
 * @Description: retry 类（或接口）是
 * @Author: zhonghanbang
 * @Date: 2021/7/2316:24
 */
@Configuration
@EnableRetry(proxyTargetClass = true)
public class RetryConfig {

    @Bean
    public RetryTemplate simpleRetryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        // 最大重试次数策略
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy(3);
        retryTemplate.setRetryPolicy(simpleRetryPolicy);
        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        // 每隔1s后再重试
        fixedBackOffPolicy.setBackOffPeriod(1000);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
        return retryTemplate;
    }

}