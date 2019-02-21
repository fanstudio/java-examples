package com.fanstudio;

import org.zeromq.ZMQ;

/**
 * @author Admin
 * @date 2019/2/21
 * @description
 */
public class PushServer {
    /**
     * Push Server类似于一个发牌方,Pull Client类似于收牌方，但是收到的牌不一定一样多。
     * @param args
     */
    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.PUSH);
        socket.bind(ExampleConfig.TCP_PUSH_SERVER);

        int ticketNum = 0;
        while (ticketNum <= 30) {
            socket.send(ExampleConfig.PUSH_FLAG + " (msg) " + ticketNum);
            System.out.println("Last send ticketNum:" + ticketNum);
            ticketNum++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        socket.close();
        context.close();
    }
}
