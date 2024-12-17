import java.util.PriorityQueue;

public class Solution {

    public String repeatLimitedString(String s, int repeatLimit) {
        // Frequency array to count occurrences of each character in the string
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max-heap to store characters sorted in lexicographical descending order
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Add all characters with their frequencies to the heap
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.add(new int[]{i, freq[i]}); // {charIndex, frequency}
            }
        }

        StringBuilder result = new StringBuilder();
        int prevChar = -1;  // Track the last appended character index
        int repeatCount = 0; // Track consecutive appearance of a character

        // Build the string while respecting repeatLimit and lexicographical order
        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll(); // Get the largest available character
            int charIndex = current[0];
            int count = current[1];

            if (charIndex == prevChar && repeatCount == repeatLimit) {
                // If we have reached the limit for the previous character:
                if (maxHeap.isEmpty()) {
                    break; // No alternative character available
                }

                // Pick the next largest character as a gap
                int[] next = maxHeap.poll();
                result.append((char) (next[0] + 'a')); // Append the gap character
                next[1]--; // Reduce its frequency
                if (next[1] > 0) {
                    maxHeap.add(next); // Reinsert if it can still be used
                }

                // Put the current character back into the heap
                maxHeap.add(current);

                // Reset consecutive appearance tracking
                prevChar = next[0];
                repeatCount = 1;

            } else {
                // Append the current character
                result.append((char) (charIndex + 'a'));
                count--;

                // Update repeat tracking
                if (charIndex == prevChar) {
                    repeatCount++;
                } else {
                    prevChar = charIndex;
                    repeatCount = 1;
                }

                // If the character still has remaining frequency, reinsert it into the heap
                if (count > 0) {
                    maxHeap.add(new int[]{charIndex, count});
                }
            }
        }

        return result.toString();
    }

}
