class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum = 0;

        int rs=0;
        int minRs=0;
        for (int i = 0; i < nums.length; i++) {
            rs+=nums[i];
            minRs+=nums[i];
            
            rs=Math.max(rs,nums[i]);
            minRs=Math.min(minRs,nums[i]);
            maxSum=Math.max(maxSum,rs);
            minSum=Math.min(minSum,minRs);
           
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}