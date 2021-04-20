package com.cloud.service3.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.FileOutputStream;

@Service
public class SpeechSynthesizerRestfulDemo {

    @Value("${aliyun.token}")
    private String accessToken;
    @Value("${aliyun.appKey}")
    private String appKey;
    // private String voiceUrl = "https://nls-gateway.cn-shanghai.aliyuncs.com/stream/v1/tts?appkey={0}&token={1}&text={2}&format={3}&voice={4}&sample_rate={5}";
    private String voiceUrl2 = "https://nls-gateway.cn-shanghai.aliyuncs.com/stream/v1/tts";

    /**
     * HTTPS GET请求
     * @return
     * api说明文档：
     * https://help.aliyun.com/document_detail/94737.html?spm=a2c4g.11186623.6.614.36903069JL71Lf
     */
    public File processGETRequest(String text, String format, int sampleRate, String voice) {
        // voice 发音人，可选，默认是xiaoyun。
        // url = url + "&voice=" + "xiaoyun";
        // volume 音量，范围是0~100，可选，默认50。
        // url = url + "&volume=" + String.valueOf(50);
        // speech_rate 语速，范围是-500~500，可选，默认是0。
        // url = url + "&speech_rate=" + String.valueOf(0);
        // pitch_rate 语调，范围是-500~500，可选，默认是0。
        // url = url + "&pitch_rate=" + String.valueOf(0);

        String tempFile = "/usr/app/temp/" + text +".mp3";
        // 构建参数
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(voiceUrl2)
                .queryParam("appkey",appKey)
                .queryParam("token",accessToken)
                .queryParam("text",text)
                .queryParam("format",format)
                .queryParam("voice",voice)
                .queryParam("sample_rate",sampleRate);
        String url = builder.toUriString();

        /**
         * 发送HTTPS GET请求，处理服务端的响应。
         */
        Request request = new Request.Builder().url(url).get().build();
        try {
            long start = System.currentTimeMillis();
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();
            System.out.println("total latency :" + (System.currentTimeMillis() - start) + " ms");
            System.out.println(response.headers().toString());
            String contentType = response.header("Content-Type");
            if ("audio/mpeg".equals(contentType)) {
                File file = File.createTempFile(text,".mp3");
                // File file = new File(tempFile);
                // if (!file .getParentFile().exists()) {
                //     file .getParentFile().mkdirs();
                // }
                // if(!file .exists()) {
                //     file .createNewFile();
                // }
                System.out.println("文件路径"+ file.getAbsolutePath());
                FileOutputStream fout = new FileOutputStream(file);
                fout.write(response.body().bytes());
                fout.close();
                System.out.println("The GET request succeed!");
                return file;
            }
            else {
                // ContentType 为 null 或者为 "application/json"
                // 重试机制
                String errorMessage = response.body().string();
                System.out.println("The GET request failed: " + errorMessage);
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}