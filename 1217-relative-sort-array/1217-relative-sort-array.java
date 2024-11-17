import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Step 1: Frequency Map
        Map<Integer, Integer> freq = new TreeMap<>();
        int[] rslt = new int[arr1.length ];
        int ind = 0;

        // Build the frequency map for arr1
        for (int n : arr1) {
            freq.merge(n, 1, Integer::sum);
        }
        System.out.println("Frequency map after processing arr1: " + freq);

        // Step 2: Sorting arr2
  
        System.out.println("arr2 after sorting: " + Arrays.toString(arr2));

        // Step 3: Placing elements of arr2 into rslt
        for (int n : arr2) {
            int in1 = freq.get(n);
            System.out.println("Processing number " + n + " from arr2, frequency: " + in1);

            // rslt[ind++] = n;  // First, place the number itself in the result
            for (int x = 0; x < in1; x++) {
                rslt[ind++] = n;  // Place remaining copies
            }

            freq.remove(n);  // Remove it from the frequency map as it's already placed
            System.out.println("rslt after placing number " + n + ": " + Arrays.toString(rslt));
            System.out.println("Frequency map after removing " + n + ": " + freq);
        }

        // Step 4: Handling remaining elements in freq map
        System.out.println("Remaining frequency map: " + freq);
        for (int n : freq.keySet()) {
            int in1 = freq.get(n);
            System.out.println("Processing remaining number " + n + " with frequency " + in1);

            for (int x = 0; x < in1; x++) {
                rslt[ind++] = n;  // Place remaining elements in rslt
            }

            System.out.println("rslt after adding remaining numbers: " + Arrays.toString(rslt));
        }

        // Step 5: Return the result array
        System.out.println("Final result: " + Arrays.toString(rslt));
        return rslt;
    }
}
