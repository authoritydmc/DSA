class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (i == j || i == n - 1 - j) {
                   if(grid[i][j]==0)
                   return false;
                } else
                 
                 if (grid[i][j] != 0) {
                    System.out.println("non zero found other than diag " + i + ":" + j);
                    return false;

                }
            }
        }
        return true;

    }
}