class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0;
        int right=0;
        double sum=0;
        for(;right<k;right++)
        {
            sum+=nums[right];
        }
        double avg=sum/k;
        double max=avg;
        while(right<nums.length)
        {
            sum-=nums[left];
            sum+=nums[right];
            avg=sum/k;

            max=Math.max(max,avg);
            right++;
            left++;
        }
    return max;
    }
}