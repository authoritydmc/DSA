class Solution {
    private boolean canBreakIn(int breaker,int [] nums,int maxOps)
    {

        int totalOps=0; // ops taken to achieve max penalty of breaker .

        for(int n:nums)
        {
            int ops=n/breaker;
            if(n%breaker==0)
                ops-=1;
            totalOps+=ops;
        }
        return totalOps<=maxOps;

    }
    public int minimumSize(int[] nums, int maxOperations) {
        //agar maximum ko minimise krna ho ya 
        // minimum ko maximize krna ho to we use 90% case me BINARY SEARCH..


        //we already know the worst answer i.e max value in nums ::: 
        //best case if each bag has just 1 balls
        int l=1;
        int r=Arrays.stream(nums).max().getAsInt();
        int result=r;

        while(l<r)
        {
            int mid=l+(r-l)/2;

            if(canBreakIn(mid,nums,maxOperations))
            {
                result=mid;
                //we can break using this .. hence we can go lower..
                r=mid;
            }else
            {
                //can not break in this ..we have to assume higher penalty 
                l=mid+1;
            }
        }
        return result;
        

    }
}