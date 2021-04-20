package com.cloud.service3.controller;

import com.cloud.service3.service.SpeechSynthesizerRestfulDemo;
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
@RequestMapping("/api/v1/base")
public class BaseController {

    // @Autowired
    // FeignTest feignTest;

    @Autowired
    SpeechSynthesizerRestfulDemo restfulDemo;

    @GetMapping
    public String getBase() {
        System.out.println("test1");
        System.out.println("test2");
        System.out.println("test2");
        return "service3 return";
    }

    @GetMapping("/voice")
    public void getVoice(String text, String format, int sampleRate, String voice) {
        restfulDemo.processGETRequest(text, format, sampleRate, voice);
    }




}
