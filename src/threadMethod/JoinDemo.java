package threadMethod;

class JoinTread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("join : " + i);
        }
    }
}

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建 join 线程对象
        Thread join = new Thread(new JoinTread());

        for (int i = 0; i < 100; i++) {
            System.out.println("main : " + i);
            if (i == 10) {
                join.start();       // 启动 join 线程
            }
            if (i == 30) {
                join.join();        // 强制运行 join 线程，当 join 线程全部运行结束后再运行主线程
            }
        }
    }
}
