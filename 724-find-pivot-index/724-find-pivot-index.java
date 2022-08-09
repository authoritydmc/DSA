class Solution {
    
    
    public int pivotIndex(int[] nums) {
        
//         calculate prefix sum
        
        int [] p=new int[nums.length];
        p[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            p[i]=p[i-1]+nums[i];
        }
        
//         now go and check
        
        for(int i=0;i<nums.length;i++)
        {
            int ls=i<=0?0:p[i-1];
            int rs=p[nums.length-1]-p[i];
            System.out.println("Index i="+i+" ls,rs"+ls+" "+rs);
            if(ls==rs)
                return i;
            
        }
        return -1;
    }
}