class Solution {
    public int lengthOfLongestSubstring(String s) {
        //sliding window problem 

        int i=0;
        int j=0;
        int n=s.length();
        if(n==0)
        return 0;
        Set<Character> set=new HashSet<>();

        int maxL=Integer.MIN_VALUE;
        
        while(j<n)
        {
            char c=s.charAt(j);
            if(set.contains(c))
            {
                //move i pointer till we get the rid of the duplicate character ..
                while(set.contains(c) && i<j)
                {   
                    set.remove(s.charAt(i++));
                }
            }
            set.add(c);
            maxL=Math.max(set.size(),maxL);
            j++;
        }


        return maxL;
    }
}