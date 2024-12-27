class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> freq =new HashMap<>();
        for(int n:arr)
        {
            freq.merge(n,1,Integer::sum);
        }
        Set<Integer> set=new HashSet<>();
        for(int val:freq.values())
        {
            if(set.contains(val))
            return false;
            set.add(val);
        }
        return true;
    }
}