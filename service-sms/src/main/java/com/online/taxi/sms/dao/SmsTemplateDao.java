package com.online.taxi.sms.dao;

import com.online.taxi.common.entity.SmsTemplate;
import com.online.taxi.sms.mapper.SmsTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SmsTemplateDao {
    @Autowired
    private SmsTemplateMapper smsTemplateMapper;

    public SmsTemplate getByTemplateId(String templateId) {
        return smsTemplateMapper.selectByTemplateId(templateId);
    }
}
