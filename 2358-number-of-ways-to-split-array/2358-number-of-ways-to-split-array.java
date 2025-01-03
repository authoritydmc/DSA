class Solution {
    private boolean isValid(long [] ps,int i)
    {
            long lsum=ps[i];
            long rsum=ps[ps.length-1]-ps[i];
            return lsum>=rsum;
    }

    public int waysToSplitArray(int[] nums) {
        int cnt = 0;
        long [] ps = new long[nums.length];
        ps[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            ps[i] = ps[i - 1] + nums[i];

        for (int i = 0; i < nums.length -1; i++) {
            if (isValid(ps, i))
                cnt++;
        }

        return cnt;
    }
}