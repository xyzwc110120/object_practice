package ioDemo.ArrayDemo;


import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

// 字符数组/内存流
public class CharArrayDemo {

    public static void main(String[] args) throws IOException {
        CharArrayWriter writer = new CharArrayWriter();
        // writer.write("哎呀妈，我的天呐！！！！！！");
        writer.write(new String("哎呀妈，我的天呐！！！！！！".getBytes("GBK")));
        char[] buffer = writer.toCharArray();

        CharArrayReader reader = new CharArrayReader(buffer);
        char[] chars = new char[5];
        int len;
        while ((len = reader.read(chars)) > 0) {
            System.out.print(new String(chars, 0, len));
        }
        // CharArrayWriter 调用 close() 无效，但是 CharArrayReader 调用 close() 是有效的
        reader.close();
        System.out.println();
    }

}
