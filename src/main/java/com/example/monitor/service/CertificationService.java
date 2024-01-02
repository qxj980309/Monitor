package com.example.monitor.service;

import com.example.monitor.entity.Certification;

import java.util.List;

public interface CertificationService {

    List<Certification> findInfo();

    int insertOne(Certification certification);

    int insertList(List<Certification> certificationList);

    int InfoUpdate();

    int infoDel();

    int updateInfo(Certification certification);

//    int updateInfo(String signOrg, String type, String sysName, String environment, String interactedSystem);
}
