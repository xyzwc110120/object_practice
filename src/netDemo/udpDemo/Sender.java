package netDemo.udpDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// 发送端
public class Sender {

    public static void main(String[] args) {
        String msg = "我是一个小小的数据报包哟~";

        try (
                // 创建发送端对象
                DatagramSocket sender = new DatagramSocket(10010)
        ) {
            // 将要发送的数据包装至数据报包对象中
            // DatagramPacket 类中有两种构造函数，一种用于接收收据，一种用于发送数据
            DatagramPacket packet = new DatagramPacket(
                    msg.getBytes(),             // 需要发送的数据
                    msg.getBytes().length,      // 数据长度（这里用的是字节长度，不能使用 msg.length() ，因为那是字符长度）
                    InetAddress.getLocalHost(), // 目的主机地址
                    10086                 // 目的主机端口号
            );
            // 从此套接字发送数据报包。DatagramPacket 包含的信息指示：将要发送的数据、其长度、远程主机的 IP 地址和远程主机的端口号。
            sender.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
