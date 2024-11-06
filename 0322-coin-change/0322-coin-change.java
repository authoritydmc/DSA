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
    private int solveBottomUp(int [] coins,int amount)
    {
        //memo which will hold the result at each steps
        int [] memo=new int [amount+1];
        Arrays.fill(memo,amount+20);
        memo[0]=0;
        for (int i=1;i<=amount;i++)
        {
            for(int coin:coins)
            {
                if (coin<=i)
                {
                  
            memo[i]=Math.min(memo[i],memo[i-coin]+1);

                }
            }
        }
        return memo[amount]>amount?-1:memo[amount];
    }

    public int coinChange(int[] coins, int amount) {
        // Map<Integer, Integer> dp = new HashMap<>();
        // int ans = solve(coins, amount, dp);
        // if(ans==Integer.MAX_VALUE)
        // return -1;
        // return ans;

        return solveBottomUp(coins,amount);
    }
}