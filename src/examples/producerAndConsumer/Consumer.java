package examples.producerAndConsumer;

public class Consumer implements Runnable {

    private ShareResource shareResource;

    public Consumer(ShareResource shareResource) {
        this.shareResource = shareResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            shareResource.popup();
        }
    }
}
