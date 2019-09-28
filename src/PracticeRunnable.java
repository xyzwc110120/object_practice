class EatRunnableImpl implements Runnable {

    // 实现 Runnable 接口中的 run() 方法，在其中编写需要执行的操作
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("正在吃饭···" + i);
        }
    }
}


public class PracticeRunnable {

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println("在看电视···" + i);
            if (i == 9) {
                // 使用 Runnable 定义的子类中没有 start() 方法，只有 Thread 类中才有
                /*
                    观察Thread类，有一个构造方法：
                        public Thread(Runnable target);
                        此构造方法接受 Runnable 的子类实例，也就是说可以通过 Thread 类来启动 Runnable 实现的多线程
                */
                // Thread 类也实现了 Runnable 接口
                Thread thread = new Thread(new EatRunnableImpl());
                thread.start();
            }
        }
    }
}
