package examples.producerAndConsumer;

// 生产者（使用多线程-实现方式）
public class Producer implements Runnable {

    // 因为生产者对象与消费者对象使用的是共同的共享资源对象，所以不可以直接new一个共享资源对象，否者两者就不是使用的同一个共享资源对象
    // private ShareResource shareResource = new ShareResource();
    private ShareResource shareResource;

    // 因为要与消费者对象使用共同的共享资源对象，所以创造一个构造器来传入共享资源对象
    public Producer(ShareResource shareResource) {
        this.shareResource = shareResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            if (i % 2 == 0) {
                shareResource.push(i + "：狗蛋", "男");
            } else {
                shareResource.push(i + "：春燕", "女");
            }
        }

    }
}
