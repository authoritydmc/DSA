class Solution {
    public long countBadPairs(int[] nums) {
        long good_pairs = 0;
        long n = nums.length;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int numI = nums[i] - i;
            good_pairs+=map.getOrDefault(numI,0l);
            map.merge(numI, 1l, Long::sum);
        }
              long total_pairs = (n * (n - 1)) / 2;
        return total_pairs- good_pairs;
    }
}