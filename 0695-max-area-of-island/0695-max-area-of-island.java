class Solution {
      private int dfs(int[][] grid, int row, int col) {
        int fishes = 0;
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return 0;
        if (grid[row][col] == 0)
            return 0;

        fishes += grid[row][col];
        grid[row][col] = 0;

        fishes += dfs(grid, row - 1, col);
        fishes += dfs(grid, row, col - 1);
        fishes += dfs(grid, row, col + 1);
        fishes += dfs(grid, row + 1, col);

        return fishes;
    }

    private int maxArea(int[][] grid) {
        int max_fish = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max_fish=Math.max(max_fish, dfs(grid, i, j));
            }
        }
        return max_fish;
    }
    public int maxAreaOfIsland(int[][] grid) {
        return maxArea(grid);
    }
}