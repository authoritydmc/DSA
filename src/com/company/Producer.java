package com.company;

import java.util.Random;

public class Producer implements  Runnable{
    private Bucket bucket=null;

    public Producer(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void run() {

        while (true)
        {
            int rand= new Random().nextInt(0,1000);
            bucket.addItem(rand);
//            try {
////                Thread.sleep(5000);
//                System.out.println("produced na");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
}
