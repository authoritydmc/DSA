class Solution {
    public int findChampion(int[][] grid) {
        int team=-1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++)
        {
            int [] teamStat=grid[i];
            //count wins to know if this is best team we have
            int winCnt=0;
            for(int wins:teamStat)
            {
                if(wins==1)
                    winCnt++;
            }
            if(winCnt>max)
            {
                max=winCnt;
                team=i;
            }
        }
        return team;
    }
}