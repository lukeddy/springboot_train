package com.tangzq.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 每5秒执行一次
     */
    @Scheduled(fixedRate = 5000)
    public void method() {
        System.out.println("method 当前时间：" + dateFormat.format(new Date()));
    }

    /**
     * 首次执行2秒以后，以后每8秒执行一次
     */
    @Scheduled(initialDelay = 2000,fixedDelay = 8000)
    public void method2(){
        System.out.println("method2 当前时间：" + dateFormat.format(new Date()));
    }

    /**
     * 每一分钟执行一次
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void method3(){
        System.out.println("method3 当前时间：" + dateFormat.format(new Date()));
    }

    /**
     * 每天凌晨3点10分执行
     */
    @Scheduled(cron = "0 10 3 * * ?")
    public void method4(){
        System.out.println("method4 当前时间：" + dateFormat.format(new Date()));
    }
}
