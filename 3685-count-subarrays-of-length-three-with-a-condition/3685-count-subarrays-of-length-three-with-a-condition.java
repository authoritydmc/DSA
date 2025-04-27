class Solution {
    public int countSubarrays(int[] nums) {
        if (nums.length < 3)
            return 0;
        int ind = 2;
        int cnt = 0;

        while (ind < nums.length) {
            int first = nums[ind - 2];
            int second = nums[ind - 1];
            int third = nums[ind];
            // System.out.println("first is " + first + " second " + second + " third " + third);

            if ((first + third) * 2 == second)
                cnt++;

            ind++;

        }

        return cnt;
    }
}