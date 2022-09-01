package DSA.Locks;

import javax.print.Doc;

public class Reader implements Runnable{
    private Document document;

    public Reader(Document document) {
        this.document=document;
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String res=document.getString();
            if (!res.equals("-NAN"))
                System.out.println(res+" read complete");

        }

    }
}
