package com.online.taxi.mq.client;

import com.online.taxi.mq.server.BrokerServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 消息队列测试客户端
 */
public class MqClient {

    /**
     * 生产消息
     * @param msg
     * @throws Exception
     */
    public static void produce(String msg) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.PORT);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());

        pw.println(msg);
        pw.flush();
        socket.close();
    }

    /**
     * 消费消息
     * @return
     * @throws Exception
     */
    public static String consumer() throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.PORT);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());

        pw.println("consumer");
        pw.flush();

        String msg = in.readLine();

        socket.close();
        return msg;
    }

    public static void main(String[] args) throws Exception {
        produce("1");
        produce("2");
        produce("3");
        produce("4");
        produce("5");

        System.out.println(consumer());
    }
}
