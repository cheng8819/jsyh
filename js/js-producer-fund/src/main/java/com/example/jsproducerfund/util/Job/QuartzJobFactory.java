package com.example.jsproducerfund.util.Job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/25 21:41
 *
 * 定时任务运行工厂
 */
@Component("QuartzJobFactory")
public class QuartzJobFactory implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("任务成功运行");
        ScheduleJob scheduleJob = (ScheduleJob)context.getMergedJobDataMap().get("scheduleJob");
        System.out.println("任务名称 = [" + scheduleJob.getJobName() + "]");
    }
}
