import java.util.*;

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Distance array to track minimum costs to each city
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        // Temporary array to store updated distances during each iteration
        int[] tempDistances = Arrays.copyOf(distances, n);

        // Iterate at most k+1 times (0 stops = 1 iteration, 1 stop = 2 iterations, etc.)
        for (int i = 0; i <= k; i++) {
            // Process each flight (edge relaxation)
            for (int[] flight : flights) {
                int u = flight[0]; // Source city
                int v = flight[1]; // Destination city
                int weight = flight[2]; // Cost

                if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < tempDistances[v]) {
                    tempDistances[v] = distances[u] + weight;
                }
            }
            // Update distances array after processing all flights
            distances = Arrays.copyOf(tempDistances, n);
        }

        // If the destination city is unreachable, return -1
        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }

}
