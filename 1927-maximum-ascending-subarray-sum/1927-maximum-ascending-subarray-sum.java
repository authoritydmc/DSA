class Solution {
    public int maxAscendingSum(int[] nums) {
        int ms=nums[0];
        int rs=nums[0];
        int prev=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>prev)
            rs+=nums[i];
            else
            rs=nums[i];

            ms=Math.max(ms,rs);
            prev=nums[i];
        }


        return ms;
    }
}