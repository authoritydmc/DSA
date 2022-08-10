package JAVA_DSA_AuthorityDMC;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.*;

public class LockerMain {

    public static void main(String[] args) throws  Exception{


        Runnable runnable=()->{
             {
                 int tq=5;
                System.out.println("Thread Running " + Thread.currentThread().getName());

                for (int i = 0; i < 10; i++)
                    System.out.println(Thread.currentThread().getName() + " i=" + tq*i);
            }

        };
        Callable <String> callable=()->{
            synchronized (Object.class) {
                System.out.println("Thread Running " + Thread.currentThread().getName());

                for (int i = 0; i < 10; i++)
                    System.out.println(Thread.currentThread().getName() + " i=" + i);
            }
return "Thread returns"+Thread.currentThread().getName();
        };

        Thread t=new Thread(()->{
            {
                int tq=5;
                System.out.println("Thread Running " + Thread.currentThread().getName());


                for (int i = 1; i <=10; i++)
                    System.out.println(Thread.currentThread().getName()+" || " + tq+"*"+i+"=" + tq*i);

            }

        },"Thread 1");


        Thread t2=new Thread(()->{
            {
                int tq=7;
                System.out.println("Thread Running " + Thread.currentThread().getName());


                for (int i = 1; i <=10; i++)
                    System.out.println(Thread.currentThread().getName()+" || " + tq+"*"+i+"=" + tq*i);
            }

        },"Thread 2");


        Thread t3=new Thread(()->{
            {
                int tq=3;
                System.out.println("Thread Running " + Thread.currentThread().getName());

                for (int i = 1; i <=10; i++)
                    System.out.println(Thread.currentThread().getName()+" || " + tq+"*"+i+"=" + tq*i);

            }

        },"Thread 3");

        t3.start();
        t.start();
        t2.start();;

//HashSet<Callable<String>> tasks =new HashSet<>();
//
//for (int i=0;i<10;i++)
//{
//    final int t=i;
//
//    tasks.add(()-> {
//Thread.currentThread().setName("Thread "+t);
//        for (int z=0;z<5;z++)
//            System.out.println(Thread.currentThread().getName()+" "+z);
//        Thread.sleep(10000);
//    return "Cool task"+t;
//    });
//}
//        ExecutorService executorService= Executors.newFixedThreadPool(3);
//List<Future<String>> futures=executorService.invokeAll(tasks);
//        for (Future fu:futures
//             ) {
//            System.out.println(  fu.get());
//        }



    }
}
