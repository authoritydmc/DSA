class Solution {

    private int solve(int [] cost)
    {
        //bottom up approach like fib 
        int [] dp=new int[cost.length];
        int n=cost.length;
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++)
        {
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
            System.out.println("for step "+i+" best cost "+dp[i]);
        }

        return Math.min(dp[n-1],dp[n-2]);


    }
    public int minCostClimbingStairs(int[] cost) {
        
        int ans=solve(cost);
        return ans;
    }
}