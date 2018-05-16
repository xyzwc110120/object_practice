package ioDemo.fileStreamDemo;

import java.io.*;

// 拷贝指定目录的指定类型文件到指定目录
public class FileStreamCopyDemo2 {

    public static void main(String[] args) {
        // 1：找到源目录文件中的所有 .txt 文件
        File sourceDir = new File("src/ioDemo/file/txt");
        File target = new File("src/ioDemo/file/test");
        // Java 8的一个大亮点是引入 Lambda 表达式，使用它设计的代码会更加简洁。当开发者在编写 Lambda 表达式时，也会随之被编译成一个函数式接口。
        // 下面这个例子就是使用 Lambda 语法来代替匿名的内部类，代码不仅简洁，而且还可读。
        /*File[] files = sourceDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.endsWith(".txt");
            }
        });*/
        File[] files = sourceDir.listFiles((dir, name) -> new File(dir, name).isFile() && name.endsWith(".txt"));

        // 2：迭代出每一个文件对象，并拷贝
        if (files != null) {
            for (File source : files) {
                try (
                        // 自动关闭资源
                        InputStream in = new FileInputStream(source);
                        OutputStream out = new FileOutputStream(new File(target, source.getName()))
                ) {
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = in.read(bytes)) > 0) {
                        out.write(bytes, 0, len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
