class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int res = 1;

        int longest_inc = 1;
        int longest_desc = 1;
        int prev = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < prev) {
                longest_desc++;
                res = Math.max(res, longest_inc);
                longest_inc = 1;
            } else if (nums[i] > prev) {
                longest_inc++;
                res = Math.max(res, longest_desc);
                longest_desc = 1;
            } else {
                res = Math.max(res, longest_desc);
                res = Math.max(res, longest_inc);
                longest_inc = 1;
                longest_desc = 1;
            }
            prev = nums[i];
        }
        res = Math.max(res, longest_desc);
        res = Math.max(res, longest_inc);

        return res;
    }
}