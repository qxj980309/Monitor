package com.example.monitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.monitor.entity.Certification;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CertificationMapper extends BaseMapper<Certification> {
    //SELECT * FROM tb_certification_info_copy1 WHERE end_date <= CURRENT_DATE + INTERVAL '2 months';
    @Select("SELECT * FROM tb_certification_info_copy1 WHERE end_date <= (DATE_ADD(NOW(),INTERVAL +2 MONTH)) " +
            "AND (discard_flag is null or discard_flag != 'y')")
    List<Certification> selectList();

    @Select("SELECT * FROM tb_certification_info_copy1 WHERE sign_org = #{signOrg} AND type =#{type} " +
            "AND sys_name= #{sysName} AND environment = #{environment} AND interacted_system= #{interactedSystem} " +
            "AND (discard_flag  is null or discard_flag != 'y')")
    Certification selectOne(String signOrg, String type, String sysName, String environment, String interactedSystem);

    @Delete("Delete FROM tb_certification_info_copy1 where discard_flag = 'y'")
    int remove();

    @Update("Update tb_certification_info_copy1 Set discard_flag = 'y' Where end_time < NOW() AND (discard_flag is null or discard_flag != 'y')")
    int InfoUpdate();
}
