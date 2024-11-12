class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowSize = 0;
        int minSize = Integer.MAX_VALUE;
        int front = 0;
        int back = 0;
        int sum = 0;
        while (front < nums.length) {
            sum += nums[front];

            while (sum >= target) {
                // if we are more than target //stop at current index and remove from back till
                minSize = Math.min(minSize, (front - back));

                sum -= nums[back++];
            }
            front++;
        }
        return minSize==Integer.MAX_VALUE?0:minSize+1;
    }
}