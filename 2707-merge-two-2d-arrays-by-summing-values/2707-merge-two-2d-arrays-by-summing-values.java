class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] n : nums1) {
            map.put(n[0], n[1]);
        }

        for (int[] n : nums2) {
            map.put(n[0], map.getOrDefault(n[0],0)+n[1]);
        }
        int[][] res = new int[map.size()][2];
        int ind=0;
        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            res[ind][0]=me.getKey();
            res[ind++][1]=me.getValue();
        }

        return res;
    }
}