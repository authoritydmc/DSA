class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0;i<4;i++)
        {

            if(validate(mat,target))
            return true;
            int [] [] temp=new int [mat.length][mat[0].length];
            for(int row=0;row<mat.length;row++)
            {
                for(int col=0;col<mat[0].length;col++)
                {
                    temp[row][col]=mat[mat[0].length-col-1][row];
                }
            }
            mat=temp;
        }

        return false;
    }
    private boolean validate(int[][] mat, int[][] target)
    {
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]!=target[i][j])
                return false;
            }
        }
        return true;
    }
}