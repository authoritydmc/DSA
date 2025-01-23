class Solution {
    public int countServers(int[][] grid) {
        int [] rowcnt=new int[grid.length];
        int [] colCnt=new int[grid[0].length];
        int totalComp=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    // System.out.println(" Found computer at "+i+" "+j);
                    rowcnt[i]++;
                    colCnt[j]++;
                    totalComp++;
                }
            }
        }
        int isoLatedComp=0;
     for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    if(rowcnt[i]==1 && colCnt[j]==1)
                    isoLatedComp++;
                }
            }
        }
        
        // System.out.println(" Row Cnt "+Arrays.toString(rowcnt));
        // System.out.println(" Col cnt "+Arrays.toString(colCnt));
        
        // System.out.println("Total comp "+totalComp+" isolated "+isoLatedComp);
        return totalComp-isoLatedComp;
        
    }
}