// package com.cloud.service3.service;
//
// import com.cloud.service3.entity.DemoJob;
// import org.minbox.framework.api.boot.plugin.quartz.ApiBootQuartzService;
// import org.minbox.framework.api.boot.plugin.quartz.wrapper.ApiBootJobParamWrapper;
// import org.minbox.framework.api.boot.plugin.quartz.wrapper.support.ApiBootOnceJobWrapper;
// import org.springframework.beans.factory.annotation.Autowired;
//
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;
//
// /**
//  * @ClassName quartzDemoService
//  * @Description: quartzDemoService 类（或接口）是
//  * @Author: zhonghanbang
//  * @Date: 2021/4/115:10
//  */
// public class quartzDemoService {
//
//     @Autowired
//     private ApiBootQuartzService quartzService;
//
//     public void test() {
//         String start = "2021-04-01 15:40:00";
//         ApiBootJobParamWrapper apiBootJobParamWrapper = new ApiBootJobParamWrapper();
//         apiBootJobParamWrapper.put("test1","111");
//         apiBootJobParamWrapper.put("test2","222");
//         apiBootJobParamWrapper.put("test3","333");
//         quartzService.newJob(ApiBootOnceJobWrapper.Context()
//                 .jobClass(DemoJob.class)
//                 .startAtTime(stringToDateTime(start))
//                 .param(apiBootJobParamWrapper)
//                 .wrapper()
//         );
//     }
//
//     public Date stringToDateTime(String dateTime){
//         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//         Date date = null;
//         try {
//             date = formatter.parse(dateTime);
//         } catch (ParseException e) {
//             System.out.println("错误");
//         }
//         return date;
//     }
//
// }
