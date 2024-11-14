class Solution {
    public int[][] merge(int[][] intervals) {

        int[][] solutions = new int [intervals.length] [2];

        int index = 0;
          Arrays.sort(intervals, (row1, row2) -> Integer.compare(row1[0], row2[0]));
        solutions[0][0] = intervals[0][0];
        solutions[0][1] = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<=solutions[index][1])
            {
                //we find start time less than previous end time hence merge 
                solutions[index][1]= Math.max(solutions[index][1],intervals[i][1]);
            }else
            {
                //no overlapping hence insert as new item
                index++;
                solutions[index][0]=intervals[i][0];
                solutions[index][1]=intervals[i][1];
            }
        }

        return Arrays.copyOfRange(solutions, 0, index+1);

    }
}