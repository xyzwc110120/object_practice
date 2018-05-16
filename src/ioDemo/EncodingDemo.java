package ioDemo;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;

// 字符编码和解码操作
public class EncodingDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "开玩笑";
        byte[] bytes = str.getBytes("UTF-8");
        System.out.println(Arrays.toString(bytes));         // [-27, -68, -128, -25, -114, -87, -25, -84, -111]
        // 因为编码字符集与解码字符集不一致，所以乱码
        String ret = new String(bytes, "ISO-8859-1");
        System.out.println(ret);        // å¼ç©ç¬

        // 解决方法（按照解码的字符集编码还原成原 byte 数组，然后使用正确的字符集解码）
        bytes = ret.getBytes("ISO-8859-1");
        System.out.println(Arrays.toString(bytes));         // [-27, -68, -128, -25, -114, -87, -25, -84, -111]
        ret = new String(bytes, "UTF-8");
        System.out.println(ret);        // 开玩笑

    }

}
