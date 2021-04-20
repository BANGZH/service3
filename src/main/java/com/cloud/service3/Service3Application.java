package com.cloud.service3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
// @EnableEurekaClient
// @EnableFeignClients
public class Service3Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Service3Application.class, args);
    }


    // public Date stringToDateTime(String dateTime){
    //     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //     Date date = null;
    //     try {
    //         date = formatter.parse(dateTime);
    //     } catch (ParseException e) {
    //         System.out.println("错误");
    //     }
    //     return date;
    // }
    //
    // @Override
    // public void run(String... args) throws Exception {
    //     String start = "2021-04-01 15:40:00";
    //     ApiBootJobParamWrapper apiBootJobParamWrapper = new ApiBootJobParamWrapper();
    //     apiBootJobParamWrapper.put("test1","111");
    //     apiBootJobParamWrapper.put("test2","222");
    //     apiBootJobParamWrapper.put("test3","333");
    //     quartzService.newJob(ApiBootOnceJobWrapper.Context()
    //             .jobClass(DemoJob.class)
    //             .startAtTime(stringToDateTime(start))
    //             .param(apiBootJobParamWrapper)
    //             .wrapper()
    //     );
    //
    // }
}
