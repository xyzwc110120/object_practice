package netDemo.tcpDemo;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 客户端
public class Client {

    public static void main(String[] args) {
        try (
                // 创建客户端对象，并指明连接服务端的主机和端口
                Socket client = new Socket("127.0.0.1", 10086);
                // 获取客户端的输入流对象
                Scanner in = new Scanner(client.getInputStream())
        ) {
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
