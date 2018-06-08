package ioDemo.NIODemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// 使用 Files 进行文件拷贝
public class FilesDemo {

    public static void main(String[] args) throws IOException {
        // Paths：java.nio.file.Path 接口的工具类
        /*

        Files.copy(Paths.get(
                new File("src/ioDemo/file/txt/test4.txt").toURI()),
                new FileOutputStream("src/ioDemo/file/txt/te|st5.txt"));*/
        Files.copy(Paths.get("src/ioDemo/file/txt/test4.txt"), new FileOutputStream("src/ioDemo/file/txt/test6.txt"));
        /*
        拷贝的文件若存在，则会出现异常：
            java.nio.file.FileAlreadyExistsException: src\ioDemo\file\txt\test7.txt
        */
        Files.copy(new FileInputStream("src/ioDemo/file/txt/test4.txt"), Paths.get("src/ioDemo/file/txt/test7.txt"));
    }

}
