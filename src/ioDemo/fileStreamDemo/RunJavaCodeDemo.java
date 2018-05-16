package ioDemo.fileStreamDemo;

import java.io.*;

// 编译和运行 Java 代码
// （不要再编译器内运行，因为 javac 和 java 进程找不到文件路径，将代码复制到外部文件夹内然后使用 cmd 运行，eg：G:/javaFiles）
public class RunJavaCodeDemo {

    public static void main(String[] args) throws IOException {
        String str = "System.out.println(\"Hello World!\");";
        eval(str);
    }

    // 编译和运行 Java 代码字符串 str
    private static void eval(String str) throws IOException {
        // 1：使用 StringBuilder 拼接一个完整的 HalloWorld 程序
        StringBuilder sb = new StringBuilder();
        sb.append("public class Hello{");
        sb.append("public static void main(String[] args){");
        sb.append(str);
        sb.append("}");
        sb.append("}");

        // 2：保存到 Hello.java 文件中
        try (
                OutputStream out = new FileOutputStream("Hello.java")
        ) {
            out.write(sb.toString().getBytes());
        }

        // 3：调用 javac 进程来编译 Hello.java
        Process javacProcess = Runtime.getRuntime().exec("javac Hello.java");
        byte[] bytes = new byte[1024];
        int len;
        // 4：读取 javac 进程中的错误流信息
        try (
                InputStream error = javacProcess.getErrorStream()
        ) {
            // 读取流中的数据
            while ((len = error.read(bytes)) > 0) {
                System.out.println(new String(bytes, 0, len));
            }
        }

        // 5：调用 java 进程来运行 java.class
        Process javaProcess = Runtime.getRuntime().exec("java Hello");
        // 6：读取 java 进程中的流信息
        try (
                InputStream info = javaProcess.getInputStream()
        ) {
            // 读取流中的数据
            while ((len = info.read(bytes)) > 0) {
                System.out.println(new String(bytes, 0, len));
            }
        }

        // 7：删除 .java 和 .class 文件
        new File("Hello.java").delete();
        new File("Hello.class").delete();
    }
}