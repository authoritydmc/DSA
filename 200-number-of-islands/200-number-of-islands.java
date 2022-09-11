class Solution {
    public int numIslands(char[][] grid) {
        
        HashSet<String> visited=new HashSet<>();
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                 if( dfs(grid,i,j,visited))
                                     count++;

                System.out.println("caller called");
            }
        }
       return count;
    }
    private boolean dfs(char [] [] grid,int r,int c,HashSet<String>visited)
    {
        System.out.println("Checking for "+r+" "+c);
        
//         condition checking 
        
//         check upper and lower bound
        boolean row=r>=0 && r<grid.length;
        
        boolean col=c>=0 && c<grid[0].length;
        
//         if any condition fails return 
        if(!(row && col))
            return false ;
        
//         water found return
        if(grid[r][c]=='0')
            return false ;
        
        
        String key=r+"$"+c;
        if(visited.contains(key))
            return false;
                System.out.println("Passed checking for "+r+" "+c);

        
        visited.add(key);
        dfs(grid,r,c-1,visited);
        dfs(grid,r,c+1,visited);
        dfs(grid,r-1,c,visited);
        dfs(grid,r+1,c,visited);
        
        return true;
        
    }
}