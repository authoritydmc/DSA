class Solution {
    public long coloredCells(int n) {
        //Total Colored Cells=n * n + (n - 1) * (n - 1)
        long z=n;
           return z * z + (z - 1) * (z - 1);
    }
}