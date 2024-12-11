class Solution {
    private int binarySearch(int []nums,int start,int target)
    {
        int l=start;
        int r=nums.length-1;
        int res=r;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]<=target)
            {
                res=mid;
                //we have found a valid index we can push right to check if more furthest valid index
                l=mid+1;
            }else
            r=mid-1;

        }
        return res;
    }
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            int maxRange=nums[i]+2*k;
            int farthestGoodIndex=binarySearch(nums,i,maxRange);
            max=Math.max(max,farthestGoodIndex-i+1);

        }

        return max;
    }
}