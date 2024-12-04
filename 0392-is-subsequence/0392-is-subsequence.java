class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int m = s.length();
        int n = t.length();
        while (i < m && j < n) {
            char c = s.charAt(i);
            char d = t.charAt(j);
            if (c == d)
                i++;
            j++;
        }

        return i == m;
    }
}