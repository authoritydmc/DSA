package JAVA_DSA_AuthorityDMC;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;


public class Bucket {

    private final Queue<Integer> bucket=new ArrayDeque<>();
    FileOutputStream fileOutputStream;

    {
        try {
            fileOutputStream = new FileOutputStream("BucketsCalls.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public  void addItem(Integer item)
        {

            synchronized (this)
            {
                if (bucket.size()>=5) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                bucket.add(item);
                System.out.println("Produced "+item+ " via "+Thread.currentThread().getName());
                try {
                    fileOutputStream.write(("Produced "+item+ " via "+Thread.currentThread().getName()+"\n").getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                notifyAll();
            }

        }



    public  int consumeItem()
    {

        synchronized (this)
        {

            if (bucket.size()==0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                int item = bucket.poll();

                System.out.println("Consumed " + item + " via " + Thread.currentThread().getName());
                fileOutputStream.write(("Consumed " + item + " via " + Thread.currentThread().getName()+"\n").getBytes());
                notifyAll();
                return item;
            }
            catch (NullPointerException e)
            {
                return  -1;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
return  -2;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        fileOutputStream.close();
    }
}
