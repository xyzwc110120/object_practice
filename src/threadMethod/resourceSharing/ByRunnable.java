package threadMethod.resourceSharing;

public class ByRunnable {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
    }
}


class MyRunnable implements Runnable {

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
