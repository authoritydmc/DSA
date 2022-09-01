package DSA.Locks;

public class Writer implements Runnable {
    private Document document;


    public Writer(Document document) {
        this.document = document;


    }


    @Override
    public void run() {
        for (int i=0;i<1000;i++)
        {
            document.addString("Writing "+i+1+" for "+Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
