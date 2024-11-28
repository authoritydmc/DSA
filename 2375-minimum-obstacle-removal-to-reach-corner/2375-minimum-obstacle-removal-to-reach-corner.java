class Solution {

    private List<int[]> getNbrs(int i, int j, int rowLength, int colLength) {
        List<int[]> nbrs = new ArrayList<>();
        // we have 4 direction moves :::
        if (i - 1 >= 0)
            nbrs.add(new int[] { i - 1, j });
        if (j - 1 >= 0)
            nbrs.add(new int[] { i, j - 1 });
        if (j + 1 < colLength)
            nbrs.add(new int[] { i, j + 1 });
        if (i + 1 < rowLength)
            nbrs.add(new int[] { i + 1, j });
        return nbrs;

    }

    private String getNodeName(int i, int j) {
        return i + "_" + j;
    }

    // using dijkstra algo
    public int minimumObstacles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        // Using int [] =[0,1,2] format to store i,j and weight ....
        // pq
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        // distance map
        Map<String, Integer> distances = new HashMap<>();

        // add source node
        pq.add(new int[] { 0, 0, grid[0][0] });
        distances.put(getNodeName(0, 0), grid[0][0]);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int weight = cur[2];
            if (i == m - 1 && j == n - 1)
                return weight;
            // now get all neighbours ...
            for (int[] nbr : getNbrs(i, j, m, n)) {
                int nbrI = nbr[0];
                int nbrJ = nbr[1];
                int costToNbr = weight + grid[nbrI][nbrJ];
                if (costToNbr < distances.getOrDefault(getNodeName(nbrI, nbrJ), Integer.MAX_VALUE)) {
                    // we found suitable match hence update the distance

                    distances.put(getNodeName(nbrI, nbrJ), costToNbr);
                    pq.add(new int[] { nbrI, nbrJ, costToNbr });
                }
            }
        }

        return -1;

    }
}