package com.example.monitor.service;

import com.example.monitor.entity.Certification;

import java.util.List;

public interface CertificationService {

    List<Certification> findInfo();

    int insertOne(Certification certification);

    int insertList(List<Certification> certificationList);

    int InfoUpdate();

    int infoDel();
}
