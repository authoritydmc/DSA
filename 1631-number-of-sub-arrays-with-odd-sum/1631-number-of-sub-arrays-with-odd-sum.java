class Solution {
    int MOD = (int)1e9 + 7;
    
    // Helper for the brute-force approach: calculates the sum of subarray [start, end]
    private long getPrefixSum(long[] ps, int start, int end) {
        long startVal = 0;
        if (start > 0) {
            startVal = ps[start - 1];
        }
        return ps[end] - startVal;
    }
    
    // Brute-force approach with O(n^2) time complexity.
    private int brute(int[] nums) {
        int ans = 0;
        long[] ps = new long[nums.length];
        long rs = 0;
        
        // Create prefix sum array.
        for (int i = 0; i < nums.length; i++) {
            rs += nums[i];
            ps[i] = rs;
        }
        
        // Check every subarray.
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long s = getPrefixSum(ps, i, j);
                if (s % 2 != 0) {
                    ans++;
                }
                ans %= MOD;
            }
        }
        
        return ans;
    }
    
    // Optimized approach with O(n) time complexity using prefix parity counts.
    private int optimized(int[] arr) {
        long ans = 0;
        long prefix = 0;
        long countEven = 1; // Count of even prefix sums (empty prefix counts as even).
        long countOdd = 0;
        
        for (int num : arr) {
            prefix += num;
            if (prefix % 2 == 0) {
                // If current prefix is even, any previous odd prefix will yield an odd sum.
                ans = (ans + countOdd) % MOD;
                countEven++;
            } else {
                // If current prefix is odd, any previous even prefix will yield an odd sum.
                ans = (ans + countEven) % MOD;
                countOdd++;
            }
        }
        
        return (int) ans;
    }
    
    public int numOfSubarrays(int[] arr) {
  
        // return brute(arr);
      
        return optimized(arr);
    }
}
