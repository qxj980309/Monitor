package com.example.monitor.task;

import com.example.monitor.entity.Certification;
import com.example.monitor.service.CertificationService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component

public class CertificationTask {

        private static final Logger log = LoggerFactory.getLogger(CertificationTask.class);

        @Resource
        private CertificationService certificationService;
//        // 每周执行一次，获取需要预警的数据
        @Scheduled(cron = "0 30 14 ? * 5") //每周五下午两点半 执行
        public void doTaskSelect(){
            log.info("定时任务开始~");
            List<Certification> certifications= certificationService.findInfo();
            ArrayList<String> list = new ArrayList();
            for (Certification c : certifications) {
                String note = c.getNote();
                list.add(note);
            }
            log.info("当前时间：{}\t\t任务：cron task，每5秒执行一次",list,System.currentTimeMillis());
            log.info("定时任务结束~");
        }

//        @Scheduled(cron = "*/5 * * * * ?")
//        public void task2() {
//            List<Certification> certifications= certificationService.findInfo();
//            ArrayList<String> list = new ArrayList();
//            for (Certification c : certifications) {
//                String note = c.getNote();
//                list.add(note);
//            }
//            log.info("当前时间：{}\t\t任务：cron task，每5秒执行一次",list,System.currentTimeMillis());
//        }

//        @Scheduled(cron = "0 0 8 * * ?") //  每天中午8点触发
//        public void doTaskUpdate(){
//            int count = certificationService.InfoUpdate();
//            log.info("当前时间：{}\t\t任务：cron task，每天中午8点执行一次",count,System.currentTimeMillis());
//        }

        @Scheduled(cron = "0 0 18 28-31 * ?") //  每月的最后一个星期五上午8点触发
        public void doTaskDel(){
            int count = certificationService.infoDel();
            log.info("当前时间：{}\t\t任务：cron task，月的最后一个星期五上午8点执行一次",count,System.currentTimeMillis());
        }
    }
