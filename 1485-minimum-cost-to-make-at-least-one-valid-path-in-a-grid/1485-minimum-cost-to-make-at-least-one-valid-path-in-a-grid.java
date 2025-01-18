class Solution {
    public int minCost(int[][] grid) {
        //using dijkstra to solve this

        int [][] dir={{0,1},{0,-1},{1,0},{-1,0}};
                    //r l d u

        int m=grid.length;
        int n=grid[0].length;
        int [] [] res=new int [m][n];
        for(int [] r:res)
        Arrays.fill(r,Integer.MAX_VALUE);
        res[0][0]=0;
        Queue<int []> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        //add source point .
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty())
        {

            int [] cur=pq.poll();
            int i=cur[1];
            int j=cur[2];
            int cost=cur[0];
            int gridDir=grid[i][j];
            //check for all available direction ::: 
            for(int [] d:dir)
            {
                int i_=i+d[0];
                int j_=j+d[1];
                // System.out.println("new Dir to explore is "+i_+" "+j_);
                if(i_>=m || i_<0 || j_<0 || j_>=n)
                continue;
                // System.out.println("new Dir to explore is "+i_+" "+j_+" passed ");

                int newCost=cost;
                if(gridDir==1 && d[0]==0 && d[1]==1)
                newCost+=0;
                else if(gridDir==2 && d[0]==0 && d[1]==-1)
                newCost+=0;
                else if(gridDir==3 && d[0]==1 && d[1]==0)
                newCost+=0;
                else if(gridDir==4 && d[0]==-1 && d[1]==0)
                newCost+=0;
                else
                newCost+=1;
                //found valid low cost hence update it and add it to pq
                if(newCost< res[i_][j_])
                {
                    res[i_][j_]=newCost;
                    pq.add(new int[]{newCost,i_,j_});
                }
            }

        }


        return res[m-1][n-1];
    }
}