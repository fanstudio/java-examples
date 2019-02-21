package com.fanstudio;

import org.zeromq.ZMQ;

import java.util.Date;

/**
 * @author Admin
 * @date 2019/2/21
 * @description
 */
public class ResponseServer {
    public static void main(String[] args) {
        // 创建socket
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.REP);

        // bind,这里的bind失败会抛异常
        socket.bind(ExampleConfig.TCP_RESPONSE_SERVER);

        // 模拟业务处理
        System.out.println("Start test.");
        while (true) {
            // 接收请求的数据
            byte[] bytes = socket.recv();
            System.out.println(new String(bytes));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 响应请求
            socket.send(ExampleConfig.RESPONSE_PREFIX + "message from response server " + new Date().toString());
        }

    }
}
