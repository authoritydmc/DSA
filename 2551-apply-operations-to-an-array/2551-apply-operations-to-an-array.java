class Solution {
    public int[] applyOperations(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int zeros_ind = nums.length - 1;
        int iter = nums.length - 1;

        while (iter >= 0) {
            int n = nums[iter];
            if (n == 0) {
                // from this index till zero_ind move nums forwards
                int movers = iter;
                while (movers < zeros_ind)
                    nums[movers] = nums[++movers];

                nums[zeros_ind--] = 0;
            }
            iter--;
        }

        return nums;
    }
}