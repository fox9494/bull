package com.example.bull.task;


import com.example.bull.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

public class MyTask extends BaseTask{



    private static final Logger logger = LoggerFactory.getLogger(MyTask.class);

    public MyTask(String taskName) {
        super(taskName);
    }

//    @Scheduled(initialDelay = 1000,fixedRate = 1000)
//    @Transactional
    public void doTask()  {
        logger.info("开始执行定时任务");
        long start=System.currentTimeMillis();
//        int result = userServiceImp.update(1L,100);
//        result = userServiceImp.updateby(2L,100);
        long inteval=0;
        while(inteval<=1000*20){
            long curent =  System.currentTimeMillis();
            inteval = curent - start;
        }
//        userServiceImp.update(1L,200);

        logger.info("结束执行定时任务-------");
    }


    @Override
    public void run() {
        logger.info("开始执行子类定时任务");
        long start=System.currentTimeMillis();
        long inteval=0;
        while(inteval<=1000*30){
            long curent =  System.currentTimeMillis();
            inteval = curent - start;
        }
        logger.info("结束执行子类定时任务-------");
    }
}
