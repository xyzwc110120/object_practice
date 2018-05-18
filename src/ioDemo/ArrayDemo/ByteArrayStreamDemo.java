package ioDemo.ArrayDemo;

import java.io.*;

// 字节数组/内存流
public class ByteArrayStreamDemo {

    public static void main(String[] args) {
        try {
            /*
            字节数组输出流：程序 ---> 内存（数组）：
                此类实现了一个输出流，其中的数据被写入一个 byte 数组（也就是内存中）。缓冲区会随着数据的不断写入而自动增长。
                可使用 toByteArray() 和 toString() 获取数据。
                关闭 ByteArrayOutputStream 无效（因为数据是存储在流对象的数组（也就是内存中），流对象被垃圾回收器回收后就没了）。
                此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。

            ByteArrayOutputStream()：创建一个新的 byte 数组输出流（默认 32 字节）。
            ByteArrayOutputStream(int size)：创建一个新的 byte 数组输出流，它具有指定大小的缓冲区容量（以字节为单位）。
            */
            ByteArrayOutputStream out = new ByteArrayOutputStream(64);
            out.write("ABCDEFGHI".getBytes());
            // byte[] toByteArray()：创建一个新分配的 byte 数组（其实源码中是复制一个与原数组一样的副本）
            byte[] buffer = out.toByteArray();

            /*
            字节数组输入流：内存（数组） ---> 程序：
                ByteArrayInputStream 包含一个内部缓冲区，该缓冲区包含从流中读取的字节。
                关闭 ByteArrayInputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。

            ByteArrayInputStream(byte[] buf)：创建一个 ByteArrayInputStream，使用 buf 作为其缓冲区数组。
            ByteArrayInputStream(byte[] buf, int offset, int length)：
                    buf - 输入缓冲区。
                    offset - 缓冲区中要读取的第一个字节的偏移量。
                    length - 从缓冲区中读取的最大字节数。
            */
            InputStream in = new ByteArrayInputStream(buffer);
            byte[] bytes = new byte[5];
            int len;
            while ((len = in.read(bytes)) > 0) {
                System.out.print(new String(bytes, 0, len));
            }
            System.out.println();

            // 虽然关闭无效，但是养成习惯，关闭资源
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
