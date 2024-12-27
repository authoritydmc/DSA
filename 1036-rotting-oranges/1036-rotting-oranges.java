class Solution {

    private List<int[]> getNeighbours(int[][] grid ,int[] cur) {
        List<int []> lst=new ArrayList<>();
        int row=cur[0];
        int col=cur[1];
        //we can move up down left and right :::
        if(row+1<grid.length && grid[row+1][col]==1)
        lst.add(new int [] {row+1,col});
        if(row-1>=0 && grid[row-1][col]==1 )
        lst.add(new int [] {row-1,col});

        if(col+1<grid[0].length && grid[row][col+1]==1)
        lst.add(new int [] {row,col+1});
        if(col-1>=0 && grid[row][col-1]==1 )
        lst.add(new int [] {row,col-1});


        return lst;
    }

    private void doBFS(int[][] grid, int[][] dist, Queue<int[]> q) {

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_dist=dist[cur[0]][cur[1]];
            for (int[] nbrs : getNeighbours(grid, cur)) {
                // only add to queue if we can somehow minimize the rotting 
                if(cur_dist+1<dist[nbrs[0]][nbrs[1]])
                {
                    dist[nbrs[0]][nbrs[1]]=cur_dist+1;
                    q.add(nbrs);
                }
            }
        }
    }

    public int orangesRotting(int[][] grid) {
        // multi source BFS

        Queue<int[]> q = new LinkedList<>(); // it will store row,col ,minutes ::
        int[][] dist = new int[grid.length][grid[0].length];
        for (int[] arr : dist)
            Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i < grid.length; i++) { // Outer loop for rows
            for (int j = 0; j < grid[i].length; j++) { // Inner loop for columns
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                    dist[i][j] = 0;
                }
                // empty cell doesnt matter :::
                if (grid[i][j] == 0)
                    dist[i][j] = -999;
            }

        }
        doBFS(grid, dist, q);
        int max = Integer.MIN_VALUE;
        // basically we need to find the max in the dist grid and if any
        // Integer.MAX_VALUE is found directly return -1 as we know all fresh oranges
        // are not rotten :::
        for (int[] row : dist) {
            System.out.println("dist arr : "+Arrays.toString(row));
            for (int cell : row) {
                // fresh orange occured :::
                if (cell == Integer.MAX_VALUE)
                    return -1;
                max = Math.max(max, cell);
            }
        }
        return max==-999?0:max;

    }
}