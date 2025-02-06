import java.util.*;

class Solution {
    public int tupleSameProduct(int[] nums) {
        // Map to store product -> set of unique pairs
        Map<Integer, Set<int[]>> productMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i];
                int b = nums[j];
                int product = a * b;

                // Store the pair in the map
                productMap.putIfAbsent(product, new HashSet<>());
                productMap.get(product).add(new int[]{a, b});
            }
        }

        int totalPermutations = 0;

        // Print all groups and calculate permutations
        for (Map.Entry<Integer, Set<int[]>> entry : productMap.entrySet()) {
            int pairCount = entry.getValue().size(); // Number of pairs for this product
        
            // If there are at least two pairs, calculate permutations
            if (pairCount >= 2) {
                int combinations = (pairCount * (pairCount - 1)) / 2; // Choosing 2 pairs
                int permutations = combinations * 8; // Each selection gives 8 valid tuples
                totalPermutations += permutations;
               
            }
            
        }

      
        return totalPermutations;
    }

  
}
