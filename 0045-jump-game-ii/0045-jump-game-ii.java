class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
    Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            int min_jumps = Integer.MAX_VALUE;
            int allowed_jumps = nums[i];
            // System.out.println("Index: " + i + ", Allowed jumps: " + allowed_jumps);
     
            for (int j = 1; j <= allowed_jumps; j++) {
                if (i + j < n) {
                    // System.out.println("Updating dp[" + (i + j) + "] from " + dp[i + j] + " to " + Math.min(dp[i + j], 1 + dp[i]));
                    dp[i + j] = Math.min(dp[i + j], 1 + dp[i]);
                }
            }

        }
        return dp[n - 1];
    }
}
