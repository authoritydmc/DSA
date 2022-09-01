package DSA.Locks;

public class MainLocker {
    public static void main(String[] args) {

        Document document=Document.getDocument();
        Reader reader=new Reader(document);
        Writer writer=new Writer(document);



        Thread rThread=new Thread(reader,"Reader1");
        Thread wThread=new Thread(writer,"Writer1");
        Thread wThread2=new Thread(writer,"Writer2");
        Thread wThread3=new Thread(writer,"Writer3");
        Thread wThread4=new Thread(writer,"Writer4");
        rThread.start();
        Thread rThread2=new Thread(reader,"Reader2");

        wThread.start();
        wThread2.start();    wThread3.start();    wThread4.start();
        rThread2.start();
    }
}
