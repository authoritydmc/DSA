import java.util.*;

class Solution {
    // DFS function with memoization
    private int dfs(int start, Set<Integer> terminals, int[] memo, int[][] graph) {
        // If the node is a terminal, it's safe
        if (terminals.contains(start)) {
            return 0; // Safe terminal
        }
        
        // Memoized result: if we've already computed this node, return the result
        if (memo[start] != -1) {
            return memo[start];
        }
        
        // Mark this node as temporarily unsafe
        memo[start] = 1; // Assume it's unsafe until proven safe
        
        // Explore the children of the current node
        for (int child : graph[start]) {
            // If the child leads to an unsafe state, then the current node is unsafe
            if (dfs(child, terminals, memo, graph) == 1) {
                memo[start] = 1; // Mark the current node as unsafe
                return 1;
            }
        }
        
        // If we reach here, it means the node is safe (no cycles or unsafe children)
        memo[start] = 0; // Mark the current node as safe
        return 0;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> safe = new HashSet<>();
        Set<Integer> terminal = new HashSet<>();
        Map<Integer, List<Integer>> pmap = new HashMap<>();
        
        // Initialize memoization array with -1 (undefined state)
        int[] memo = new int[graph.length];
        Arrays.fill(memo, -1);
        
        // Identify terminal nodes (nodes with no outgoing edges)
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                terminal.add(i); // Terminal nodes are initially safe
            }
            for (int v : graph[i]) {
                pmap.putIfAbsent(v, new ArrayList<>());
                pmap.get(v).add(i); // Add parent nodes to the map for backtracking
            }
        }
        
        // Run DFS for each node to determine if it's safe
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, terminal, memo, graph) == 0) {
                safe.add(i); // If the node is safe, add it to the safe set
            }
        }
        
        // Convert the safe set to a sorted list and return
        return new ArrayList<>(safe).stream().sorted().toList();
    }
}
