package ioDemo.fileStreamDemo;

import java.io.*;

// IO 中如何正确关闭资源和处理异常
public class HandleIOExceptionDemo {

    public static void main(String[] args) {
        traditionMethod();
        autoClose();
    }

    /**
     * 传统模式
     */
    private static void traditionMethod() {
        // 声明资源对象（因为若在 try 代码块中声明，在 finally 代码块中无法调用）
        InputStream in = null;
        OutputStream out = null;
        try {
            // 可能出现异常的代码
            File source = new File("src/ioDemo/file/txt/test2.txt");
            File target = new File("src/ioDemo/file/txt/test3.txt");
            in = new FileInputStream(source);
            out = new FileOutputStream(target);
            byte[] bytes = new byte[10];
            int len;
            while ((len = in.read(bytes)) > 0) {
                out.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭管道（不管是否发生异常，都要关闭资源）
            // 因为关闭资源也会发生异常，所以要放到 try catch 代码块中
            try {
                // 若果资源对象为空，则强行关闭会发生异常
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 两个资源文件对象不要写在一个 try catch 代码块中，因为若上个资源对象关闭发生异常，则后面的资源文件的关闭无法执行
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Java 7 中新特性：自动资源关闭（资源对象要实现 AutoCloseable 接口或 Closeable 接口（Closeable 接口继承与 AutoCloseable 接口））
     */
    private static void autoClose() {
        File source = new File("src/ioDemo/file/txt/test2.txt");
        File target = new File("src/ioDemo/file/txt/test3.txt");
        try (
                // 打开资源的代码（要写在 try 代码块的 () 内）（反编译后可已看到编译器自动使用了资源对象的 close 方法）
                FileInputStream in = new FileInputStream(source);
                FileOutputStream out = new FileOutputStream(target)
        ) {
            // 可能出现异常的代码
            byte[] bytes = new byte[10];
            int len;
            while ((len = in.read(bytes)) > 0) {
                out.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
