import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        // Step 1: Sort nums to make groups
        int[] sortedNums = nums.clone(); 
        Arrays.sort(sortedNums); 

    

        // Maps to hold group information
        Map<Integer, Integer> grpMap = new HashMap<>();
        Map<Integer, Queue<Integer>> grps = new HashMap<>();
        Queue<Integer> curList = null;

        // Step 2: Grouping logic
        for (int i = 0; i < sortedNums.length; i++) {
            int current = sortedNums[i];

            // Create a new group if needed
            if (curList == null || Math.abs(sortedNums[i-1] - current) > limit) {
                // Sort and finalize the previous group before creating a new one
                if (curList != null) {
                    List<Integer> sortedGroup = new ArrayList<>(curList);
                    Collections.sort(sortedGroup);
                    curList = new ArrayDeque<>(sortedGroup);
                }

                curList = new ArrayDeque<>();
                grps.put(current, curList);
            }

            // Add the current element to the group
            curList.offer(current);

            // Map the current number to the group's first element
            grpMap.put(current, ((ArrayDeque<Integer>) curList).getFirst());
        }

     
   

        // Step 3: Build the result array
        for (int i = 0; i < nums.length; i++) {
            int grpNo = grpMap.get(nums[i]); // Get the group's first element
            nums[i] = grps.get(grpNo).poll(); // Poll the value from the corresponding group
        }

        return nums;
    }

    
}
