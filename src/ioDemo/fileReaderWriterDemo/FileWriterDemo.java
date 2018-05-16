package ioDemo.fileReaderWriterDemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// 文件字符输出流
public class FileWriterDemo {

    public static void main(String[] args) {
        // 1：创建目标对象
        File target = new File("src/ioDemo/file/txt/test5.txt");
        // 2：创建文件字符输出流对象
        try (
                /*
                    FileWriter(File file)： 根据给定的 File 对象构造一个 FileWriter 对象
                    FileWriter(File file, boolean append)：
                            append：如果为 true，则将字节写入文件末尾处，而不是写重写文件，默认未 false
                */
                Writer writer = new FileWriter(target)
        ) {
            /*
                void write(int c)：向外写出一个字符
                void write(char[] c)：向外写出多个字符
                void write(char[] c, int off, int len)：将 c 数组索引为 off 开始的长度为 len 个字符写向外写出
                void write(String str)：向外写出一个字符串
                void write(String str, int off, int len) 向外写出字符串的某一部分
            */
            writer.write(65);
            writer.write(10);
            writer.write("ABCDE".toCharArray());
            writer.write(10);
            writer.write("ABCDE".toCharArray(), 2, 2);
            writer.write(10);
            writer.write("ABCDEF");
            writer.write("\n");     // 转义字符，换行
            writer.write("ABCDEF", 2, 2);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
