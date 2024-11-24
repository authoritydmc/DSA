class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Integer>> boxSet = new HashMap<>();
        // Create arrays of HashSet for rows and columns
        Set<Integer>[] colSet = new HashSet[9];
        Set<Integer>[] rowSet = new HashSet[9];

        // Initialize each element in the arrays
        for (int i = 0; i < 9; i++) {
            colSet[i] = new HashSet<>();
            rowSet[i] = new HashSet<>();
        }

        int box = 0;
        for (int row = 0; row < board.length; row++) {
           // System.out.println("Checking for box "+box);
            for (int col = 0; col < 9; col++) {
                int num = board[row][col];
                if (num >= '0' && num <= '9')
                    num = num - '0';
                else
                    continue;
                 box = (row / 3) * 3 + (col / 3);
               // System.out.println("Checking number: " + num + " at position (" + row + ", " + col + ")"+" for box"+box);

                // if it exist in the any row ,col or box then return false;
                boxSet.putIfAbsent(box, new HashSet<>());
                if (boxSet.get(box).contains(num)) {
                 //   System.out.println("Duplicate found in box " + box);
                    return false;
                }
                if (colSet[col].contains(num)) {
                   // System.out.println("Duplicate found in column " + col);
                    return false;
                }
                if (rowSet[row].contains(num)) {
                  //  System.out.println("Duplicate found in row " + row);
                    return false;
                }

                // add the no to the rowSet for row level validation
                rowSet[row].add(num);
                // add the no to the colmn set for column level validation
                colSet[col].add(num);
                // add the no in the particular box for box valiation ...

                boxSet.get(box).add(num);

                // System.out.println("Row Set[" + row + "]: " + rowSet[row]);
                // System.out.println("Column Set[" + col + "]: " + colSet[col]);
                // System.out.println("Box Set[" + box + "]: " + boxSet.get(box));

            }
       

        }
        return true;
    }
}