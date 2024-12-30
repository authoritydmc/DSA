class Solution {
    private static int MOD=(int)1e9+7;
    private int solve(int len, int low, int high, int zero, int one, Map<Integer, Integer> memo) {
        // case :: len out of bound...
        if (len > high)
            return 0;
        if (memo.containsKey(len))
            return memo.get(len);
        int cnt = 0;

        if(len>=low && len<=high)
            cnt+=1;
        
        int takeOne=solve(len+one,low,high,zero,one,memo);
        int takeZero=solve(len+zero,low,high,zero,one,memo);
        int total=(cnt+takeOne+takeZero)%MOD;

        memo.put(len,total);
        return total;
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        Map<Integer,Integer> memo=new HashMap<>();
        return solve(0,low, high, zero, one, memo);
    }
}