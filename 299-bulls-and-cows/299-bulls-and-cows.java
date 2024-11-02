class Solution {
    public String getHint(String secret, String guess) {
//         Logic :
// 
//         For BULLS :  just count bulls and do not store in HashMap as they are pretty simple to match i.e if character match at a index
        
//         for COWS: 
// two hashmaps for cows calulation : 1 for secret and 1 for guess .
//         step 2: Store each character frequency which are not bulls .
//         step 3 : to find cow pairs just see which hashMap has less frequency for common characters 
        
        int bull=0;
        int cow=0;
        HashMap<Character,Integer> smap=new HashMap<>();
      HashMap<Character,Integer> gmap=new HashMap<>();

        
        for(int i=0;i<secret.length();i++)
        {
//         if both char match
            if(secret.charAt(i)==guess.charAt(i))
                bull++;
            
            else
            {
                smap.put(secret.charAt(i),smap.getOrDefault(secret.charAt(i),0)+1);
                gmap.put(guess.charAt(i),gmap.getOrDefault(guess.charAt(i),0)+1);     
            }
            
            
        }
        
        for(Map.Entry<Character,Integer> me:smap.entrySet())
        {
           
            if(gmap.containsKey(me.getKey()))
            {
               cow+=Math.min(me.getValue(),gmap.get(me.getKey())); 
            }
            
            
            
        }
        
        
        return bull+"A"+cow+"B";
        
    }
}