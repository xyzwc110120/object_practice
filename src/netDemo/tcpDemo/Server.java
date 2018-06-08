package netDemo.tcpDemo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

// 服务端
public class Server {

    public static void main(String[] args) {
        try (
                // 创建服务端对象，指定端口 10086
                ServerSocket server = new ServerSocket(10086);
        ) {
            System.out.println("服务端准备就绪······");

            while (true) {
                // 接收连接该服务端的客户端对象
                // （因为服务端不会因为一次接收后就结束停止，所以写个死循环让服务端可以一直接收）
                Socket client = server.accept();
                System.out.println("链接过来的客户端地址：" + client.getInetAddress());
                try (
                    // 获取该客户端的输出流对象，给该客户端输出数据（用打印流包装）
                    PrintStream out = new PrintStream(client.getOutputStream())
                ) {
                    out.print("客户端客户端在么？");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
