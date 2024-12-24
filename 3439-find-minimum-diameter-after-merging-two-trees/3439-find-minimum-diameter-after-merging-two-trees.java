import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> makeGraph(int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], k -> new LinkedList<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new LinkedList<>()).add(e[0]);
        }
        return g;
    }

    private int getDiameter(Map<Integer, List<Integer>> graph, int startNode) {
        // First BFS to find one end of the longest path
        int[] res = doBFS(startNode, graph);
        // Second BFS from that end to find the diameter of the graph
        res = doBFS(res[0], graph);
        return res[1];  // The second value in the result array is the diameter
    }

    private int[] doBFS(int startNode, Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startNode, 0 });
        visited.add(startNode);

        int[] farthestNodeData = new int[] { startNode, 0 };
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentDistance > farthestNodeData[1]) {
                farthestNodeData = current;
            }

            for (int neighbor : graph.getOrDefault(currentNode, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[] { neighbor, currentDistance + 1 });
                }
            }
        }
        return farthestNodeData;
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int maxDiameter = Integer.MIN_VALUE;
        int diameter1 = 0, diameter2 = 0;

        // Build graph for the first tree and calculate its diameter
        if (edges1.length > 0) {
            Map<Integer, List<Integer>> graph1 = makeGraph(edges1);
            diameter1 = getDiameter(graph1, edges1[0][0]);
            maxDiameter = Math.max(maxDiameter, diameter1);
        }

        // Build graph for the second tree and calculate its diameter
        if (edges2.length > 0) {
            Map<Integer, List<Integer>> graph2 = makeGraph(edges2);
            diameter2 = getDiameter(graph2, edges2[0][0]);
            maxDiameter = Math.max(maxDiameter, diameter2);
        }

        // Return the maximum of merging the two graphs and the largest diameter found
        return Math.max((diameter1+1)/2 + (diameter2+1)/2 + 1, maxDiameter);
    }
}
