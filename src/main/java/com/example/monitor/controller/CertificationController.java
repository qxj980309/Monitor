package com.example.monitor.controller;

import com.example.monitor.entity.Certification;
import com.example.monitor.service.CertificationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/certification")
//@Component
public class CertificationController {
    @Resource
    private CertificationService certificationService;

    @PostMapping("/insertOne")
    public int insertOne(@RequestBody Certification certification){
        return certificationService.insertOne(certification);
    }

    @PostMapping("/insertList")
    public int insertList(@RequestBody List<Certification> certificationList){
        return certificationService.insertList(certificationList);
    }

    @PostMapping("/info")
    public List<Certification> infoList(){
        return certificationService.findInfo();
    }
}
