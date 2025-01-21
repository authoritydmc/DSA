import java.util.Arrays;

class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[][] ps = new long[2][n];
        long min_points = Long.MAX_VALUE;

        // Calculate prefix sums for both rows
        for (int i = 0; i < 2; i++) {
            long rs = 0;
            for (int j = 0; j < n; j++) {
                rs += grid[i][j];
                ps[i][j] = rs;
            }
            // System.out.println("PS for row " + i + ": " + Arrays.toString(ps[i]));
        }

        // Try to calculate the minimal points the second robot can collect
        for (int i = 0; i < n; i++) {
            // Calculate the potential points left for the second robot if the first robot goes down to row 1
            long row1Possible = ps[0][n - 1] - ps[0][i];
            long row2Possible = i>0?ps[1][i-1]:0;

            // System.out.println("At column " + i + ":");
            // System.out.println("  First robot remaining points (row1Possible) = " + row1Possible);
            // System.out.println("  Second robot points (row2Possible) = " + row2Possible);

            min_points = Math.min(min_points, Math.max(row1Possible, row2Possible));

            // System.out.println("  Updated minimum points: " + min_points);
        }

        return min_points;
    }
}
