class Solution {
    private int solveBrute(int[] nums1, int[] nums2) {
        int[] c = new int[nums1.length * nums2.length];
        int ind = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++)
                ind = ind ^ nums1[i] ^ nums2[j];
        }

        // System.out.println("Array "+Arrays.toString(c));

        return ind;
    }

    private int solveOptimised(int[] nums1, int[] nums2) {
        int xor1 = 0;
        int xor2 = 0;

        // XOR all elements in nums1
        for (int n : nums1) {
            xor1 ^= n;
        }

        // XOR all elements in nums2
        for (int n : nums2) {
            xor2 ^= n;
        }

        // Check the length of nums1 and nums2
        int len1 = nums1.length;
        int len2 = nums2.length;

        // Calculate the result based on lengths
        int result = 0;
        if (len1 % 2 != 0) {
            result ^= xor2; // If nums1 length is odd, nums2 contributes
        }
        if (len2 % 2 != 0) {
            result ^= xor1; // If nums2 length is odd, nums1 contributes
        }

        return result;
    }

    public int xorAllNums(int[] nums1, int[] nums2) {

        // Calling the optimized solve method
        return solveOptimised(nums1, nums2);
    }
}