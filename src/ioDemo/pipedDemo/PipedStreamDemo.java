package ioDemo.pipedDemo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

// A线程（继承方式）给另一个线程发送数据
class AThread extends Thread {

    private PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getOut() {
        return out;
    }

    @Override
    public void run() {
        try {
            // 写出 A - Z
            for (int i = 65; i < 65 + 26; i++) {
                out.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// B线程从另一个线程获取数据
class BThread extends Thread {

    private PipedInputStream in;

    // 创建 PipedInputStream，使其连接到管道输出流 out
    public BThread(PipedOutputStream out) {
        try {
            in = new PipedInputStream(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        int len;
        try {
            while ((len = in.read()) > -1) {
                System.out.print((char) len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// 管道流示例（实现两个线程之间的数据交互）：
public class PipedStreamDemo {

    public static void main(String[] args) {
        AThread aThread = new AThread();
        BThread bThread = new BThread(aThread.getOut());
        aThread.start();
        bThread.start();
    }

}
