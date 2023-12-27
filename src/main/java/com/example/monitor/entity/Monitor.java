package com.example.monitor.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_monitor_warning_data")
public class Monitor {

    @ApiModelProperty(value = "主键")
    @TableField(value = "warning_id")
    private int warningId;

    @ApiModelProperty(value = "系统编号")
    @TableField(value = "sys_code")
    private int sysCode;

    @ApiModelProperty(value = "系统名称")
    @TableField(value = "sys_name")
    private String sysName;

    @ApiModelProperty(value = "环境")
    private String environment;

    @ApiModelProperty(value = "合作银行")
    @TableField(value = "cooperative_bank")
    private String cooperativeBank;

    @ApiModelProperty(value = "金融机构编号")
    @TableField(value = "Institution_code")
    private String InstitutionCode;

    @ApiModelProperty(value = "证书序列号字段")
    @TableField(value = "serial_number")
    private String serialNumber;

    @ApiModelProperty(value = "证书类型")
    @TableField(value = "certificate_type")
    private String certificateType;

    @ApiModelProperty(value = "到期时间")
    @TableField(value = "end_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-8")
    private Date endTime;

    @ApiModelProperty(value = "预警时间")
    @TableField(value = "warning_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-8")
    private Date warningTime;

    @ApiModelProperty(value = "是否预警")
    @TableField(value = "warning_flag")
    private int  warningFlag;

    @ApiModelProperty(value = "备注")
    private String note;



}
