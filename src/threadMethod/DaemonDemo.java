package threadMethod;

class DaemonThread extends Thread {
    @Override
    public void run() {
        // 前台线程结束后，后台线程自动结束
        for (int i = 0; i < 200; i ++) {
            System.out.println("daemonThread : " + i + "-" + super.isDaemon());
        }
    }
}

public class DaemonDemo {

    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread();       // 创建线程对象

        for (int i = 0; i< 50; i ++) {
            System.out.println("main : " + i);
            if (i == 10) {
                daemonThread.setDaemon(true);       // 设置线程为后台线程，必须在 start() 方法调用前设置
                daemonThread.start();       // 启动线程
            }
        }
    }

}
