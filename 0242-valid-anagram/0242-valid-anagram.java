class Solution {
    public boolean isAnagram(String s, String t) {
        
        return sorted(s).equals(sorted(t));
    }
    private String sorted(String s)
    {
        char [] t=s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
}