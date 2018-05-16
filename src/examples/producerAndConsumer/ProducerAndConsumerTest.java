package examples.producerAndConsumer;

public class ProducerAndConsumerTest {

    public static void main(String[] args) {
        // 创建生产者和消费者共同的资源对象
        ShareResource shareResource = new ShareResource();

        Producer producer = new Producer(shareResource);
        Consumer consumer = new Consumer(shareResource);
        // 启动生产者线程
        new Thread(producer).start();
        // 启动消费者线程
        new Thread(consumer).start();
    }

}
