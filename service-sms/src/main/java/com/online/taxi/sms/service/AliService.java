package com.online.taxi.sms.service;

import com.online.taxi.common.dto.sms.SmsSendRequest;

public interface AliService {

    /**
     * 发送短信
     * @param request
     * @return
     */
    int sendSms(SmsSendRequest request);
}
