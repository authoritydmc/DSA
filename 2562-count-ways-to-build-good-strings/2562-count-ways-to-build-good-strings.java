class Solution {
    private static int MOD=(int)1e9+7;
    private int solve(int len, int low, int high, int zero, int one,int []memo) {
        // case :: len out of bound...
        if (len > high)
            return 0;
        if (memo[len]!=-1)
            return memo[len];
        int cnt = 0;

        if(len>=low && len<=high)
            cnt+=1;
        
        int takeOne=solve(len+one,low,high,zero,one,memo);
        int takeZero=solve(len+zero,low,high,zero,one,memo);
        int total=(cnt+takeOne+takeZero)%MOD;

        memo[len]=total;
        return total;
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
       int [] memo=new int[high+10];
       Arrays.fill(memo,-1);
        return solve(0,low, high, zero, one, memo);
    }
}