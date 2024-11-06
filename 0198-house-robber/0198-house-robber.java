class Solution {

   
    private int solveBottomUp(int [] nums)
    {
        if(nums.length<=1)
        return nums[0];
        int [] mem=new int [nums.length];
        mem[0]=nums[0];
        mem[1]=Math.max(nums[0],nums[1]);

        for (int i=2;i<nums.length;i++)
        {

            mem[i]=Math.max(nums[i]+mem[i-2],mem[i-1]);
        }

        return mem[nums.length-1];
    }
    public int rob(int[] nums) {
        
    return solveBottomUp(nums);

    }
}