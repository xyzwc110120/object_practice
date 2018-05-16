package threadMethod;

class PriorityThread extends Thread {

    // 调用父类构造方法，为线程设置名称
    PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 获取线程名称
            System.out.println(super.getName() + "-" + i);
        }
    }
}

public class PriorityDemo {

    public static void main(String[] args) {
        PriorityThread min1 = new PriorityThread("IN1-低优先级线程1");
        // 为线程设计优先级
        min1.setPriority(Thread.MIN_PRIORITY);
        PriorityThread min2 = new PriorityThread("IN2-低优先级线程2");
        min2.setPriority(3);
        PriorityThread max1 = new PriorityThread("AX1-高优先级线程1");
        max1.setPriority(Thread.MAX_PRIORITY);
        PriorityThread max2 = new PriorityThread("AX2-高优先级线程2");
        max2.setPriority(9);

        min1.start();
        min2.start();
        max1.start();
        max2.start();

        /*
         结果和电脑核数有关，如果电脑是多核，则可以多线程并行，显示的结果也就不明显，
         除非创建超出电脑核数的线程来测试
        */
    }

}
