import java.util.*;

class Solution {

    // Find path from node 0 to Bob's starting node
    private boolean findPath(Map<Integer, List<Integer>> g, int node, int parent, int target, List<Integer> path) {
        path.add(node);
        if (node == target) {
            return true;
        }
        for (int nbr : g.getOrDefault(node, List.of())) {
            if (nbr == parent) continue;
            if (findPath(g, nbr, node, target, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    // DFS to compute Alice's maximum profit
    private int dfsAlice(Map<Integer, List<Integer>> graph, int node, int parent, int[] amount, Map<Integer, Integer> bobTimeMap, int time) {
        int bobTime = bobTimeMap.getOrDefault(node, Integer.MAX_VALUE);
        int profit = (time < bobTime) ? amount[node] : (time == bobTime) ? amount[node] / 2 : 0;

        int maxSubtreeProfit = Integer.MIN_VALUE;
        boolean isLeaf = true;

        for (int neighbor : graph.getOrDefault(node, List.of())) {
            if (neighbor == parent) continue;
            isLeaf = false;
            int subtreeProfit = dfsAlice(graph, neighbor, node, amount, bobTimeMap, time + 1);
            maxSubtreeProfit = Math.max(maxSubtreeProfit, subtreeProfit);
        }

        return isLeaf ? profit : profit + (maxSubtreeProfit == Integer.MIN_VALUE ? 0 : maxSubtreeProfit);
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        // Build adjacency list
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        // Find Bob's path from node 0 to bob, then reverse it
        List<Integer> path = new ArrayList<>();
        findPath(g, 0, -1, bob, path); // e.g., [0,1,3]
        Collections.reverse(path);     // e.g., [3,1,0]

        // Set Bob's arrival times along his path
        Map<Integer, Integer> bobTimeMap = new HashMap<>();
        for (int i = 0; i < path.size(); i++) {
            bobTimeMap.put(path.get(i), i); // {3:0, 1:1, 0:2}
        }

        // Compute Alice's maximum profit starting from node 0
        return dfsAlice(g, 0, -1, amount, bobTimeMap, 0);
    }
}