class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int n = nums.length;
        int max=0;
        while (j < n) {
            int maxRange = nums[i] + 2 * k;
            while (j<n && nums[j] <= maxRange) {
                j++;
                max = Math.max(max, j - i );
            }

            i++;
        }

        return max;
    }
}