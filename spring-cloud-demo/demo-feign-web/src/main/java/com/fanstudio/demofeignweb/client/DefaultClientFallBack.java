package com.fanstudio.demofeignweb.client;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangfan
 * @date 2019/3/27
 * @description
 */
public class DefaultClientFallBack implements DefaultClient {
    public Map<String, String> showServiceInfo() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", "请求失败，请稍后再试！");
        return map;
    }
}
