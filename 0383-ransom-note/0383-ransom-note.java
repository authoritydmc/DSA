class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:magazine.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(char c:ransomNote.toCharArray())
        {
            int cnt=map.getOrDefault(c,0);
            if(cnt==0)
            return false;
            map.put(c,cnt-1);
        }

        return true;
    }
}