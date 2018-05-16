package ioDemo.fileReaderWriterDemo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// 文件字符输入流
public class FileReaderDemo {

    public static void main(String[] args) {
        // 1：创建源对象
        File source = new File("src/ioDemo/file/txt/test4.txt");
        // 2：创建流对象
        try (
                Reader reader = new FileReader(source)
        ) {
            // 读取操作
            /*
            int read()：
                    每次读取一个字符，若无数据，返回 -1
            int	read(char[] c)：
                    每次读取多个字符并存储至 c 数组中，若无数据，返回 -1
            abstract int read(char[] c, int off, int len)：
                    读取 len 个字节存储到数组 c 中，从数组的 off 索引位置开始存储。返回读取的字节总数，若未读取到数据，则返回 -1
            */
            // reader.read();
            char[] chars = new char[6];
            int len;
            while ((len = reader.read(chars)) > 0) {
                System.out.print(new String(chars, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
