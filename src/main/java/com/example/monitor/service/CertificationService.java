package com.example.monitor.service;

import com.example.monitor.entity.Certification;

import java.util.List;

public interface CertificationService {

    List<Certification> list();

    int save(Certification certification);

    int saveBatch(List<Certification> certificationList);

    int InfoUpdate();

    int remove();

    int updateInfo(Certification certification);

//    int updateInfo(String signOrg, String type, String sysName, String environment, String interactedSystem);
}
