package JAVA_DSA_AuthorityDMC;

public class prodConMain {


    public static void main(String[] args) {
        Bucket bucket=new Bucket();
        Producer producer=new Producer(bucket);

        Consumer consumer=new Consumer(bucket);


        Thread prodThread=new Thread(producer,"PRODUCER-1 THREAD");

        Thread prodThread2=new Thread(producer,"PRODUCER-2 THREAD");
        Thread consThread=new Thread(consumer,"CONSUMER-1 THREAD");
        Thread consThread2=new Thread(consumer,"CONSUMER-2 THREAD");


        prodThread.start();
        prodThread2.start();

        consThread.start();consThread2.start();

    }
}
