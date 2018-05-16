package ioDemo.bufferedDemo;

import java.io.*;

// 操作字符缓冲流
public class BufferedReaderWriterDemo {

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader("src/ioDemo/file/txt/test4.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/ioDemo/file/txt/test5.txt"))
        ) {
            String line;
            // String readLine()：读取一个文本行
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                // void	newLine()：写出一个行分隔符
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
