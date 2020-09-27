package threadMethod;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

    public static void main(String[] args) {
        System.out.println("begin...");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello~");
            }
        }, 3000, 2000);
        System.out.println("end...");
    }
}
