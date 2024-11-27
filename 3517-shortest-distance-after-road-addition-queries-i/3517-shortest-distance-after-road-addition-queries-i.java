class Solution {
    private void addEdgeToGraph(int u, int v, Map<Integer, List<Integer>> graph) {

        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(v);
    }

    private int getPath(int source, int destination, Map<Integer, List<Integer>> graph) {

        int path = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        q.add(-1);
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            // we found the target hence return ...
            if (node == destination) {
                return path;
            }
            if (node == -1) {
                if (!q.isEmpty()) {
                    path++;
                    q.add(-1);
                }
                continue;
            }
            
            visited.add(node);
            List<Integer> nodesToExplore=graph.get(node);
            for(int n:nodesToExplore)
            {
                if(!visited.contains(n))
                    q.add(n);
            }
        }
        return -1;

    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // shortest path ==BFS
        int[] res = new int[queries.length];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // build adjency list graph
        for (int i = 0; i < n - 1; i++) {
            // System.out.println("adding edge from " + i + " to " + (i + 1));
            addEdgeToGraph(i, i + 1,graph);
        }
        int count = 0;
        for (int[] query : queries) {
            addEdgeToGraph(query[0], query[1],graph);
            res[count++] = getPath(0, n - 1, graph);
        }

        return res;
    }
}