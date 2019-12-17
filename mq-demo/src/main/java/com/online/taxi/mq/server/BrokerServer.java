package com.online.taxi.mq.server;

import com.online.taxi.mq.config.Broker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BrokerServer implements Runnable {

    public static int PORT = 9999;
    private final Socket socket;

    public BrokerServer(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            while (true) {
                String line = in.readLine();
                if (null == line) {
                    continue;
                }

                System.out.println("收到消息：" + line);

                if ("consumer".equals(line)) {
                    String msg = Broker.consumer();
                    pw.println(msg);
                    pw.flush();
                } else {
                    Broker.produce(line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new BrokerServer(socket)).start();
        }
    }
}
