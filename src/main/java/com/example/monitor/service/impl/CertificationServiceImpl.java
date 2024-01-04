package com.example.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.monitor.entity.Certification;
import com.example.monitor.mapper.CertificationMapper;
import com.example.monitor.service.CertificationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CertificationServiceImpl implements CertificationService {
    @Resource
    private CertificationMapper certificationMapper;

    @Override
    public int save(Certification certification) {
        if (Objects.nonNull(certification) && certification.getSysName()!=null) {
            selectAndUpdate(certification);
            return certificationMapper.insert(certification);
        }
        return 0;
    }

    @Override
    public int saveBatch(List<Certification> certificationList) {
        int count = 0;
        if (certificationList.size()>0){
            for (Certification certification : certificationList) {
                if (Objects.nonNull(certification) && certification.getSysName()!=null) {
                    updateInfo(certification);
                    count = certificationMapper.insert(certification);
                    count++;
                }
            }
        }
        return count;
    }

    private void selectAndUpdate(Certification certification) {
        Certification update = certificationMapper.selectOne(certification.getSignOrg(), certification.getType(),
                certification.getSysName(), certification.getEnvironment(), certification.getInteractedSystem());
        if (Objects.nonNull(update)) {
            update.setDiscardFlag("y");
            certificationMapper.updateById(update);
        }
    }

    @Override
    public List<Certification> list() {
        List<Certification> certificationList = certificationMapper.selectList();
        List<Certification> certifications =new ArrayList<>();
        if (Objects.nonNull(certificationList)){
            for (Certification c : certificationList) {
                Certification certification = new Certification();
                String endDate = new SimpleDateFormat("yyyy-MM-dd").format(c.getEndDate());
                String users = c.getOtherUsers();
                if (StringUtils.isBlank(c.getOtherUsers())){
                    certification.setNote(c.getSysName()+c.getEnvironment()+"环境的"+c.getType()+"证书将于"+endDate+"到期");
                } else {
                    certification.setNote(c.getSysName()+c.getEnvironment()+"环境和关联系统"+users+"的"+c.getType()+"证书将于"+endDate+"到期");
                }
                certifications.add(certification);
            }
        }
        return certifications;
    }

    @Override
    public int InfoUpdate() {
        return certificationMapper.InfoUpdate();
    }

    @Override
    public int remove() {
        return certificationMapper.remove();
    }

    @Override
    public int updateInfo(Certification certification) {
        // 1. 更新的字段
        Certification update = new Certification();
        update.setDiscardFlag("y");
        // 2.更新的条件
        QueryWrapper<Certification> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotEmpty(certification.getSignOrg()),"sign_org",certification.getSignOrg());
        queryWrapper.eq(StringUtils.isNotEmpty(certification.getType()),"type",certification.getType());
        queryWrapper.eq(StringUtils.isNotEmpty(certification.getSysName()),"sys_name",certification.getSysName());
        queryWrapper.eq(StringUtils.isNotEmpty(certification.getEnvironment()),"environment",certification.getEnvironment());
        queryWrapper.eq(StringUtils.isNotEmpty(certification.getInteractedSystem()),"interacted_system",certification.getInteractedSystem());
        // 3.更新操作
        return certificationMapper.update(update,queryWrapper);
    }
}
