package com.online.taxi.order.service;

import com.online.taxi.common.dto.ResponseResult;

public interface GrabService {
    /**
     * 司机抢单
     * @param orderId
     * @param driverId
     * @return
     */
    public ResponseResult grabOrder(int orderId, int driverId);
}
