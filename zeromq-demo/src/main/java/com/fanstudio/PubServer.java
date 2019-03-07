package com.fanstudio;

import org.zeromq.ZMQ;

import java.util.Date;

/**
 * @author Admin
 * @date 2019/2/20
 * @description
 */
public class PubServer {
    public static void main(String[] args) {
        // 创建socket
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.PUB);

        // 绑定
        socket.bind(ExampleConfig.TCP_PUBLISH_SERVER);

        // 模拟业务处理
        System.out.println("Start test");
        while (true) {
            // 注意：要使订阅方要能收到消息，发送方在发送时每次都要先发送和主题字符串一样的内容
            socket.send(ExampleConfig.TOPIC_NAME1 + "This is pub message1 " + new Date().toString(), 0);
            socket.send(ExampleConfig.TOPIC_NAME2 + "This is pub message2 " + new Date().toString(), 0);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
