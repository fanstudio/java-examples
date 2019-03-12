package com.fanstudio.bit.demo;

/**
 * @author zhangfan
 * @date 2019/3/12
 * @description ipv4与数值直接的互转
 */
public class IpCovertTool {
    /**
     * ipv4字符串转本地小端数值
     * @param ip
     * @return
     */
    private static Long ipv4String2Local(String ip) {
        String[] split = ip.split("\\.");
        if (split.length != 4) {
            return null;
        }

        long value = 0L;

        for (int i = 0; i < 4; i++) {
            int tmp = Integer.parseInt(split[i]);
            if (tmp < 0 || tmp > 255) { return null; }
            value |=  (tmp & 0xff) << (i * 8);
        }

        return value & 0xffffffffL;
    }

    /**
     * ipv4小端数值转点分字符串
     * @param ip
     * @return
     */
    private static String localIpv4String(Long ip) {
        int ip0 = (int) (ip & 0xff);
        int ip1 = (int) (ip >> 8 & 0xff);
        int ip2 = (int) (ip >> 16 & 0xff);
        int ip3 = (int) (ip >> 24 & 0xff);


        return "" + ip0 + "." + ip1 + "." + ip2 + "." + ip3 ;
    }


    private static void test(String str) {
        Long value = ipv4String2Local(str);
        System.out.println(value);
        System.out.println(localIpv4String(value));
        System.out.println("-------------");
    }

    public static void main(String[] args) {
        test("0.0.0.0");
        test("255.255.255.255");
        test("127.0.0.1");
        test("192.168.1.1");
        test("10.0.0.1");
        test("224.0.0.1");
    }


}
