class Solution {
    private boolean canDistributeMax(int distributionLimit,int [] candies,long totalChildren)
    {
        long totalChildServed=0;

        for(int pile:candies)
        {
            long childrenServed=pile/distributionLimit;
            totalChildServed+=childrenServed;

        }

        return totalChildServed>=totalChildren;
    }
    public int maximumCandies(int[] candies, long k) {
        //worst case ::
        //each child gets 1 candies at max ::
        // best case : each child gets max(candies) each ::

        int l=1;
        int r=Arrays.stream(candies).max().getAsInt();
        int res=0;

        while(l<=r)
        {
            int mid=l+(r-l)/2;

            if(canDistributeMax(mid,candies,k))
            {
                //yes we can totally give mid size  candies to k children ::lets push more ::
                res=mid;
                l=mid+1;

            }
            else
            r=mid-1;
        }

        return res;
    }
}