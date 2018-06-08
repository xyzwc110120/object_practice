package netDemo.tcpDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

// 超级简单模拟 Tomcat（使用 Edge 浏览器可以访问，Chrome 浏览器不行）
public class TomcatMock {

    public static void main(String[] args) throws IOException {
        // 通过配置文件获得端口号
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/netDemo/tcpDemo/server.properties"));
        int port = Integer.parseInt(properties.getProperty("port"));

        try (
                ServerSocket server = new ServerSocket(port)
        ) {
            while (true) {
                try (
                        // 获取接收到的客户端对象
                        Socket client = server.accept();
                        // 创建打印流对象包装客户端对象的输出流，向客户端输出数据
                        PrintStream out = new PrintStream(client.getOutputStream());
                        // 扫描器对象包装输入流，获取文件数据
                        Scanner in = new Scanner(new FileInputStream("src/netDemo/tcpDemo/hello.html"))
                ) {
                    while (in.hasNextLine()) {
                        out.print(in.nextLine());
                    }
                }
            }
        }
    }

}
