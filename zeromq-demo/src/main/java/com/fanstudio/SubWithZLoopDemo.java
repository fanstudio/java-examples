package com.fanstudio;

import org.zeromq.ZContext;
import org.zeromq.ZLoop;
import org.zeromq.ZMQ;

/**
 * @author Admin
 * @date 2019/3/7
 * @description
 */
public class SubWithZLoopDemo {
    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        final ZMQ.Socket socket = context.socket(ZMQ.SUB);
        socket.connect(ExampleConfig.TCP_PUBLISH_SERVER);
        socket.subscribe(ExampleConfig.TOPIC_NAME1);

        new Thread(new Runnable() {
            public void run() {
                int idx = 0;
                String topicName = null;
                while (true) {
                    try {
                        Thread.sleep(3000);
                        System.out.println("change subscribe");
                        if ((idx++ % 2) == 0) {
                            topicName = ExampleConfig.TOPIC_NAME1;
                        } else {
                            topicName = ExampleConfig.TOPIC_NAME2;
                        }
                        System.out.println(socket.subscribe(topicName));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        System.out.println("Preper start zloop");

        // run with zloop
        ZContext context1 = new ZContext();
        ZLoop loop = new ZLoop(context1);
        ZMQ.PollItem item = new ZMQ.PollItem(socket, ZMQ.Poller.POLLIN);
        loop.addPoller(item, new ZLoop.IZLoopHandler() {
            public int handle(ZLoop zLoop, ZMQ.PollItem pollItem, Object o) {
                byte[] bytes = pollItem.getSocket().recv();
                System.out.println(new String(bytes));
                return 0;
            }
        }, null);

        System.out.println("start loop");
        loop.start();

    }
}
