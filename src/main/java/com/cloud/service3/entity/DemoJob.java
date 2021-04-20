// package com.cloud.service3.entity;
//
// import org.quartz.JobDataMap;
// import org.quartz.JobExecutionContext;
// import org.quartz.JobExecutionException;
// import org.springframework.scheduling.quartz.QuartzJobBean;
//
// /**
//  * 示例任务
//  *
//  * @author 恒宇少年
//  */
// public class DemoJob extends QuartzJobBean {
//     @Override
//     protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//         System.out.println("任务执行了..");
//
//         JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
//
//         System.out.println("任务执行结束..");
//
//     }
// }
