class Solution {
    public String reverseWords(String s) {
        
        int n=s.length();
        StringBuilder ns=new StringBuilder();
        int left=0;
        int right=0;
        
        while(right<n)
        {
            
//             case 1 last Character i.e string end
            
            if (right==n-1)
            {
//                 rev and add
                
                rev(left,right,s,ns);
                
            }
            
            if(s.charAt(right)==' ')
            {
//                 rev
                
                
                rev(left,right-1,s,ns);
                ns.append(" ");
                left=right+1;
                
            }
            
            
            right++;
            
            
        }
        return ns.toString();
        
    }
    
    private void rev(int start,int end,String s,StringBuilder ns)
    {
        
        
        while(end>=start)
        {
            ns.append(s.charAt(end--));
        }
        
        
    }
}