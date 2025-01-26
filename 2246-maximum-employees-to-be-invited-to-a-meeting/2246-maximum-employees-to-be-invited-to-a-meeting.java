class Solution {
    private int BFS(int startNode,Map<Integer,List<Integer>> g,boolean [] visited)
    {

        int maxDistance=0;
        Queue<int [] > q=new LinkedList<>();
        q.add(new int[]{startNode,0});
        
        while(!q.isEmpty())
        {
            int [] curNode=q.poll();
            int dist=curNode[1];
           
            for(int nbr:g.getOrDefault(curNode[0],List.of()))
            if(!visited[nbr])
            {
                visited[nbr]=true;
                q.offer(new int[]{nbr,dist+1});
                maxDistance=Math.max(maxDistance,dist+1);
            }
        }

        return maxDistance;
    }
    public int maximumInvitations(int[] favorite) {
        int n=favorite.length;
        //make a reverse graph first ::
        Map<Integer,List<Integer>> g=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            //reverse graph wer are making so that 
            int v=favorite[i];
           g.computeIfAbsent(v,k->new ArrayList<>()).add(i);
        }

        int longestCycleCnt=0;
        int happyCoupleCnt=0;

        boolean [] visited=new boolean[n];
        for(int i=0;i<n;i++)
        {
            int curNode=i;
            int curNodeLen=0;
            Map<Integer,Integer> nodeLenMap=new HashMap<>();
            //till we have not found the cycle ::: 
            while(!visited[curNode])
            {
                visited[curNode]=true;
                nodeLenMap.put(curNode,curNodeLen);
                int nextNode=favorite[curNode];
                curNodeLen++;
                if(nodeLenMap.get(nextNode)!=null)
                {
                    //we have found a cycle :: do the calculations and break;

                    int cycleLen=curNodeLen-nodeLenMap.get(nextNode);
                    longestCycleCnt=Math.max(longestCycleCnt,cycleLen);
                    //happy couple case :::
                    if(cycleLen==2)
                    {
                        boolean [] visitedG=new boolean [n];
                        visitedG[curNode]=visitedG[nextNode]=true;
                        happyCoupleCnt+=2+BFS(curNode,g,visitedG)+BFS(nextNode,g,visitedG);
                    }

                    break;
                }



                curNode=nextNode;


            }

            


        }


        return Math.max(longestCycleCnt,happyCoupleCnt);
        
    }
}