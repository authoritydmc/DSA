package com.company;

import java.util.*;

public class Myclass {
public String rev(String wrd)
{

//    char [] abc=wrd.toCharArray();
//
//    int i=0;
//    int j=wrd.length()-1;
//
//    while(i<j)
//    {
//        char t=abc[i];
//        abc[i]=abc[j];
//        abc[j]=t;
//        i++;j--;
//    }
//    return String.valueOf(abc);

  return "";
}

public void isPal(String wrd)
{



//    int i=0;
//
//    int j=wrd.length()-1;
//
//    char [] abc=wrd.toCharArray();
//    while (i<j)
//    {
//        if (abc[i++]!=abc[j--])
//        {
//            System.out.println("Not a palindrome");
//            return;
//        }
//    }
//    System.out.println("Ispalindrom");
//    return;
}

private void ems(HashMap<String,Integer> map)
{
    map.put("12312555",53);
    map=null;
}
    public static void main(String[] args) {

    Myclass ms=new Myclass();
    String r=ms.rev("12345");
        System.out.println(r);
ms.isPal("121");

HashMap<String,Integer> m123=new HashMap<>();
        m123.put("Keww",12);
        System.out.println(m123.size());
        ms.ems(m123);
        m123.put("213",12);
        System.out.println(m123.size());
    }
}
