class Solution {
    public int[] runningSum(int[] nums) {
        
        int [] ans=new int[nums.length];
        int rs=0;
        for (int i=0;i<nums.length;i++)
        {
            rs+=nums[i];
            ans[i]=rs;
        }
        
        return ans;
    }
}