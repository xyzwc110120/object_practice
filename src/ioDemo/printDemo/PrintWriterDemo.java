package ioDemo.printDemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// 字符打印流
public class PrintWriterDemo {

    public static void main(String[] args) throws IOException {
        /*
        如果启用了自动刷新，则只有在调用 println、printf 或 format 的其中一个方法时才可能完成此操作
        */
        PrintWriter print = new PrintWriter(new FileWriter(new File("src/ioDemo/file/txt/test1.txt")), true);
        print.print(18);
        print.print("哦呀呀呀");
        print.print(false);
        // 若未执行 println、printf 或 format 中的任意一个方法，则无法自动刷新
        // print.println("换行");
        // print.close();       // 关闭资源会刷新缓存
    }

}
