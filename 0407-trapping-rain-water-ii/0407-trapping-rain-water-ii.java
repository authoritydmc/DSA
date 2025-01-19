class Solution {
    public int trapRainWater(int[][] heightMap) {
        // using heap and BFS traversal ::
        int m = heightMap.length;
        int n = heightMap[0].length;
        int water = 0;
        int [][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[m][n];
        // add boundaries cells ::

        // for top and bottom rows
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            pq.offer(new int[] { heightMap[0][i], 0, i });
            pq.offer(new int[] { heightMap[m - 1][i], m - 1, i });
        }

        // for first and last cols:

        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.offer(new int[] { heightMap[i][0], i, 0 });
            pq.offer(new int[] { heightMap[i][n - 1], i, n - 1 });
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int height = cur[0];
            int i = cur[1];
            int j = cur[2];

            for (int[] dir : directions) {
                int i_=i+dir[0];
                int j_=j+dir[1];

                if(i_>=0 && i_<m && j_>=0 && j_<n && visited[i_][j_]==false)
                {
                        //add to the PQ for for further exploration :::
                        water+=Math.max(0,height-heightMap[i_][j_]);
                        pq.offer(new int [] {Math.max(height,heightMap[i_][j_]),i_,j_});
                        visited[i_][j_]=true;
                }
            }
        }

        return water;
    }
}