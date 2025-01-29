class Solution {
    //dfs based checking :::
    private boolean isAlreadyConnected(Map<Integer, List<Integer>> g, int start, int dest, boolean[] visited) {
        if (start == dest)
            return true;
        visited[start] = true;
        for (int nbr : g.get(start)) {
            if (visited[nbr] == false) {
                if (isAlreadyConnected(g, nbr, dest, visited))
                    return true;
            }
        }
        return false;

    }

    private int[] solveBrute(int[][] edges) {
        int[] res = new int[2];

        Map<Integer, List<Integer>> g = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (g.containsKey(u) && g.containsKey(v)) {
                boolean[] visited = new boolean[edges.length + 10];
                if (isAlreadyConnected(g, u, v, visited)) {
                    return new int[] { u, v };
                }
            }
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);

        }

        return res;
    }

    private int[] solveDSU(int[][] edges) {

        DSU dsu=new DSU(edges.length);
        for(int [] edge:edges)
        {
            if(!dsu.union(edge[0],edge[1]))
            {
                return new int [] {edge[0],edge[1]};
            }
        }

        return new int [] {0,0};
    }

    public int[] findRedundantConnection(int[][] edges) {
        // return solveBrute(edges);

        return solveDSU(edges);
    }
}

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        // n represent the no of nodes ::
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        if (parent[node] == node)
            return node;
        parent[node] = find(parent[node]);
        return parent[node];

    }

    public boolean union(int u, int v) {

        int x = find(u);
        int y = find(v);

        // we found a cycle :
        if (x == y)
            return false;

        if(rank[x]<rank[y])
        {
            parent[x]=y;
        }else if (rank[x]>rank[y])
        {
            parent[y]=x;
        }else
        {
            //both are equal so doesnt matter;

            parent[x]=y;
            rank[y]++;
        }

        return true;

    }

}