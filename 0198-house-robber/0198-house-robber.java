class Solution {

    private int solveRec(int[] nums,int i,int [] memo) {
          // Base cases
        if (i < 0) return 0;         // No elements left
        if (i == 0) return nums[0];   // Only one element
        if(memo[i]!=-1)
        return memo[i];
        // Recursive calculation for including or excluding current element
        int include = nums[i] + solveRec(nums, i - 2,memo);
        int exclude = solveRec(nums, i - 1,memo);

        // Return the maximum of the two options
        memo[i]= Math.max(include, exclude);
        return memo[i];
    }

    private int solveBottomUp(int[] nums) {
        if (nums.length <= 1)
            return nums[0];
        int[] mem = new int[nums.length];
        mem[0] = nums[0];
        mem[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {

            mem[i] = Math.max(nums[i] + mem[i - 2], mem[i - 1]);
        }

        return mem[nums.length - 1];
    }

    public int rob(int[] nums) {

        // return solveBottomUp(nums);
          // Initialize memo array with -1 (uncomputed states)
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return solveRec(nums,nums.length - 1,memo);
    }
}