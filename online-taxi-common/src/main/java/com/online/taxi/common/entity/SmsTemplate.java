package com.online.taxi.common.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * tbl_sms_template
 * @author 
 */
@Data
public class SmsTemplate implements Serializable {
    private Integer id;

    /**
     * 短信模板ID
     */
    private String templateId;

    private String templateName;

    /**
     * 模板内容
     */
    private String content;

    private Date createTime;

    private Date updateTime;

    /**
     * 模板类型（1：营销；2：通知；3：订单）
     */
    private Boolean templateType;

    private static final long serialVersionUID = 1L;
}