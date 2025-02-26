class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int curMax = 0;
        int maxSum = 0;
        int curMin = 0;
        int minSum = 0;

        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
        }
        
       
        return Math.max(maxSum, Math.abs(minSum));
    }
}
