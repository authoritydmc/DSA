class Solution {
    public int trap(int[] height) {
        int water = 0;
        int m = height.length;
        // use lmax and rmax :: and now for each I calculate the water trapped
        int[] lmax = new int[m];
        int[] rmax = new int[m];

          // Fill lmax[] array: max height from left to right
        lmax[0] = height[0];
        for (int i = 1; i < m; i++) {
            lmax[i] = Math.max(height[i], lmax[i - 1]);
        }
        
        // Fill rmax[] array: max height from right to left
        rmax[m - 1] = height[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            rmax[i] = Math.max(height[i], rmax[i + 1]);
        }

        // System.out.println("RMAX >> "+Arrays.toString(rmax));
        // System.out.println("LMAX >> "+Arrays.toString(lmax));
        for (int i = 0; i < m; i++) {
            water += Math.max(0, Math.min(lmax[i], rmax[i]) - height[i]);
        }

        return water;
    }
}