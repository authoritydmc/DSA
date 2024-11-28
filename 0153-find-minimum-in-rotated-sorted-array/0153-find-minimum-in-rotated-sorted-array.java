class Solution {
    public int findMin(int[] nums) {
        // finding min is same as finding pivot ;;

        int l = 0;
        int r = nums.length - 1;
        int mid=0;
        while(l<=r)
        {
             mid=l+(r-l)/2;
            // System.out.println(" mid is "+mid);
            if(nums[mid]>nums[r])
            {
                l=mid+1;
            }else if(nums[mid]<nums[r])
            {
                r=mid;
            }
            else
            {
                break;
            }
        }
    return nums[mid];
    }
}