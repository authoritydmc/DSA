class Solution {
    public int missingNumber(int[] nums) {
        
           int i=0;
        while (i<nums.length)
        {
//            get correct Index
            int correctIndex=nums[i]-1;

//            check if it is at correct position

            if (correctIndex==i || correctIndex==-1)
            {
//                yes its correct index ,check next
               i++;
            }else
            {
//                swap the number with correct Index

                swap(nums,correctIndex,i);
            }



        }
        for(int q=0;q<nums.length;q++)
            if(nums[q]==0)
                return q+1;
      return 0;
    }
    
     private void swap(int[] nums, int correctIndex, int i) {

        int temp=nums[correctIndex];
        nums[correctIndex]=nums[i];
        nums[i]=temp;

    }
}