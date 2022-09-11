class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int cols=matrix[0].length-1;
         int r=-1;
        for(int i=0;i<matrix.length;i++)
        {
           
            if(target<=matrix[i][cols] && target>=matrix[i][0])
                
            {
                r=i;
                break;
            }
            
        }
        
        if(r==-1) return false;
        
      return  binSearch(matrix[r],target);
    }
    
    private boolean binSearch(int [] nums,int target)
    {
        
        // System.out.println("Checking in "+nums);
        Arrays.stream(nums).forEach(System.out::print);
        int left=0;
        int right=nums.length-1;
        
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
                return true;
            
            if(target<nums[mid])
                right=mid-1;
            else
                left=mid+1;
        }
        return false;
    }
}