package com.online.taxi.passenger.controller;

import com.online.taxi.common.constant.CommonStatusEnum;
import com.online.taxi.common.dto.ResponseResult;
import com.online.taxi.common.util.PhoneUtil;
import com.online.taxi.passenger.dto.ShortMsgRequest;
import com.online.taxi.passenger.service.ShortMsgService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
@Slf4j
public class SmsController {

    @Autowired
    private ShortMsgService shortMsgService;

    /**
     * 发送验证码
     *
     * @param shortMsgRequest
     * @return //	@HystrixCommand(fallbackMethod = "sendFail")
     */
//    @HystrixCommand(fallbackMethod = "sendFail")
    @PostMapping("/verify-code/send")
    public ResponseResult verifyCodeSend(@RequestBody ShortMsgRequest shortMsgRequest) {
        String phoneNumber = shortMsgRequest.getPhoneNumber();

        //校验手机号
        if (StringUtils.isBlank(phoneNumber)) {
            return ResponseResult.fail(CommonStatusEnum.PHONENUMBER_EMPTY.getCode(), CommonStatusEnum.PHONENUMBER_EMPTY.getValue());
        }

        if (!PhoneUtil.isPhone(phoneNumber)) {
            return ResponseResult.fail(CommonStatusEnum.PHONENUMBER_ERROR.getCode(), CommonStatusEnum.PHONENUMBER_ERROR.getValue());
        }

        //获取验证码-正常代码
        //String code = verificationCodeService.getCode(phoneNumber);
        String code = "010101";
        log.info("service-verification-code 返回的验证码：" + code);
        shortMsgService.send(phoneNumber, code);

        return ResponseResult.success(null);
    }

    public ResponseResult sendFail(ShortMsgRequest shortMsgRequest) {
        return ResponseResult.fail(-1, "熔断");
    }
}
