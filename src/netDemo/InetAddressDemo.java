package netDemo;

import java.io.IOException;
import java.net.InetAddress;

// IP操作
public class InetAddressDemo {

    public static void main(String[] args) throws IOException {

        // public static InetAddress getByName(String host) throws UnknownHostException：
        // 在给定主机名的情况下确定主机的 IP 地址（也可以使用域名）
        // InetAddress ip = InetAddress.getByName("DESKTOP-PAB2J02");
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        System.out.println(ip);
        // 返回本地主机
        System.out.println(InetAddress.getLocalHost());
        /*
        public boolean isReachable(int timeout) throws IOException：
                测试是否可以达到该地址。实现尽最大努力试图到达主机。
                超时值（以毫秒为单位）指示尝试应该使用的最大时间量。如果在获取应答前操作超时了，则视为主机不可到达。
                负值将导致抛出 IllegalArgumentException
        */
        System.out.println(InetAddress.getLocalHost().isReachable(1000));
    }

}
