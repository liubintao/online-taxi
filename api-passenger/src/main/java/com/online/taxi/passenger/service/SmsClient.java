package com.online.taxi.passenger.service;

import com.online.taxi.common.dto.ResponseResult;
import com.online.taxi.common.dto.sms.SmsSendRequest;
import com.online.taxi.passenger.service.impl.SmsClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-sms", fallback = SmsClientFallback.class)
public interface SmsClient {
    /**
     * 按照短信模板发送验证码
     * @param smsSendRequest
     * @return
     */
    @RequestMapping(value = "/send/alisms-template", method = RequestMethod.POST)
    ResponseResult sendSms(SmsSendRequest smsSendRequest);
}
