class Solution {

    private int solveTab(int[] cost) {
        // bottom up approach like fib
        int[] dp = new int[cost.length];
        int n = cost.length;
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            System.out.println("for step " + i + " best cost " + dp[i]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);

    }

    private int solve(int[] cost, int i,int []dp) {
        //base case :
        if (i==0)
        return cost[0];
        if (i==1)
        return cost[1];

        if (i<0)
        return 0;
        //check if result exist in dp 
        if(dp[i]!=-1)
        return dp[i];

        //recurrense relation 

        dp[i]=Math.min(solve(cost,i-1,dp),solve(cost,i-2,dp))+cost[i];

        return dp[i];
    }

    private int solveRecursive(int[] cost) {
        int n=cost.length;
        int [] dp=new int [cost.length];
        Arrays.fill(dp, -1); 
      return Math.min(solve(cost,n-1,dp),solve(cost,n-2,dp));
    }

    public int minCostClimbingStairs(int[] cost) {

        // int ans=solveTab(cost);
        int ans = solveRecursive(cost);
        return ans;
    }
}