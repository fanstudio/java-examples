package com.fanstudio;

import org.zeromq.ZMQ;

/**
 * @author Admin
 * @date 2019/2/20
 * @description
 */
public class SubClient {

    public static void main(String[] args) {
        // 创建socket
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.SUB);
        // 建立连接
        socket.connect(ExampleConfig.TCP_PUBLISH__SERVER);
        // 设置订阅
        socket.subscribe(ExampleConfig.TOPIC_NAME);

        // 模拟订阅测试
        System.out.println("Start test.");
        while (true) {
            byte[] bytes = socket.recv();
            System.out.println(new String(bytes));
        }
    }

}
