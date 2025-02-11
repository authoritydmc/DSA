
class Solution {

    public String removeOccurrences(String s, String part) {
        // Precompute the Longest Prefix Suffix (LPS) array for the pattern "part"
        int[] lps = computeLPS(part);

        // Create a stack to build the final string; each element is an array containing:
        // [0] -> the character (as an int) and [1] -> the current length of matched pattern (pstart)
        Stack<int[]> stack = new Stack<>();

       
        int matched = 0;

       
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If there's a mismatch, fallback using the LPS array until either:
            // - matched becomes zero, or
            // - we find a prefix that can be extended by the current character
            while (matched > 0 && c != part.charAt(matched)) {
                matched = lps[matched - 1];
            }

            // If the current character matches the expected character in "part",
            // then we extend the current match
            if (c == part.charAt(matched)) {
                matched++;
            }

            // Push the current character along with the updated match length onto the stack
            stack.push(new int[] { c, matched });

            // If we have a complete match of the substring "part"
            if (matched == part.length()) {
                for (int j = 0; j < part.length(); j++) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    matched = 0;
                } else {
                    matched = stack.peek()[1];
                }
            }
        }

        
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = (char) stack.pop()[0];
        }
        
        return new String(result);
    }

    // Helper method to compute the Longest Prefix Suffix (LPS) array for KMP algorithm
    private int[] computeLPS(String pattern) {
        int n = pattern.length();
     
        int[] lps = new int[n];
      
        int len = 0;
        lps[0] = 0;
        int i = 1;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
