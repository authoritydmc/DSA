package DSA;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class temp_res {
    private   Node root;

    public temp_res(int root) {
        System.out.println(this.root);
        this.root = new Node(2);
    }

    public static void main(String[] args) {



    var s="waterbottle";
    var t="erbottlewat";
    StringBuilder ans=new StringBuilder();
    int index=0;
    for (int i=t.length()-1;i>=0;i--)
    {


//            insert at front
            ans.insert(index,t.charAt(i));

    if (t.charAt(i)==s.charAt(0))
        index=s.length()-i;


    }
        System.out.println(ans.toString());
    if (s.equals(ans.toString()))
        System.out.println("Yes");
    else
        System.out.println("No");



    }
}
