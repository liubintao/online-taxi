package com.online.taxi.order.service;

/**
 * @author
 */
public interface RenewGrabLockService {

    /**
     * 续约
     * @param key
     * @param value
     * @param time
     */
    public void renewLock(String key, String value, int time);
}
