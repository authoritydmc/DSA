class Solution {
    public String getHint(String secret, String guess) {
        
        
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