class Solution {
    private int minSolve(int[][] grid, int i, int j, int[][] memo) {
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i + 1 == grid.length && j + 1 == grid[0].length) {
            // valid end reached just reutrn the ans:::
            return grid[i][j];
        }
        
       if (memo[i][j]!=-1)
       return memo[i][j];
        int move_down = minSolve(grid, i + 1, j, memo);
        int move_right = minSolve(grid, i, j + 1, memo);
        memo[i][j]=grid[i][j] + Math.min(move_down, move_right);
        return memo[i][j];
    }

    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            Arrays.fill(memo[i], -1);
        return minSolve(grid, 0, 0, memo);
    }
}