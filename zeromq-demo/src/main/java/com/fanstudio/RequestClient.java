package com.fanstudio;

import org.zeromq.ZMQ;

import java.util.Date;

/**
 * @author Admin
 * @date 2019/2/21
 * @description
 */
public class RequestClient {
    /**
     * 这个例子存在的问题：client在send之后，recv接受服务器端回发的信息，
     * 如果服务器崩溃，没有返回，则client会一直阻塞着，即使server重启也没法响应
     * 解决办法可参考：https://www.oschina.net/question/725072_162588
     * @param args
     */
    public static void main(String[] args) {
        // 创建socket
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.REQ);

        // 建立连接，这里的connect一直返回的是true
        socket.connect(ExampleConfig.TCP_RESPONSE_SERVER);

        // 模拟业务处理
        System.out.println("Start test.");
        while (true) {
            // 发送请求,即使server未开启，这里的send结合会一直返回true
            boolean ret = socket.send(ExampleConfig.REQUEST_PREFIX + "request message" + new Date().toString());
            // 接收响应,服务端未响应时，这里会阻塞
            byte[] bytes = socket.recv();
            System.out.println(new String(bytes));
        }
    }
}
