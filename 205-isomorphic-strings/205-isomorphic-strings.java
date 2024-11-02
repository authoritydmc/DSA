class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        
        char [] sc=s.toCharArray();
        char [] tc=t.toCharArray();
        HashMap<Character,Character> m=new HashMap<>();
        HashMap<Character,Character> m1=new HashMap<>();
        
        if(s.length()!=t.length())
            return false;
        
        for(int i=0;i<sc.length;i++)
        {

            
            if(!m.containsKey(sc[i]))
            {
                m.put(sc[i],tc[i]);
            
//                 now store the target to source too but check
                
                if(m1.containsKey(tc[i]))
                {
                    if(m1.get(tc[i])!=sc[i])
                        return false;
                }
                
                 m1.put(tc[i],sc[i]);

            }else
            {
                if(tc[i]!=m.get(sc[i]))
                    return false;
                
            }
            
    
            
            
        }
        
            return true;

    }
}