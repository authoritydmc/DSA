class Solution {
    
    private boolean check(int [] ori,int [] arr)
    {
        for(int i=0;i<26;i++)
        {
            if(ori[i]!=arr[i])
                return false;
        }
        
        return true;
        
    }
    public boolean checkInclusion(String s1, String s2) {
        
//         basic checks
        
                if(s1.length()==0)
            return true;
        
        if(s1.length()>s2.length())
            return false;
        
        int [] oriarr=new int [26];
        int [] arr=new int [26];

        for(int i=0;i<s1.length();i++)
        {
            
            int index=s1.charAt(i)-'a';
            oriarr[index]+=1;
            
        }
        
//         window length is size of s1.length()
        
        int k=s1.length();
        
        for(int i=0;i<k;i++)
        {
                 int index=s2.charAt(i)-'a';
            arr[index]+=1;
        }
//         compare once
        
        if(check(oriarr,arr))
            return true;
        
//         now insert other
        
        int lastIndex=0;
        for(int i=k;i<s2.length();i++)
        {
            
            int last=s2.charAt(lastIndex)-'a';
            int front=s2.charAt(i)-'a';
            arr[last]-=1;
            
            arr[front]+=1;
                   if(check(oriarr,arr))
            return true; 
            
            
            lastIndex++;
            
        }
        return false;
    }
}

// class Solution {
    
//     private boolean check(HashMap<Character,Integer> ori,HashMap<Character,Integer> map)
//     {
//                 System.out.println("Checking for permutation");
//                 System.out.println(ori);
//                         System.out.println(map);


//                 System.out.println("End checkign");

        
//         if(ori.size()!=map.size())
//         return false;
      
//         for(Map.Entry<Character,Integer> me:ori.entrySet())
//         {
//                         if(!map.containsKey(me.getKey()))
//                             return false;
//                         else
//                         {
//                             if(map.get(me.getKey())!=me.getValue())
//                                 return false;
//                         }
                        
//         }
        
//         return true;
        
//     }
//     public boolean checkInclusion(String s1, String s2) {
        
        
// //         basic checks 
        
//         if(s1.length()==0)
//             return true;
        
//         if(s1.length()>s2.length())
//             return false;
        
//         System.out.println("Now running the code");
//         HashMap<Character,Integer> orimap=new HashMap<>();
//         HashMap<Character,Integer> map=new HashMap<>();
        
//         for(int i=0;i<s1.length();i++)
//         {
//             orimap.put(s1.charAt(i),orimap.getOrDefault(s1.charAt(i),0)+1);
//         }
        
// //         here k is 2 we have to check for each 2 characters stored...
        
//         //using sliding window
        
        
//         for(int i=0;i<s1.length();i++)
//         {
            
//             map.put(s2.charAt(i),map.getOrDefault(s2.charAt(i),0)+1);
           
//         }
        
// //         compare once



//         if(check(orimap,map))
//             return true;
        
// //         now increase one character and remove one character
// //         endpointer for remove last character
//               int endPointer=0;
//         for(int i=s1.length();i<s2.length();i++)
//         {
            
//             char front=s2.charAt(i);
//             char end=s2.charAt(endPointer++);

// //             remove endindex key
//             if(map.get(end)==1)
//                     map.remove(end);
//             else
//                     map.put(end,map.get(end)-1);
            
            
//             map.put(front,map.getOrDefault(front,0)+1);
            
// //             now compare
//             if(check(orimap,map))
//             return true;
            
//         }
//         return false;
        
//     }
// }