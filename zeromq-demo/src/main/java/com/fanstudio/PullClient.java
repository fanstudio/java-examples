package com.fanstudio;

import org.zeromq.ZMQ;

/**
 * @author Admin
 * @date 2019/2/21
 * @description
 */
public class PullClient {
    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.PULL);

        socket.connect(ExampleConfig.TCP_PUSH_SERVER);
        int count = 0;
        while (true) {
            byte[] bytes = socket.recv();
            count++;
            System.out.println(new String(bytes) + "count:" + count);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
