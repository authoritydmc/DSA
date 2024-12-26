class Solution {
    private int minSolve(int[][] grid, int i, int j, Map<String, Integer> memo) {
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i + 1 == grid.length && j + 1 == grid[0].length) {
            // valid end reached just reutrn the ans:::
            return grid[i][j];
        }
        String key = i + ":" + j;
        if (memo.containsKey(key))
            return memo.get(key);
        int move_down = minSolve(grid, i + 1, j, memo);
        int move_right = minSolve(grid, i, j + 1, memo);
        memo.put(key, grid[i][j] + Math.min(move_down, move_right));
        return memo.get(key);
    }

    public int minPathSum(int[][] grid) {
        Map<String, Integer> memo = new HashMap<>();
        return minSolve(grid, 0, 0, memo);
    }
}