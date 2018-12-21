package com.example.bull.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTask implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(BaseTask.class);

    private String taskName;

    public BaseTask(String taskName){
        this.taskName = taskName;
    }

    @Override
    public void run() {
        logger.info("开始执行定时任务");
        long start=System.currentTimeMillis();
        long inteval=0;
        while(inteval<=1000*30){
            long curent =  System.currentTimeMillis();
            inteval = curent - start;
        }
        logger.info("结束执行定时任务-------");
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
