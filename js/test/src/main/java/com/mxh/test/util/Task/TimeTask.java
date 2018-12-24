package com.mxh.test.util.Task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther: 666先生的救赎
 * @date: 2018/12/23 17:48
 *
 * 定时任务
 */
@Component
public class TimeTask {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron="0/5 * * * * ?")
    public void job(){
        //System.out.println("马鑫海到此一游 ----" + sdf.format(new Date()));
    }

}
