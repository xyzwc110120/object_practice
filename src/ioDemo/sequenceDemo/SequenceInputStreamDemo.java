package ioDemo.sequenceDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

// 合并流/顺序流
public class SequenceInputStreamDemo {

    public static void main(String[] args) {
        try (
                SequenceInputStream in = new SequenceInputStream(
                        new FileInputStream("src/ioDemo/file/txt/test3.txt"),
                        new FileInputStream("src/ioDemo/file/txt/test4.txt"))
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                System.out.print(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
