class Solution {
    private boolean containsInvalidIndexesInsideRange(int a, int b,int [] prefixSum) {
        return prefixSum[b]-prefixSum[a]!=0;
    }

    private boolean isParity(int a,int b)
    {
        return (a&1)==(b&1);
    }
    private void buildPrefix(int[] nums, int[] invPrefixSum) {
        invPrefixSum[0]=0;

        for(int i=1;i<nums.length;i++)
        {
            if(isParity(nums[i],nums[i-1]))
            {
                invPrefixSum[i]=invPrefixSum[i-1]+1;
            }else
            invPrefixSum[i]=invPrefixSum[i-1];
        }
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        int index = 0;
        int [] invalidIndexPrefixSum=new int [nums.length];
        buildPrefix(nums,invalidIndexPrefixSum);
        for (int[] q : queries) 
       {
            int s = q[0];
            int e = q[1];

            // contains invalid parity hence mark this as false
            if (containsInvalidIndexesInsideRange(s, e,invalidIndexPrefixSum)) {
                res[index++] = false;
                continue;
            }

            res[index++] = true;
        }
        return res;
    }
}