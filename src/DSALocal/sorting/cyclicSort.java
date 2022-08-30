package DSA.sorting;


public class cyclicSort {

    public int [] sort(int [] nums)
    {

        System.out.println("Before Cyclic Sorting ");
        sortingMain.printSorted(nums);
        int i=0;
        while (i<nums.length)
        {
//            correct : 2,0,1,6,4,5,3
//            example : 3,1,2,7,5,6,4
//            get correct Index
            int correctIndex=nums[i]-1;

//            check if it is at correct position

            if (correctIndex==i)
            {
//                yes its correct index ,check next
                i++;
            }else
            {
//                swap the number with correct Index

                swap(nums,correctIndex,i);
            }


        }

        System.out.println("After sorting final ");
        sortingMain.printSorted(nums);

        return  nums;
    }

    private void swap(int[] nums, int correctIndex, int i) {

        int temp=nums[correctIndex];
        nums[correctIndex]=nums[i];
        nums[i]=temp;

    }
}
