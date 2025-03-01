class Solution {
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];

        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
                {
                    nums[i]*=2;
                    nums[i+1]=0;
                }
        }
        int ind = 0;

        for (int n : nums)
            if (n != 0)
                res[ind++] = n;

        return res;
    }
}