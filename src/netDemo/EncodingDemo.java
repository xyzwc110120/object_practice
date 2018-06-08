package netDemo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

// application/x-www-form-urlencoded 机制编码及解码
public class EncodingDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // 获取平台默认字符集
        System.out.println(System.getProperty("file.encoding"));

        // 使用 UTF-8 编码
        String str = "哎哟嘞 666-_abc";
        String urlEncoder = URLEncoder.encode(str, "UTF-8");
        System.out.println(urlEncoder);     // %E5%93%8E%E5%93%9F%E5%98%9E+666-_abc

        // 使用 UTF-8 解码
        String urlDecoder = URLDecoder.decode(urlEncoder, "UTF-8");
        System.out.println(urlDecoder);
    }

}
