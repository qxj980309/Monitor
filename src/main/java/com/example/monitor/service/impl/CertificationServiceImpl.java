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
    public int insertOne(Certification certification) {
        if (Objects.nonNull(certification) && certification.getSysName()!=null) {
            selectAndUpdate(certification);
            return certificationMapper.insert(certification);
        }
        return 0;
    }

    @Override
    public int insertList(List<Certification> certificationList) {
        int count = 0;
        if (certificationList.size()>0){
            for (Certification certification : certificationList) {
                if (Objects.nonNull(certification) && certification.getSysName()!=null) {
                    updateInfo(certification);
                    count = certificationMapper.insert(certification);
                    count++;
                }
            }
/*            for (Certification c : certificationList) {
                count = certificationMapper.insert(c);
                count++;
            }*/
        }
        return count;
    }


    private void selectAndUpdate(Certification certification) {
        Certification update = certificationMapper.selectInfo(certification.getSignOrg(), certification.getType(),
                certification.getSysName(), certification.getEnvironment(), certification.getInteractedSystem());
        if (Objects.nonNull(update)) {
            update.setDiscardFlag("y");
            certificationMapper.updateById(update);
        }
    }

    @Override
    public List<Certification> findInfo() {
        List<Certification> certificationList = certificationMapper.findInfo();
        List<Certification> certifications =new ArrayList<>();
        if (Objects.nonNull(certificationList)){
            for (Certification c : certificationList) {
                Certification certification = new Certification();
                Date date = c.getEndTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String endDate = sdf.format(date);
                String users = c.getOtherUsers();
                if (StringUtils.isBlank(c.getOtherUsers())){
                    certification.setNote(c.getSysName()+c.getEnvironment()+"环境的"+c.getType()+"将于"+endDate+"到期");
                } else {
                    certification.setNote(c.getSysName()+c.getEnvironment()+"环境和关联系统"+users+"的"+c.getType()+"将于"+endDate+"到期");
                }
                certifications.add(certification);
            }
            return certifications;
        }
        return null;
    }

    @Override
    public int InfoUpdate() {
        return certificationMapper.InfoUpdate();
    }

    @Override
    public int infoDel() {
        return certificationMapper.infoDel();
    }

    @Override
    public int updateInfo(Certification certification) {
        QueryWrapper<Certification> queryWrapper = new QueryWrapper<Certification>();
        int c = certificationMapper.update(certification,queryWrapper);
        return c;
    }
}
