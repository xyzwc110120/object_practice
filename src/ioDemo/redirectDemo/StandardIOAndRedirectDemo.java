package ioDemo.redirectDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

// 标准的 IO 及 标准的 IO 的重定向操作
public class StandardIOAndRedirectDemo {

    public static void main(String[] args) throws IOException {
        // 标准的输入
        // int data = System.in.read();        // A
        // 标准的输出
        // System.out.println(data);           // 65

        // 重定向流必须在调用流之前
        // 重定向输入
        System.setIn(new FileInputStream("src/ioDemo/file/txt/test2.txt"));
        // 重定向输出
        System.setOut(new PrintStream("src/ioDemo/file/txt/test1.txt"));
        System.out.println("重定向输出，不会在控制台显示了");
        byte[] buffer = new byte[10];
        int len;
        while ((len = System.in.read(buffer)) > 0) {
            System.out.print(new String(buffer, 0, len));
        }
    }

}
