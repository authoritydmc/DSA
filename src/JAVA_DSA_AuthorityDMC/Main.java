package JAVA_DSA_AuthorityDMC;

import java.util.*;

public class Main {
static
{
    System.out.println("Cool static");
}
    {
        System.out.println("cool instance");


    }

    Main(){
        System.out.println("Cool constructor");
    }
    public static void main(String[] args) {

    Main m4=new Main();
    Main m2=new Main();
	// write your code here
String  r="nweRwafR";
r.equals(1);


ArrayList<Object> a=new ArrayList<>();
a.add(2);
a.add("raj");

a.add(false);

        System.out.println(a);
        System.out.println(Integer.valueOf(129).hashCode());
String qwe=new String("Qew");

        System.out.println(Integer.valueOf(127)==Integer.valueOf(127));

                ArrayList arrayList=new ArrayList(20);
        System.out.println(arrayList);
        HashMap<Character,Integer> m=new HashMap<>();


        for (int i=0;i<r.length();i++)
        {
            m.put(r.charAt(i),m.getOrDefault(r.charAt(i),0)+1);
        }

        for (Character character:m.keySet())
        {
            System.out.println(m.get(character));
        }




        HashMap<Integer,String> md2=new HashMap<>();
        md2.put(2,"JAva");
        md2.put(0,"Springboot");

        md2.put(null,"demo");
        md2.put(1,"Springboot");
        System.out.println("Hashmap ---");
        System.out.println(md2.size());

        for (Map.Entry<Integer,String> me: md2.entrySet())
            System.out.println(me.getKey()+" "+me.getValue());
    }
}
