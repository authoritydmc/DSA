class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long min_so_far = Long.MAX_VALUE;

        long count_negatives = 0;
        long sum = 0;
        for (int[] row : matrix) {
            for (int cell : row) {
                if (cell < 0) {
                    count_negatives++;
                }
                long num=Math.abs(cell);
                min_so_far=Math.min(num,min_so_far);
                sum+=num;
            }
        }
        //if we have even no of negatives we can remove all negatives ...
        if(count_negatives%2==0)
        {
            return sum;
        }else
        {
         return   sum-(2*min_so_far);
        }
    }
}