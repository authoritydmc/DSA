class Solution {
    public int minimumLength(String s) {
      int [] imap=new int[26];
       for(int i=0;i<s.length();i++)
       {
        imap[s.charAt(i)-'a']++;
       } 
       int cnt=0;

        for(int q:imap)
        {
            if(q!=0)
           cnt+=q%2==0?2:1;
        }

   

       return cnt;
    }
}