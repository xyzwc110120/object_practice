package ioDemo.scannerDemo;

import java.util.Scanner;

// 扫描器类
public class ScannerDemo {

    public static void main(String[] args) {
        try (
                // 扫面文件中的数据
                // Scanner scanner = new Scanner(new File("src/ioDemo/file/txt/test4.txt"))
                // 扫描键盘输入的数据
                // Scanner scanner = new Scanner(System.in)
                // 扫描字符串中的数据
                Scanner scanner = new Scanner("大大大大大大大大，大哥别杀我")
        ) {
            while (scanner.hasNextLine()) {
                System.out.println("ECHO：" + scanner.nextLine());
            }
        }
    }

}
