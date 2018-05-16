package ioDemo.fileReaderWriterDemo;

import java.io.*;

// 使用文件字符流完成文件的拷贝
public class FileCopyDemo {

    public static void main(String[] args) {
        // 1：创建源和目标对象
        File source = new File("src/ioDemo/file/txt/test4.txt");
        File target = new File("src/ioDemo/file/txt/test5.txt");
        try (
                // 2：创建输入、输出流对象
                Reader reader = new FileReader(source);
                Writer writer = new FileWriter(target)
        ) {
            // 3：读、写操作
            char[] chars = new char[10];
            int len;
            while ((len = reader.read(chars)) > 0) {
                writer.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
