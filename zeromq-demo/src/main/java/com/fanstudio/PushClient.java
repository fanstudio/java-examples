package com.fanstudio;

import org.zeromq.ZMQ;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author Admin
 * @date 2019/2/25
 * @description
 */
public class PushClient {
    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.PUSH);
        socket.connect(ExampleConfig.TCP_PULL_SERVER);

        int idx = 1;
        while (true) {
            // 客户端发送成功的数据，如果没有被处理，且服务端的队列满了的情形下，将无法发送数据。
            socket.send(ExampleConfig.PUSH_FLAG + "message" + getProcessID() + "--" + idx);
            idx++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getProcessID() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])
                .intValue();
    }

}
