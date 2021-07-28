package com.cloud.service3.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BaseController
 * @Description: BaseController 类（或接口）是
 * @Author: zhonghanbang
 * @Date: 2020/11/13 10:11
 */
@RestController
@RequestMapping("/api/retry")
public class RetryController {

    @Autowired
    RetryService retryService;

    @GetMapping()
    public void getVoice() {
        retryService.retry("p1","p2");
    }
    
}
