class Solution {
    static int [] memo;
    private boolean solve(int [] nums,int index)
    {
        //base cases : 
        //if we go below array bound maybe some index contain negative nos
        if(index<0)
        return false;

        //we have reached last index hence true
        if(index==nums.length-1)
        return true;

        //we have jumped outside of bound
        if(index>=nums.length)
            return true;
        //we are staying at the same index
        if(nums[index]==0)
        return false;

        if(memo[index]!=-1)
        return memo[index]==1?true:false;

        boolean isItPossible=false;

        for(int i=1;i<=nums[index];i++)
            isItPossible=isItPossible ||  solve(nums,index+i);
       
        memo[index]= (isItPossible)?1:0 ;
        //   System.out.println(Arrays.toString(memo));
        return memo[index]==1?true:false;
        // return solve(nums,index+nums[index]);

    }
    public boolean canJump(int[] nums) {
        // memo=new int [nums.length+1];
        // Arrays.fill(memo,-1);
                  

        // return solve(nums,0);
        return tabSolve( nums);

    }

    private boolean tabSolve(int [] nums)
    {
        boolean [] dp=new boolean [nums.length];
        //can we reach this position by jumping on same location yes 
        dp[0]=true;

        for(int i=0;i<nums.length-1;i++)
        {
            int maxJumpTo=nums[i];
            System.out.println("Current index "+i+ "can max jump to "+(i+maxJumpTo)+" index");
            if(dp[i]==false)
                return false;
            for(int j=1;j<=maxJumpTo;j++)
            {
                //we are marking each place we can jump to true;
                if(i+j>=nums.length)
                return true;
                dp[i+j]=true;
            }
        }
        

        return dp[nums.length-1];
    }
}