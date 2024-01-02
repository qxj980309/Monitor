package com.example.monitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.monitor.entity.Certification;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CertificationMapper extends BaseMapper<Certification> {
    @Select("SELECT * FROM tb_certification_info_copy1 WHERE end_time <= (DATE_ADD(NOW(),INTERVAL +2 MONTH)) " +
            "AND (discard_flag is null or discard_flag != 'y')")
    List<Certification> findInfo();

    @Select("SELECT * FROM tb_certification_info_copy1 WHERE sign_org = #{signOrg} AND type =#{type} " +
            "AND sys_name= #{sysName} AND environment = #{environment} AND interacted_system= #{interactedSystem} " +
            "AND (discard_flag  is null or discard_flag != 'y')")
    Certification selectInfo(String signOrg, String type, String sysName, String environment, String interactedSystem);

//    @Update("Update tb_certification_info_copy1 Set discard_flag = 'y' Where end_time < NOW() AND (discard_flag is null or discard_flag != 'y')")
//    int InfoUpdate();

    @Delete("Delete FROM tb_certification_info_copy1 where discard_flag = 'y'")
    int infoDel();
}
