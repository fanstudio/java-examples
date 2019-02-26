package com.fanstudio;

import org.zeromq.ZMQ;

/**
 * @author Admin
 * @date 2019/2/25
 * @description
 */
public class PullServer {
    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.PULL);
        socket.bind(ExampleConfig.TCP_PULL_SERVER);

        while (true) {
            byte[] bytes = socket.recv();
            System.out.println(new String(bytes));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

