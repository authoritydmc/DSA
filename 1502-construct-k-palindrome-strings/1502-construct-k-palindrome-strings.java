class Solution {
    private boolean solveBrute(String s, int k) {
        if (s.length() < k)
            return false;
        int [] freq=new int [26];
        for(char c:s.toCharArray())
        freq[c-'a']++;
        int cnt=0;
        for(int i=0;i<26;i++)
            if(freq[i]%2!=0)
            cnt++;

        return cnt<=k;
    }

    public boolean canConstruct(String s, int k) {
        return solveBrute(s, k);
    }
}