class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0;
        int j=0;
        int m=str1.length();
        int n=str2.length();
        while(i<m && j<n)
        {
            char c=str1.charAt(i);
            char d=str2.charAt(j);
            if(c==d || (c+1)==d || (c=='z' && d=='a'))
            {
                j++;
            }
            i++;
        }

        return j==n;
    }
}