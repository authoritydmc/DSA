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
        int maxSoFar = values[0]; // Initial maxSoFar (values[i] + i)

        for (int i = 1; i < values.length; i++) {
            // Calculate the current score
            max = Math.max(max, maxSoFar + values[i] - i);
            // Update maxSoFar for the next iteration
            maxSoFar = Math.max(maxSoFar, values[i] + i);
        }

        return max;
    }

    
    
    public int maxScoreSightseeingPair(int[] values) {
        // return bruteSolve(values);
        return betterApproach(values);
    }
}