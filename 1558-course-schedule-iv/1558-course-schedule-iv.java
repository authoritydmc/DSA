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
        Map<Integer,List<Integer>> g=new HashMap<>();
        for(int i=0;i<numCourses;i++)
        {
            g.put(i,new ArrayList<>());
        }
        for(int [] edge:prerequisites)
        {
            int u=edge[0];
            int v=edge[1];
            g.get(u).add(v);
        }
        List<Boolean> res=new ArrayList<>();

        for(int [] q:queries)
        {
            res.add(isReachable(q[0],q[1],g));
        }

        return res;
    }
}