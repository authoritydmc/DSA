package DSA.Locks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Document<str> {
    private static Document _doc;
    private ReentrantLock lock=new ReentrantLock();
  public   static Document getDocument()
    {
        if (_doc==null)
            _doc=new Document();
        return _doc;
    }
    private Document()
    {
        //

    }

     private volatile ArrayList<String>  str=new ArrayList<>();

  public void addString(String s)
  {
      System.out.println("Attempting to write Value by "+Thread.currentThread().getName());
      synchronized (this)
      {
          str.add(s);

      }
  }

  public String getString()
  {
      System.out.println("Attempting to read Value by "+Thread.currentThread().getName());
      lock.lock();
if (getSize()==0)
    return "-NAN";


//   critical section


      {


          String rs= str.stream().reduce((x, res)->x+","+res).get();
          str.clear();
    lock.unlock();
    return rs;
      }



  }


    public boolean readable() {
return  true;
    }
    public int getSize()
    {
        return str.size();
    }
}
