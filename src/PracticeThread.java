class EatThread extends Thread {        // 继承Thread类，成为线程类

    @Override
    public void run() {         // 覆盖Thread类中的run()方法，在其中编写需要执行的操作
        for (int i = 0; i < 50; i++) {
            System.out.println("正在吃饭···" + i);
        }
    }
}

public class PracticeThread {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println("在看电视···" + i);
            if (i == 9) {
                EatThread eatThread = new EatThread();      // 创建线程类对象
                // eatThread.run();                            // 不要调用run()方法，因为并没有启动线程，只是执行了run()方法
                eatThread.start();                          // 调用线程类中的start()方法启动线程，底层会去调用run()方法
            }
        }
    }
}
