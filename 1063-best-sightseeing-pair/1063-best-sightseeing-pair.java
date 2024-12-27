class Solution {
    private int bruteSolve(int [] values)
    {
        //brute force approach o(n2)
        int max=0;
        for(int i =0;i<values.length;i++)
        {
            for(int j=i+1;j<values.length;j++)
            {
                max=Math.max(max,values[i]+values[j]+i-j);
            }
        }
        return max;
    }

    private int betterApproach(int[] values) {
        // Optimized approach O(n)
        int max = 0;
        int maxSoFar = values[0]; // Initial maxSoFar (values[j] + j)

        for (int j = 1; j < values.length; j++) {
            // Calculate the current score
            max = Math.max(max, maxSoFar + values[j] - j);
            // Update maxSoFar for the next iteration
            maxSoFar = Math.max(maxSoFar, values[j] + j);
        }

        return max;
    }

    
    
    public int maxScoreSightseeingPair(int[] values) {
        // return bruteSolve(values);
        return betterApproach(values);
    }
}