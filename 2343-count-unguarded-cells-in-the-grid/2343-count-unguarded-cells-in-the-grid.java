class Solution {

      public  void printGrid(int[][] grid) {
        int m = grid.length;         // Number of rows
        int n = grid[0].length;      // Number of columns

        // Top border of the grid
        String border = "+".concat("----+".repeat(n));

        for (int i = 0; i < m; i++) {
            // Print the border
            System.out.println(border);

            // Print the row with the array content
            StringBuilder row = new StringBuilder("|");
            for (int j = 0; j < n; j++) {
                row.append(String.format(" %2d |", grid[i][j])); // Format content to fit nicely
            }
            System.out.println(row);
        }

        // Bottom border of the grid
        System.out.println(border);
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int [] [] grid=new int [m] [n];

        int count =0;

        for(int [] wall:walls)
        {
            grid[wall[0]][wall[1]]=-1;
        }
        for(int [] guard:guards)
        {
                int row=guard[0];
            int col=guard[1];
            grid[row][col]=3;
        }

        for(int [] guard:guards)
        {
            int row=guard[0];
            int col=guard[1];

            //mark up guard area as secured for up [col is fixed we are just moving row ]
            for(int i=row-1;i>=0;i--)
            {   
                //if wall or guard exist then break ;;;;
                if(grid[i][col]==-1 || grid[i][col]==3)
                 break;
                grid[i][col]=5;
            }

            //mark down 

               for(int i=row+1;i<m;i++)
            {   
                //if wall or guard exist then break ;;;;
            if(grid[i][col]==-1 || grid[i][col]==3)
                 break;
                grid[i][col]=6;
            }

            //mark left one 

            for(int j=col-1;j>=0;j--)
            {
                 if(grid[row][j]==-1 || grid[row][j]==3)
                 break;

                grid[row][j]=7;
            }

//mark right
             for(int j=col+1;j<n;j++)
            {
              if(grid[row][j]==-1 || grid[row][j]==3)
                 break;
                grid[row][j]=8;
            }
        }

        
    // printGrid(grid);
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==0)
                    count++;


        return count;

    }
}