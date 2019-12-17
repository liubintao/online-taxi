package com.online.taxi.mq.config;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {
    /**
     * 队列中消息最大数量
     */
    private static final int _maxSize = 2;

    /**
     * 消息队列，阻塞式队列，底层是循环数组
     */
    private static final ArrayBlockingQueue<String> _queue = new ArrayBlockingQueue<String>(2);

    /**
     * 向队列插入消息
     *
     * @param msg 消息
     */
    public static void produce(String msg) {
        /**
         * 队列未满，插入成功返回true，队列满，插入失败返回false
         */
        if (_queue.offer(msg)) {
            System.out.println("成功 生产消息：" + msg + "当前队列大小：" + _queue.size());
        } else {
            System.out.println("队列已满");
        }
    }

    /**
     * 从队列取消息
     *
     * @return 队列消息
     */
    public static String consumer() {
        /**
         * 队列中有数据返回头部数据，否则返回null
         */
        String msg = _queue.poll();
        if (msg != null) {
            System.out.println("成功 消费消息：" + msg + "当前队列大小：" + _queue.size());
        } else {
            System.out.println("无消息可消费");
        }
        return msg;
    }
}
