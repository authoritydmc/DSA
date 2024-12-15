import java.util.*;

class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;

        // Max-heap to always get the largest element
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // Add all numbers to the priority queue
        for (int n : nums) {
            pq.add(n);
        }

    
        while (k-- > 0) {
          
            int largest = pq.poll();
            
          
            score += largest;
            
          
            int reduced = (largest + 2) / 3; // Equivalent to Math.ceil(largest / 3.0)
            
            // Add the reduced value back to the priority queue
            pq.add(reduced);
        }

        return score;
    }
}
