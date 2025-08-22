class Solution {
    public int minimumArea(int[][] grid) {
        int minRow=Integer.MAX_VALUE;
        int maxRow=Integer.MIN_VALUE;
        int minCol=Integer.MAX_VALUE;
        int maxCol=Integer.MIN_VALUE;
        int m=grid.length;
        int n=grid[0].length;
        for(int row=0;row<m;row++)
        {
            for(int col=0;col<n;col++)
            {
                if(grid[row][col]==1)
                {
                    minRow=Math.min(minRow,row+1);
                    maxRow=Math.max(maxRow,row+1);
                    minCol=Math.min(minCol,col+1);
                    maxCol=Math.max(maxCol,col+1);
                }
            }


        }

        int height=maxRow-minRow+1;
        // System.out.println("height"+height);
        int width=maxCol-minCol+1;
        // System.out.println("width"+width);
        return height*width;
        
    }
}