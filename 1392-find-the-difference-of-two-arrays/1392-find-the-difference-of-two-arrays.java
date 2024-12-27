class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> lst1 = new HashSet<>();
        Set<Integer> lst2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        for (int n : nums1) {
            lst2.remove(n);
            lst1.add(n);
        }

        for(int n :nums2)
        {
            lst1.remove(n);
        }
         List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(lst1)); // Unique to nums1
        res.add(new ArrayList<>(lst2)); // Unique to nums2

        return res;
    }
}