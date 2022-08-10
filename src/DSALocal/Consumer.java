package DSA;

public class Consumer implements Runnable{

    private Bucket bucket=null;

    public Consumer(Bucket bucket) {
        this.bucket = bucket;
    }
    @Override
    public  void run() {
        while (true)
        {
            int item=bucket.consumeItem();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
