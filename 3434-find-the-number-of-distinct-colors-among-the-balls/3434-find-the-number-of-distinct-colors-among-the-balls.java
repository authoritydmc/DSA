class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColorMap = new HashMap<>();
        // Set to track the distinct colors in use
        Map<Integer, Integer> colorFrequency = new HashMap<>();
        // Result array
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0]; // Ball index
            int color = queries[i][1]; // Assigned color

            // If ball already has a color, remove previous color
            if (ballColorMap.containsKey(ball)) {
                int prevColor = ballColorMap.get(ball);
                // Decrease the frequency of the previous color
                colorFrequency.put(prevColor, colorFrequency.get(prevColor) - 1);
                // Remove color from set if no ball has it anymore
                if (colorFrequency.get(prevColor) == 0) {
                    colorFrequency.remove(prevColor);
                }
            }

            // Assign the new color to the ball
            ballColorMap.put(ball, color);
            // Increase the frequency of the new color
            colorFrequency.put(color, colorFrequency.getOrDefault(color, 0) + 1);

            // Store the number of distinct colors
            result[i] = colorFrequency.size();
        }

        return result;
    }
}