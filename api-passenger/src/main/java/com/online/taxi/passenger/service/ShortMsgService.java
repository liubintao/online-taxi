package com.online.taxi.passenger.service;

import com.online.taxi.common.dto.ResponseResult;

public interface ShortMsgService {
    /**
     * 发送验证码
     * @param phoneNumber
     * @param code
     * @return
     */
    ResponseResult send(String phoneNumber, String code);
}
