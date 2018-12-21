package com.example.bull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class MyContextClosedHandler implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    private ThreadPoolTaskScheduler poolScheduler;

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        poolScheduler.setWaitForTasksToCompleteOnShutdown(true);
        poolScheduler.setAwaitTerminationSeconds(90);
        poolScheduler.shutdown();
    }
}
