class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
//         O(n) approach call
        
     return   find(nums,target);
    }
    
    private int[] find(int [] nums,int target)
    {
        
  int []s=new int [] {-1,-1};
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                s[0]=i;
//                 now as it is sorted check continous;;
                while( i+1 < nums.length && nums[++i]==target) 
                {
                   s[1]=i; 
                }
                if(s[1]==-1)s[1]=s[0];
                return s;
            }
            else if(nums[i]>target)
                return s;
        }
        return s;
    }
}