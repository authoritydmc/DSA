class Solution {
    private int solve(int[] nums, int rsum, int target, int index, Map<String, Integer> memo) {
        // base case
        if (index == nums.length) {
            if (target == rsum) {
                // System.out.println("Found one pattern match " + p);
                return 1;
            }
            return 0;
        }
        String key = index + ":" + rsum;
        if (memo.getOrDefault(key, null) != null) {
            return memo.get(key);
        }

        int comb_add = solve(nums, rsum + nums[index], target, index + 1, memo);
        int comb_sub = solve(nums, rsum - nums[index], target, index + 1, memo);

        memo.put(key, comb_add + comb_sub);
        return memo.get(key);
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return solve(nums, 0, target, 0, memo);
        // return btmSolve(nums, target);
    }

    private int btmSolve(int[] nums, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 0;
        return 0;
    }
}