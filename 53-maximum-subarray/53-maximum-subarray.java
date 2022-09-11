class Solution {
    public int maxSubArray(int[] nums) {
        
//         kadanes algo
        
        
        int rs=0;
        int maxc=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++)
        {
            
            rs+=nums[i];
            
        
            
            maxc=Math.max(maxc,rs);
            
                if(rs<0)
                rs=0;
            
        }
        
        return maxc;
        
    }
}