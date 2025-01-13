class Solution {
    public int minimumLength(String s) {
       Map<Character,Integer> imap=new HashMap<>();
       for(int i=0;i<s.length();i++)
       {
        imap.merge(s.charAt(i),1,Integer::sum);
       } 
       int cnt=0;

        for(int q:imap.values())
        {
           cnt+=q>2?q%2==0?2:1:q;
        }

   

       return cnt;
    }
}