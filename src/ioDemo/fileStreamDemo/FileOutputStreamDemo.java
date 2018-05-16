package ioDemo.fileStreamDemo;

import java.io.*;

// 文件字节输出流案例（输出流可以创建文件，但是不能创建目录）
public class FileOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        // 1：创建目标对象
        File target = new File("src/ioDemo/file/txt/test1.txt");
        // 2：创建文件字节流对象
        /*
            FileOutputStream(File file)：
                    其实源码中调用的下面的构造器 this(file, false);
            FileOutputStream(File file, boolean append)：
                    file：目标文件对象；
                    append：是否将字节写入文件末尾处（默认为 false，重新写入文件）
        */
        OutputStream out = new FileOutputStream(target, true);
        // 3：具体的输出操作（写出去）
        /*
            void write(int b)：
                        把一个字节写出到文件中去（b 在 ASCII 码表中对应的字符）
            void write(byte[] b)：
                        把数组 b 中所有的字节都写出到文件中去
            void write(byte[] b, int off, int len)：
                        把数组 b 中从索引为 off 开始（包括索引位置）的长度为 len 个字节写出到文件中去
        */
        out.write(65);      // 写出 A
        out.write(10);      // 写出还行健
        out.write("ABCDE".getBytes());
        out.write(10);
        out.write("CatDogFishPig".getBytes(), 3, 3);
        out.write(10);
        // 4：关闭资源对象（一定要关闭资源对象）
        out.close();
    }

}
