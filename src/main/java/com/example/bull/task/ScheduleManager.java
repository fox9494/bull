package com.example.bull.task;

import com.example.bull.Exception.MyRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ScheduledFuture;

@Component
public class ScheduleManager {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleManager.class);
    @Autowired
    private ThreadPoolTaskScheduler poolScheduler;

    private Map<String,ScheduledFuture> mapFuture = new HashMap<>();


    private List<BaseTask> tasks = Arrays.asList(new MyTask("task1"),new MyTask("task2"));


    @PostConstruct
    public void init(){
        logger.info("开始初始化启动定时任务");
        for (BaseTask task : tasks) {
            startJob(task);
        }
    }



    public void startJob(BaseTask task){
        if (mapFuture.get(task.getTaskName())!=null){
            throw new MyRuntimeException("已经存在该任务",-1);
        }
        logger.info("开始启动定时任务job:{}",task.getTaskName());
        ScheduledFuture<?> future = poolScheduler.schedule(task, new CronTrigger("*/5 * * * * ?"));
        mapFuture.put(task.getTaskName(),future);
        logger.info("结束启动定时任务job:{}",task.getTaskName());
    }

    public boolean stopJob(String taskName){
        boolean result=false;
        ScheduledFuture future = mapFuture.get(taskName);
        if (future==null){
            logger.info("the task:{} is not exist",taskName);
            return result;
        }
        result = future.cancel(false);
        return result;
    }

    public void stopAllJob(){
        if (mapFuture.isEmpty()){
            throw new MyRuntimeException("没有可以停止得任务",-1);
        }
        Set<Map.Entry<String, ScheduledFuture>> entrySet = mapFuture.entrySet();
        logger.info("正在停止所有任务。。。。");
        for (Map.Entry<String, ScheduledFuture> futureEntry : entrySet) {
            logger.info("正在停止定时任务:{}",futureEntry.getKey());
             futureEntry.getValue().cancel(false);
        }
        logger.info("停止任务完成。。。。");
    }
}
