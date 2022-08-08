class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int ans=0;
        
        for(char c:s.toCharArray())
        {
            
            map.put(c,map.getOrDefault(c,0)+1);
            
            
        }
                System.out.println("Before:"+map);

        if(map.size()==1)
            return map.get(s.charAt(0));
        boolean flag=false;
        int val=-1;
        for(Map.Entry<Character,Integer> me:map.entrySet())
        {
            
            val=me.getValue();
            if(flag==false && val==1)
                flag=true;
            if(val>=2)
            {
                int rem=val%2;
                if(rem==0)
                {
                    ans+=val;
                   
                }
                else
                {
                    ans+=val-rem;
              flag=true;
                }
            }
            
            
        }
        
        
        System.out.println("After:"+map);
        if(flag)
        return ans+1;
        else
            return ans;
    }
}