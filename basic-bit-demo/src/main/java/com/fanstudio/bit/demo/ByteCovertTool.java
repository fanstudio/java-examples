package com.fanstudio.bit.demo;

public class ByteCovertTool {
    private static final String[] hexArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    private static final String lineSeparator = System.getProperty("line.separator");

    public static void main(String[] args) {
     /*
    typedef struct {
        int8 a;
        uint8 b;
        // bitmap类型的使用示例
    #if BYTE_ORDER == LITTLE_ENDIAN
        uint8 value:6,
            status:2;
    #elif BYTE_ORDER == BIG_ENDIAN
        uint8 status:2,
        value:6;
    #else
    # error "Please fix <bits/endian.h>"
    #endif
        int8 pad;		// 填充位

        int16 c;
        uint16 d;

        int32 e;
        uint32 f;

        int64 g;
        uint64 h;
    }

    */

        // 1.构包示例
        System.out.println(isLittleEndian());
        byte[] bytes = new byte[32];
        // a = 0x11;
        putLocalByte2NetOrder(bytes, 0, (byte)0x11);

        // b = 0x8f;
        // java的数据类型都是有符号的,没有unsigned类型,
        // 0x8f默认会被当成整形,编译器会认为超出byte能表示的范围
        // 所以在网络传输unsgined类型的赋值时,需要将对应的数据强转,
        // 如下这样才不会保存8f超出java的byte范围了,
        putLocalByte2NetOrder(bytes, 1, (byte) 0x8f);
        // status=2;value=30;
        if (isLittleEndian()) {
            // 如果本地是小端,则status:7-8,value:1-6,
            putLocalByte2NetOrder(bytes, 2, (byte) ((2 << 6) | 30));
        } else {
            // 如果本地是大端,则status:1-2,value,3-8
            putLocalByte2NetOrder(bytes, 2, (byte) (2 | (30 << 2)));
        }

        short c1 = 0x1122;
        putLocalShort2NetOrder(bytes, 4, c1);
        System.out.println("c1:" + c1);

        short d1 = (short)0xffaa;
        putLocalShort2NetOrder(bytes, 6, d1);
        System.out.println("d1:" + d1);

        int e1 = 0x11223344;
        putLocalInt2NetOrder(bytes, 8, e1);
        System.out.println("e1:" + e1);

        int f1 = 0xffeeddcc;
        putLocalInt2NetOrder(bytes, 12, f1);
        System.out.println("f1:" + f1);

        long g1 = 0x1122334455667788L;
        putLocalLong2NetOrder(bytes, 16, g1);
        System.out.println("g1:" + g1);

        long h1 = 0xffeeddccbbaa9988L;
        putLocalLong2NetOrder(bytes, 24, h1);
        System.out.println("h1:" + h1);

        System.out.println(byte2HexString(bytes, true));

        // 2.解包示例
        System.out.println("-------------------------");
        // get a
        byte a = getLocalByteInNetOrder(bytes, 0);
        System.out.println(byte2HexString(new byte[]{a}, false));
        // get b
        byte b = getLocalByteInNetOrder(bytes, 1);
        System.out.println(byte2HexString(new byte[]{b}, false));

        // bitmap: get status & value
        byte tmp = getLocalByteInNetOrder(bytes, 2);
        System.out.println(byte2HexString(new byte[]{tmp}, false));
        System.out.println("tmp:" + tmp);

        // 注意java的右移操作陷阱
        if (isLittleEndian()) {
            // 小端取值status:7-8,value:1-6,
            // 先取位,这里的3指的是0b11,因为status只占两位,再无符号右移
            System.out.println("status:" + (byte)((tmp & (3 << 6)) >>> 6));
            // 0x3f,指低6位,即0b111111
            System.out.println("value:" + (tmp & 0x3f));
        } else {
            System.out.println("bigEndian");
            // 大端取值status:1-2,value:3-8
            System.out.println("status:" + (byte) (tmp & 3));
            // 先取位,再位移
            System.out.println("value:" + ((tmp & (0x3f << 2)) >>> 2));
        }

        // get c
        short c2 = getLocalShortInNetOrder(bytes, 4);
        System.out.println("c2:" + c2);

        // get d
        short d2 = getLocalShortInNetOrder(bytes, 6);
        System.out.println("d2:" + d2);

        int e2 = getLocalIntInNetOrder(bytes, 8);
        System.out.println("e2:" + e2);

        int f2 = getLocalIntInNetOrder(bytes, 12);
        System.out.println("f2:" + f2);

        long g2 = getLocalLongInNetOrder(bytes, 16);
        System.out.println("g2:" + g2);

        long h2 = getLocalLongInNetOrder(bytes, 24);
        System.out.println("h2:" + h2);


    }



    /**
     * 小端判断
     *
     * @return
     */
    public static boolean isLittleEndian() {
        byte flag = 0x21;
        return ((flag & 0xf) == 1);
    }

    public static void putLocalByte2NetOrder(byte[] bytes,int pos, byte value) {
        bytes[pos] = value;
    }

    public static void putLocalShort2NetOrder(byte[] bytes,int pos, short value) {
        byte value0 = (byte)(value & 0xff);
        byte value1 = (byte)((value & 0xff00) >>> 8);

        if (isLittleEndian()) {
            // 本地是小端时将高位值放低位
            bytes[pos] = value1;
            bytes[pos + 1] = value0;
        } else {
            // 大端则反之
            bytes[pos] = value0;
            bytes[pos + 1] = value1;
        }
    }

    public static void putLocalInt2NetOrder(byte[] bytes,int pos, int value) {
        byte value0 = (byte)(value & 0xff);
        byte value1 = (byte)((value & 0xff00) >>> 8);
        byte value2 = (byte)((value & 0xff0000) >>> 16);
        byte value3 = (byte)((value & 0xff000000) >>> 24);

        if (isLittleEndian()) {
            // 本地是小端时将高位值放低位
            bytes[pos] = value3;
            bytes[pos + 1] = value2;
            bytes[pos + 2] = value1;
            bytes[pos + 3] = value0;
        } else {
            // 大端则反之
            bytes[pos] = value0;
            bytes[pos + 1] = value1;
            bytes[pos + 2] = value2;
            bytes[pos + 3] = value3;
        }
    }

    public static void putLocalLong2NetOrder(byte[] bytes,int pos, long value) {
        byte value0 = (byte)(value & 0xffL);
        byte value1 = (byte)((value & 0xff00L) >>> 8);
        byte value2 = (byte)((value & 0xff0000L) >>> 16);
        byte value3 = (byte)((value & 0xff000000L) >>> 24);
        byte value4 = (byte)((value & 0xff00000000L) >>> 32);
        byte value5 = (byte)((value & 0xff0000000000L) >>> 40);
        byte value6 = (byte)((value & 0xff000000000000L) >>> 48);
        byte value7 = (byte)((value & 0xff00000000000000L) >>> 56);

        if (isLittleEndian()) {
            // 本地是小端时将高位值放低位
            bytes[pos] = value7;
            bytes[pos + 1] = value6;
            bytes[pos + 2] = value5;
            bytes[pos + 3] = value4;
            bytes[pos + 4] = value3;
            bytes[pos + 5] = value2;
            bytes[pos + 6] = value1;
            bytes[pos + 7] = value0;
        } else {
            // 大端则反之
            bytes[pos] = value0;
            bytes[pos + 1] = value1;
            bytes[pos + 2] = value2;
            bytes[pos + 3] = value3;
            bytes[pos + 4] = value4;
            bytes[pos + 5] = value5;
            bytes[pos + 6] = value6;
            bytes[pos + 7] = value7;
        }
    }

    /**
     * byte数组转16进制字符串
     *
     * @param bytes
     * @param needFmt 是否需要格式显示
     * @return
     */
    public static String byte2HexString(byte[] bytes, boolean needFmt) {
        if (bytes == null) return null;
        String s = "";
        for (int i = 0; i < bytes.length; i++) {
            // 注意位运算是将类型转换为int或者更大的数据类型来计算
            // 这里虽然是以>>和>>>结果是一样,但是为了规范还是使用>>>
            // 先显示高位,再显示低位,这是人类的书写和阅读习惯
            int height = (bytes[i] & 0xf0) >>> 4;
            int low = bytes[i] & 0xf;
            s = s + hexArr[height] + hexArr[low];

            // 格式化显示
            if (needFmt && (i != (bytes.length - 1))) {
                if ((i + 1) % 16 == 0) {
                    s += lineSeparator;
                } else {
                    s += " ";
                }
            }
        }
        return s;
    }

    public static byte getLocalByteInNetOrder(byte[] bytes, int pos) {
        return bytes[pos];
    }

    public static short getLocalShortInNetOrder(byte[] bytes, int pos) {
        if (isLittleEndian()) {
            return (short)(((bytes[pos] & 0xff) << 8) | (bytes[pos + 1]) & 0xff);
        } else {
            return (short)((bytes[pos] & 0xff) | ((bytes[pos + 1] & 0xff) << 8));
        }
    }

    public static int getLocalIntInNetOrder(byte[] bytes, int pos) {
        if (isLittleEndian()) {
            int value = (bytes[pos] & 0xff) << 24;
            value = value | ((bytes[pos + 1] & 0xff) << 16);
            value = value | ((bytes[pos + 2] & 0xff) << 8);
            value = value | (bytes[pos + 3] & 0xff);
            return value;
        } else {
            int value = bytes[pos] & 0xff;
            value = value | ((bytes[pos + 1] & 0xff) << 8);
            value = value | ((bytes[pos + 2] & 0xff) << 16);
            value = value | ((bytes[pos + 3] & 0xff) << 24);
            return value;
        }
    }

    public static long getLocalLongInNetOrder(byte[] bytes, int pos) {
        if (isLittleEndian()) {
            long value = (bytes[pos] & 0xffL) << 56;
            value = value | ((bytes[pos + 1] & 0xffL) << 48);
            value = value | ((bytes[pos + 2] & 0xffL) << 40);
            value = value | ((bytes[pos + 3] & 0xffL) << 32);
            value = value | ((bytes[pos + 4] & 0xffL) << 24);
            value = value | ((bytes[pos + 5] & 0xffL) << 16);
            value = value | ((bytes[pos + 6] & 0xffL) << 8);
            value = value | (bytes[pos + 7] & 0xffL);
            return value;
        } else {
            long value = bytes[pos] & 0xff;
            value = value | ((bytes[pos + 1] & 0xffL) << 8);
            value = value | ((bytes[pos + 2] & 0xffL) << 16);
            value = value | ((bytes[pos + 3] & 0xffL) << 24);
            value = value | ((bytes[pos + 4] & 0xffL) << 32);
            value = value | ((bytes[pos + 5] & 0xffL) << 40);
            value = value | ((bytes[pos + 6] & 0xffL) << 48);
            value = value | ((bytes[pos + 7] & 0xffL) << 56);
            return value;
        }
    }
}
