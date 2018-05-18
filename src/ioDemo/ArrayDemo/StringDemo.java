package ioDemo.ArrayDemo;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

// 字符串流
public class StringDemo {

    public static void main(String[] args) throws IOException {
        StringWriter writer = new StringWriter();
        writer.write("字符编码是真的麻烦");

        StringReader reader = new StringReader(writer.toString());
        char[] buffer = new char[5];
        int len;
        while ((len = reader.read(buffer)) > 0) {
            System.out.print(new String(buffer, 0, len));
        }
        // StringWriter 调用 close() 无效，但是 StringReader 调用 close() 是有效的
        reader.close();
        System.out.println();
    }

}
