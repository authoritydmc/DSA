class Solution {
   public char[][] rotateTheBox(char[][] box) {
        int m = box.length;  // number of rows
        int n = box[0].length; // number of columns
        char[][] rsltbox = new char[n][m];  // Create a new box to hold the rotated result
        
        // Iterate through each column in the original box
        for (int i = 0; i < n; i++) {
            // Iterate through each row of the original box
            for (int j = m - 1; j >= 0; j--) {
                // Place the current element at the rotated position
                rsltbox[i][j] = box[m - j - 1][i]; // Rotate the element from (m-j-1, i) to (i, j)
            }
        }
        // printBox(rsltbox);
        //process each cols now 
        for(int col=0;col<m;col++)
        {   
            //for each cols start from bottom i.e last cell and try to shift
               int traversal=Integer.MAX_VALUE;
              for(int row=n-1;row>=0;row--)
              {
                //this cell has stone ,, cant move past it ...
                if(rsltbox[row][col]=='*')
                {
                    continue;
                }
              else  if(rsltbox[row][col]=='.')
              {
                //we have found a valid cell where we can place a stone .move upwards and find either a valid stone or obs...

                traversal=Math.min(traversal,row-1);

                while(traversal>=0)
                {
                    if(rsltbox[traversal][col]=='*')
                    {
                        //obstacle found ... 
                        //we should check below obstacles 
                        row=traversal;
                        //
                        traversal-=1;
                        break;
                    }
                    if(rsltbox[traversal][col]=='#')
                    {
                        //move it to current cell ....
                        rsltbox[row][col]='#';
                        rsltbox[traversal][col]='.';
                        traversal-=1;
                        break;
                    }
                    traversal--;
                }
                
              }

              }
        }

        return rsltbox;
    }

    public void printBox(char[][] box) {
        System.out.println("+---+---+---+---+"); // Print top border
        for (char[] row : box) {
            System.out.print("| ");  // Start of the row
            for (char c : row) {
                System.out.print(c + " | ");  // Print each element surrounded by vertical bars
            }
            System.out.println();  // Move to the next row
            System.out.println("+---+---+---+---+"); // Print row separator
        }
    }
}