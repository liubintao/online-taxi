package com.online.taxi.common.dto.sms;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * 发送短信request
 */
@Data
public class SmsSendRequest {
    /**
     * 短信接收人数组
     */
    private String[] receivers;
    /**
     * 短信数据
     */
    private List<SmsTemplateDto> data;

    @Override
    public String toString() {
        return "SmsSendRequest{" +
                "receivers=" + Arrays.toString(receivers) +
                ", data=" + data +
                '}';
    }
}
