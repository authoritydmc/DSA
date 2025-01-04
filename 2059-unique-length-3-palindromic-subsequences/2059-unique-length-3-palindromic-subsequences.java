class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, List<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            idxMap.computeIfAbsent(s.charAt(i),k->new ArrayList<Integer>()).add(i);
        }
        int result=0;
        for(char c:idxMap.keySet())
        {   
            List<Integer> idxList=idxMap.get(c);
            if(idxList.size()<2)
            continue;
            Set<Character> letters=new HashSet<>();
            int left_idx=idxList.get(0);
            int right_idx=idxList.get(idxList.size()-1);

            for(int i=left_idx+1;i<right_idx;i++)
                letters.add(s.charAt(i));

            result+=letters.size();
        }

        return result;
    }
}