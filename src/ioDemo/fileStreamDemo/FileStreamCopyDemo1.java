package ioDemo.fileStreamDemo;

import java.io.*;

// 使用文件字节流完成拷贝
public class FileStreamCopyDemo1 {

    public static void main(String[] args) throws IOException {
        // 1：创建源对象和目标对象
        File source = new File("src/ioDemo/file/txt/test2.txt");
        File target = new File("src/ioDemo/file/txt/test3.txt");
        // 2：创建输入/输出管道（输入流对象和输出流对象）
        InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(target);
        // 3：读取/写出操作（read/write）
        byte[] bytes = new byte[10];
        int len;
        while ((len = in.read(bytes)) > 0) {
            // 将读取到 bytes 数组中的数据写出
            out.write(bytes, 0, len);
        }
        // 关闭管道
        in.close();
        out.close();
    }

}
