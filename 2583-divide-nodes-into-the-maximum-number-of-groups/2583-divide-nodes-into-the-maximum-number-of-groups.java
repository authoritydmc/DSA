import java.util.*;

class Solution {
    private int[] nodeColor;
    private List<List<Integer>> graph;
    private int totalNodes;

    private boolean isBipartite(int node, int color, List<Integer> component) {
        nodeColor[node] = color;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            if (nodeColor[neighbor] == color) return false;
            if (nodeColor[neighbor] == -1 && !isBipartite(neighbor, 1 - color, component)) 
                return false;
        }
        return true;
    }

    private int computeMaxGroups(List<Integer> component) {
        int maxGroups = 0;
        for (int start : component) {
            int[] depth = new int[totalNodes];
            Arrays.fill(depth, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            depth[start] = 0;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (depth[neighbor] == -1) {
                        depth[neighbor] = depth[node] + 1;
                        maxGroups = Math.max(maxGroups, depth[neighbor]);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return maxGroups + 1;
    }

    public int magnificentSets(int n, int[][] edges) {
        this.totalNodes = n;
        nodeColor = new int[n];
        Arrays.fill(nodeColor, -1);
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nodeColor[i] == -1) {
                List<Integer> component = new ArrayList<>();
                if (!isBipartite(i, 0, component)) 
                    return -1;
                components.add(component);
            }
        }

        int totalGroups = 0;
        for (List<Integer> component : components) {
            totalGroups += computeMaxGroups(component);
        }

        return totalGroups;
    }
}
