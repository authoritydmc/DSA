class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int ans=0;
        
//         LOGIC is find all 2 pairs of characters and +1 odd character [ at max ]
//          ie. xxyzDzyxx here D is 1 time occuring odd character
        
        
        for(char c:s.toCharArray())
        {
            
            map.put(c,map.getOrDefault(c,0)+1);
            
            
        }
                System.out.println("Before:"+map);
// case 1 : if only single type of character present 
        if(map.size()==1)
            return map.get(s.charAt(0));
        
//         flag variable to denote that if there is possibility of a odd 1 character which can be added 
        boolean flag=false;
        int val=-1;
        
        
        for(Map.Entry<Character,Integer> me:map.entrySet())
        {
            
            val=me.getValue();
//             case 2 : 1 single occuring character which can be treated as odd character
            if(flag==false && val==1)
                flag=true;
            if(val>=2)
            {
//                 now we are into pair checking 
                
//                 rem to see after making pair is there any character left or not
                int rem=val%2;
                if(rem==0)
                {
//                      if not then its okay all characters are consumed 
                    ans+=val;
                   
                }
                else
                {
//                     not all characters are consumed so just make flag true
                    ans+=val-rem;
              flag=true;
                }
            }
            
            
        }
        
        
        System.out.println("After:"+map);
//         if any odd character occurences possible we add 1 time 
        if(flag)
        return ans+1;
        else
            return ans;
    }
}