class Solution {

    private int solve(int n)
    {
        if(n<=1)
        return 1;
        //bottom up approach // tab
        int [] dp=new int [n];
    
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n-1]+dp[n-2];


    }

    public int climbStairs(int n) {
        return solve(n);
    }
}