package com.fanstudio;

/**
 * @author Admin
 * @date 2019/2/20
 * @description
 */
public class ExampleConfig {
    public static final String TCP_PUBLISH_SERVER = "tcp://localhost:5678";
    public static final String TOPIC_NAME1 = "[TEST_TOPIC_HEAD1]";
    public static final String TOPIC_NAME2 = "[TEST_TOPIC_HEAD2]";

    public static final String TCP_RESPONSE_SERVER = "tcp://localhost:6678";
    public static final String REQUEST_PREFIX = "[REQ]";
    public static final String RESPONSE_PREFIX = "[RESPONSE]";

    public static final String TCP_PUSH_SERVER = "tcp://localhost:7678";
    public static final String PUSH_FLAG = "[PUSH_FLAG]";

    public static final String TCP_PULL_SERVER = "tcp://localhost:8678";
    public static final String PULL_FLAG = "[PULL_FLAG]";
}
