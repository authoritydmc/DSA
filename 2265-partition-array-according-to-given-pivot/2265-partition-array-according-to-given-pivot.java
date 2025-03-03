class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = n - 1;
        
        // First, place all the elements less than pivot
        for (int num : nums) {
            if (num < pivot) {
                result[left++] = num;
            }
        }
        
        // Then, place all the elements equal to pivot
        for (int num : nums) {
            if (num == pivot) {
                result[left++] = num;
            }
        }
        
        // Finally, place all the elements greater than pivot
        for (int num : nums) {
            if (num > pivot) {
                result[left++] = num;
            }
        }
        
        return result;
    }
}
