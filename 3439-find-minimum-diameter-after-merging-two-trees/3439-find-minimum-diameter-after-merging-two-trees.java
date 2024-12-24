import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> makeGraph(int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.putIfAbsent(e[0], new LinkedList<>());
            g.get(e[0]).add(e[1]);
            g.putIfAbsent(e[1], new LinkedList<>());
            g.get(e[1]).add(e[0]);
        }
        return g;
    }

    private int getDiameter(Map<Integer, List<Integer>> graph, int startNode) {
        // Concept: First BFS traversal gives one end of the diameter from any random start node,
        // and then from that node we can do BFS again to get the actual length.
        int[] res = doBFS(startNode, graph);
        int[] farthestNodeData = doBFS(res[0], graph);
        return farthestNodeData[1];
    }

    private int[] doBFS(int startNode, Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startNode, 0});
        visited.add(startNode);

        int[] farthestNodeData = new int[] {startNode, 0};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentDistance > farthestNodeData[1]) {
                farthestNodeData = current;
            }

            for (int neighbor : graph.getOrDefault(currentNode, new LinkedList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[] {neighbor, currentDistance + 1});
                }
            }
        }
        return farthestNodeData;
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {

        int maxDiameter = Integer.MIN_VALUE;
int diameter1=0;
  int diameter2=0;
        if (edges1.length > 0) {
           diameter1  = getDiameter(makeGraph(edges1), edges1[0][0]);
            maxDiameter = Math.max(maxDiameter, diameter1);
        }

        if (edges2.length > 0) {
         diameter2  = getDiameter(makeGraph(edges2), edges2[0][0]);
            maxDiameter = Math.max(maxDiameter, diameter2);
        }
            int totalDiameter = (diameter1+1)/2+(diameter2+1)/2+1;
        // Return the maximum of merging the graphs and the maximum diameter found
        return Math.max(totalDiameter, maxDiameter);
    }
}
