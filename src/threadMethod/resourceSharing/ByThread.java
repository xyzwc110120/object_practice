package threadMethod.resourceSharing;

public class ByThread {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
    }
}


class MyThread extends Thread {

    // 票数
    private int ticket = 5;

    @Override
    public void run() {
        while (ticket >= 0) {
            synchronized (this) {
                System.out.println("剩余票数" + ticket);
                ticket--;
            }
        }
    }
}

