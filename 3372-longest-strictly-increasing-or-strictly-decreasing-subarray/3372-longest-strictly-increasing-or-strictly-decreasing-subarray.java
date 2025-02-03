class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int res = 1;

        int longest_inc = 1;
        int longest_desc = 1;
        int prev = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < prev) {
                longest_desc++;
        
                longest_inc = 1;
            } else if (nums[i] > prev) {
                longest_inc++;

                longest_desc = 1;
            } else {

                longest_inc = 1;
                longest_desc = 1;
            }
            res = Math.max(res, longest_desc);
            res = Math.max(res, longest_inc);
            prev = nums[i];
        }
      
        return res;
    }
}