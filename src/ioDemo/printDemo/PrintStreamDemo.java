package ioDemo.printDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

// 字节打印流
public class PrintStreamDemo {

    public static void main(String[] args) throws FileNotFoundException {
        /*
        PrintStream(OutputStream out)：源码中调用的 PrintStream(out, false) 构造器;
        PrintStream(OutputStream out, boolean autoFlush)：
                autoFlush：是否开启自动刷新，如果为 true，
                           则每当写入 byte 数组、调用其中一个 println 方法或写入换行符或字节（'\n'）时都会刷新输出缓冲区
        */
        PrintStream print = new PrintStream(new FileOutputStream(new File("src/ioDemo/file/txt/test1.txt")));
        print.print(18);
        print.print("啦啦啦");
        print.print(true);
        // 测试表明，就算未开启自动刷新，也未调用 println 方法，字节打印流还是会自动刷新
        // print.close();
    }

}
