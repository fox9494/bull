package com.example.bull.task;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
public class ScheduleConfig {


    @Bean
    public ThreadPoolTaskScheduler poolScheduler(){
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(5);
        scheduler.setThreadNamePrefix("myPool");
//        scheduler.setWaitForTasksToCompleteOnShutdown(true);
//        scheduler.setAwaitTerminationSeconds(120);
        return  scheduler;
    }
}
