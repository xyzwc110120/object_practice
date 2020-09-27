package examples.producerAndConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 共享资源对象（姓名，性别）
public class ShareResource {

    private String name;
    private String sex;
    private boolean isEmpty = true;

    // 实例化一个重入锁
    private final Lock reentrantLock = new ReentrantLock();
    /**
     * Condition 将 Object 监视器方法（wait、notify 和 notifyAll）分解成截然不同的对象，以便通过将这些对象与任意 Lock 实现组合使用，
     * 为每个对象提供多个等待 set （wait-set）。其中，Lock 替代了 synchronized 方法和语句的使用，Condition 替代了 Object 监视器方法的使用。
     * 在Condition中，用await()替换wait()，用signal()替换notify()，用signalAll()替换notifyAll()，传统线程的通信方式，
     * Condition都可以实现，这里注意，Condition是被绑定到Lock上的，要创建一个Lock的Condition必须用newCondition()方法。
     */
    private Condition condition = reentrantLock.newCondition();

    /**
     * 生产者向共享资源对象中存储数据
     *
     * @param name 姓名
     * @param sex 性别
     */
    public void push(String name, String sex) {
        // 获取锁（不是同步锁，与synchronized不同）
        reentrantLock.lock();
        try {
            // 这里使用while而不使用if是因为更安全，如果为true这进入循环，线程进入等待池，被唤醒后将再次判断
            while (!isEmpty) {      // 当前isEmpty为false的时候，意味着不为空，则等着消费者来取
                // 使用同步锁对象来调用，表示当前线程释放同步锁，进入等待池，只能被其他线程所唤醒
                condition.await();       //this.wait();
            }

            // --------生产开始------------
            this.name = name;
            // 为了使问题明显，在赋值姓名后将线程睡眠10毫秒
            Thread.sleep(10);
            this.sex = sex;
            // --------生产结束------------

            // 改变共享资源状态
            isEmpty = false;
            // 唤醒一个消费者线程()
            condition.signal();      // this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            reentrantLock.unlock();
        }

        // System.out.println(this.name + "-" + this.sex);
    }

    /**
     * 消费者从共享资源对象中取出数据
     */
    public void popup() {
        reentrantLock.lock();
        try {
            while (isEmpty) {       // 当前isEmpty为true的时候，意味着为空，则等着生产者生产
                condition.await();
            }

            // --------消费开始------------
            Thread.sleep(10);
            System.out.println(name + "-" + sex);
            // --------消费结束------------

            isEmpty = true;
            condition.signal();      // 唤醒一个生产者线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

}
