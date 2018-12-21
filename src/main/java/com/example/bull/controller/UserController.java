package com.example.bull.controller;

import com.example.bull.domain.User;
import com.example.bull.service.UserServiceImp;
import com.example.bull.task.MyTask;
import com.example.bull.task.ScheduleManager;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private ScheduleManager scheduleManager;


    @ApiOperation(value = "查找user",notes = "查找user")
//    @ApiImplicitParam(name = "name",value = "name",required = true)
    @RequestMapping(value = "/bull/user",method = RequestMethod.GET)
    public String findUser(@RequestParam String name){
        User user = userServiceImp.findByName(name);
        return user.toString();
    }

    @ApiOperation(value = "开始任务",notes = "开始任务")
    @RequestMapping(value = "/bull/task/start",method = RequestMethod.GET)
    public String startMyJob(@RequestParam String taskName){
        scheduleManager.startJob(new MyTask(taskName));
        return "success";
    }

    @ApiOperation(value = "停止任务",notes = "停止任务")
    @RequestMapping(value = "/bull/task/stop",method = RequestMethod.GET)
    public String stopMyJob(@RequestParam String taskName){
        boolean result = scheduleManager.stopJob(taskName);
        return String.valueOf(result);
    }

    @ApiOperation(value = "停止all任务",notes = "停止all任务")
    @RequestMapping(value = "/bull/task/stopAll",method = RequestMethod.GET)
    public String stopAllob(@RequestParam String taskName){
         scheduleManager.stopAllJob();
        return String.valueOf("success");
    }
}
