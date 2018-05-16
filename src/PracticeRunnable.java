class EatRunnableImpl implements Runnable {

    @Override
    public void run() {         // 实现Runnable接口中的run()方法，在其中编写需要执行的操作
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
                // 使用Runnable定义的子类中没有start()方法，只有Thread类中才有
                // 观察Thread类，有一个构造方法：public Thread(Runnable targer)此构造方法接受Runnable的子类实例，也就是说可以通过Thread类来启动Runnable实现的多线程
                // Thread类也实现了Runnable接口
                Thread thread = new Thread(new EatRunnableImpl());
                thread.start();
            }
        }
    }

}
