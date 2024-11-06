class Solution {
    private int solve(int[] coins, int target, Map<Integer, Integer> dp) {
        if (target < 0)
            return Integer.MAX_VALUE;
        if (target == 0)
            return 0;

        if (dp.containsKey(target))
            return dp.get(target);
        int minCoins=Integer.MAX_VALUE;
        for (int coin : coins) {
            int newTarget = target - coin;

            int ans = solve(coins, newTarget, dp) ;

            if(ans!=Integer.MAX_VALUE)
            {
                minCoins=Math.min(ans+1,minCoins);
            }

        }
        dp.put(target, minCoins);
        return minCoins;
    }

    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = solve(coins, amount, dp);
        if(ans==Integer.MAX_VALUE)
        return -1;
        return ans;
    }
}