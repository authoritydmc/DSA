class Solution {
    private List<int[]> getNeighbours(char[][] maze, int[] cur) {
        List<int[]> lst = new ArrayList<>();
        int row = cur[0];
        int col = cur[1];
        int dist = cur[2];

        if (row - 1 >= 0 && maze[row - 1][col] == '.')
            lst.add(new int[] { row - 1, col, dist + 1 });
        if (row + 1 < maze.length && maze[row + 1][col] == '.')
            lst.add(new int[] { row + 1, col, dist + 1 });

        if (col - 1 >= 0 && maze[row][col - 1] == '.')
            lst.add(new int[] { row, col - 1, dist + 1 });
        if (col + 1 < maze[0].length && maze[row][col + 1] == '.')
            lst.add(new int[] { row, col + 1, dist + 1 });
        return lst;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        // standard BFS problem :: shortest path ::
        Queue<int[]> q = new LinkedList<>(); // int [] is row,col,distance indices

        q.add(new int[] { entrance[0], entrance[1], 0 });
        Set<String> visited = new HashSet<>();
        visited.add(entrance[0] + ":" + entrance[1]);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
        //    System.out.println("Current loc is "+Arrays.toString(cur));
            // found the shortest path
            if ((cur[0] == 0 || cur[1] == 0  || cur[0]+1==maze.length || cur[1]+1==maze[0].length) && cur[2]!=0) {
                return cur[2];
            }

            // get all valid neighbours::
            for (int[] validNeighbours : getNeighbours(maze, cur)) {
                String key = validNeighbours[0] + ":" + validNeighbours[1];
                if (visited.contains(key))
                    continue;
                q.add(validNeighbours);
                visited.add(key);
            }
        }

        return -1;
    }
}