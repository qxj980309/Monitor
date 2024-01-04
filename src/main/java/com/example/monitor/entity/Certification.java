package com.example.monitor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@TableName("tb_certification_info_copy1")
public class Certification {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private Integer id;

    @ApiModelProperty(value = "系统名称")
    @NotBlank(message = "系统名称不能为空")
    @TableField(value = "sys_name")
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private String  sysName;

    @ApiModelProperty(value = "证书关联系统")
    @NotBlank(message = "证书关联系统(合作银行)不能为空")
    @TableField(value = "interacted_system")
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private String  interactedSystem;

    @ApiModelProperty(value = "其他证书使用者")
    @TableField(value = "other_users")
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private String  otherUsers;

    @ApiModelProperty(value = "证书序列号字段")
    @TableField(value = "serial_number")
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private String serialNumber;

    @ApiModelProperty(value = "证书类型")
    @NotBlank(message = "证书类型不能为空")
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private String type;

    @ApiModelProperty(value = "签发机构")
    @NotBlank(message = "签发机构不能为空")
    @TableField(value = "sign_org")
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private String  signOrg;

    @ApiModelProperty(value = "证书生效时间")
    @TableField(value = "begin_date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-8")
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private Date beginDate;


    @ApiModelProperty(value = "到期时间")
    @NotBlank(message = "到期时间不能为空")
    @TableField(value = "end_date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-8")
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private Date endDate;

    @ApiModelProperty(value = "环境")
    @NotBlank(message = "环境不能为空")
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private String environment;

    @ApiModelProperty(value = "废弃标识（y/n）")
    @TableField(value = "discard_flag")
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private String  discardFlag;

    @ApiModelProperty(value = "备注")
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private String note;

}
