class Solution {

    private boolean isReachable(int start,int dest,Map<Integer,List<Integer>> graph)
    {
        //using BFS traversal to do the same :::

        Queue<Integer> q=new LinkedList<>();

        Set<Integer> visited=new HashSet<>();
        visited.add(start);
        q.offer(start);
        while(!q.isEmpty())
        {
            int cur=q.poll();
            if(cur==dest)
            return true;
            for(int nbr:graph.get(cur))
            {
                if(visited.contains(nbr))
                continue;
                visited.add(nbr);
                q.add(nbr);
            }
        }

        return false;

    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Map<Integer,List<Integer>> g=new HashMap<>();
        // for(int i=0;i<numCourses;i++)
        // {
        //     g.put(i,new ArrayList<>());
        // }
        // for(int [] edge:prerequisites)
        // {
        //     int u=edge[0];
        //     int v=edge[1];
        //     g.get(u).add(v);
        // }
        // List<Boolean> res=new ArrayList<>();

        // for(int [] q:queries)
        // {
        //     res.add(isReachable(q[0],q[1],g));
        // }

        // return res;

        return optimised(numCourses,prerequisites,queries);
    }

    private List<Boolean> optimised(int numCourses, int[][] prerequisites, int[][] queries)
    {
            // Step 1: Initialize a reachability matrix
        boolean[][] reachable = new boolean[numCourses][numCourses];

        // Step 2: Populate the direct prerequisites into the reachability matrix
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            reachable[u][v] = true;
        }

        // Step 3: Floyd-Warshall Algorithm to compute transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        // Step 4: Answer the queries
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }

        return result;
    }
}