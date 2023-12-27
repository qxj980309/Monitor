package com.example.monitor.controller;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor")
//@Component
public class MonitorController {
    // 每周执行一次，获取需要预警的数据
    @Scheduled(cron = "0 30 14 ? * 5") // cron表达式：每周五下午两点半 执行
    public void doTask(){
        System.out.println("我是定时任务~");
    }
}
