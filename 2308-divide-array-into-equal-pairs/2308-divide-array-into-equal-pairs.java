class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : nums)
            m.merge(n, 1, Integer::sum);

        int pair_cnt=0;

        for(int val:m.values())
        {
            if(val%2!=0)
            return false;
            pair_cnt+=val/2;
        }

        return pair_cnt==nums.length/2;
    }
}