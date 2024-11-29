class Solution {

    private String getNodeName(int row, int col)

    {
        return row + "_" + col;
    }

    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // base case can not move back and forth at 0th cell and there is no option to
        // even move now
        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1;
        int[][] directions = new int[][] {
                { 0, 1 }, // Right
                { 1, 0 }, // Down
                { 0, -1 }, // Left
                { -1, 0 } // Up
        };

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] <= b[0] ? -1 : 1);
        boolean[][] seen = new boolean[m+10][n+10];
        // time ,row,col format
        pq.add(new int[] { 0, 0, 0 });
        seen[0][0]=true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int row = cur[1];
            int col = cur[2];
            if (row == m - 1 && col == n - 1)
                return time;
            // now work on all its neighbors i.e 4 director based
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n ||seen[newRow][newCol]==true)
                    continue;
        // System.out.println("New row and col "+newRow+" "+newCol);
                seen[newRow][newCol]=true;

                if (grid[newRow][newCol] <= time + 1) {
                    pq.add(new int[] { time + 1, newRow, newCol });
                  
                } else if ((grid[newRow][newCol] - time) % 2 == 0) {
                    pq.add(new int[] { grid[newRow][newCol] + 1, newRow, newCol });
                  
                } else {
                    pq.add(new int[] { grid[newRow][newCol], newRow, newCol });
                   
                }


            }

        }
        return -1;
    }
}
