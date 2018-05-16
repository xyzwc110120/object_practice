package ioDemo.fileStreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

// 文件字节输入流案例
public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {
        // 1：创建源对象
        File source = new File("src/ioDemo/file/txt/test2.txt");
        // 2：创建文件字节输入流对象，并接在源上
        FileInputStream in = new FileInputStream(source);
        // 3：具体的读取操作（读进来）
        /*
            注意：如果没有读取到数据，则返回 -1
            int	read()：
                        读取一个字节，并返回读取的字节（返回字符对应 ASCII 码表中的十进制值）
            int	read(byte[] b)：
                        读取最多 b.length 个字节的数据存储到数组 b 中。返回读取的字节总数，若未读取到数据，则返回 -1
            int	read(byte[] b, int off, int len)：
                        读取 len 个字节存储到数组 b 中，从数组的 off 索引位置开始存储。返回读取的字节总数，若未读取到数据，则返回 -1
        */
        // System.out.println(in.read());

        byte[] bytes = new byte[10];
        System.out.println(Arrays.toString(bytes));
        // in.read(bytes);
        // in.read(bytes, 2, 5);
        StringBuilder builder = new StringBuilder();
        // 记录读取字节数
        int len;
        while ((len = in.read(bytes)) > 0) {
            // 取长度为 len 的数组数据，防止放入数组中的空数据
            builder.append(new String(bytes, 0, len));
        }
        // System.out.println(Arrays.toString(bytes));
        // 将 byte[] 转换为字符串
        // String str = new String(bytes);
        // System.out.println(str);
        System.out.println(builder.toString());
        // 4：关闭资源
        in.close();
    }

}
