package netDemo.udpDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

// 接收端
public class Receiver {

    public static void main(String[] args) {
        try (
                // 创建接收端对象
                DatagramSocket receiver = new DatagramSocket(10086)
        ) {
            // 设置一个缓冲数组，用来接收数据
            byte[] buffer = new byte[1024];
            // 创建数据报包对象，用来获取发送端的数据
            // DatagramPacket 类中有两种构造函数，一种用于接收收据，一种用于发送数据
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            /*
            public void receive(DatagramPacket p)：
                从此套接字接收数据报包。当此方法返回时， DatagramPacket 的缓冲区填充了接收的数据。
                数据报包也包含发送方的 IP 地址和发送方机器上的端口号。
                此方法在接收到数据报前一直阻塞。数据报包对象的 length 字段包含所接收信息的长度。如果信息比包的长度长，该信息将被截短。
            */
            receiver.receive(packet);
            // 打印接收到的信息
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
