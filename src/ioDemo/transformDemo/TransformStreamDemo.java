package ioDemo.transformDemo;

import java.io.*;

// 转换流示例
public class TransformStreamDemo {

    public static void main(String[] args) {
        try (
                Reader reader = new InputStreamReader(new FileInputStream("src/ioDemo/file/txt/test4.txt"), "UTF-8");
                Writer writer = new OutputStreamWriter(new FileOutputStream("src/ioDemo/file/txt/test5.txt"), "UTF-8")
        ) {
            char[] chars = new char[1024];
            int len;
            while ((len = reader.read(chars)) > 0) {
                writer.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}