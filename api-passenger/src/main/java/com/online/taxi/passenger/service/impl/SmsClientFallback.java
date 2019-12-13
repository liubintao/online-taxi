package com.online.taxi.passenger.service.impl;

import com.online.taxi.common.constant.CommonStatusEnum;
import com.online.taxi.common.dto.ResponseResult;
import com.online.taxi.common.dto.sms.SmsSendRequest;
import com.online.taxi.passenger.service.SmsClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class SmsClientFallback implements SmsClient {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public ResponseResult sendSms(SmsSendRequest smsSendRequest) {
        log.info("不好意思,我熔断了");

        String key = "service-sms";
        String noticeStr = stringRedisTemplate.opsForValue().get(key);

        if (StringUtils.isNotBlank(noticeStr)) {
            log.info("通知过了，我先不通知了");
        } else {
            //发送短信，或者调用电话接口
            log.info("通知别人我熔断了");
            stringRedisTemplate.opsForValue().set(key, "notice", 30, TimeUnit.SECONDS);
        }
        return ResponseResult.fail(CommonStatusEnum.FAIL.getCode(), CommonStatusEnum.FAIL.getValue());
    }
}
