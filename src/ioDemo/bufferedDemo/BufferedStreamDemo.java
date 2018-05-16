package ioDemo.bufferedDemo;

import java.io.*;

// 操作字节缓冲流
public class BufferedStreamDemo {

    public static void main(String[] args) {
        try (
                BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/ioDemo/file/txt/test4.txt"));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("src/ioDemo/file/txt/test5.txt"))
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
