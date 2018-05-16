package threadMethod;

class YieldThread extends Thread {

    YieldThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            // 获取线程名称
            System.out.println(super.getName() + "-" + i);
            if ((i % 7) == 0) {
                Thread.yield();
            }
        }
    }
}

public class YieldDemo {

    public static void main(String[] args) {
        YieldThread min = new YieldThread("低优先级线程");
        min.setPriority(Thread.MIN_PRIORITY);
        YieldThread norm = new YieldThread("默认优先级线程");
        norm.setPriority(Thread.NORM_PRIORITY);
        YieldThread max = new YieldThread("高优先级线程");
        max.setPriority(Thread.MAX_PRIORITY);

        min.start();
        norm.start();
        max.start();

        /*
        * 因为电脑核数原因，线程并行而不是并发，所以显示不明显
        * */
    }

}
