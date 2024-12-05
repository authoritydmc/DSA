class Solution {
    public boolean canChange(String start, String target) {
              // Check if the characters 'L' and 'R' in both strings are the same
        if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false;
        }
        
        int n = start.length();
        int i = 0, j = 0;
        
        while (i < n && j < n) {
            // Skip blanks in both strings
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            
            // If both pointers reach the end, the transformation is valid
            if (i == n && j == n) {
                return true;
            }
            
            // If one reaches the end but the other doesn't, return false
            if (i == n || j == n) {
                return false;
            }
            
            // The characters at i and j must match
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            
            // Check movement constraints for 'L' and 'R'
            if (start.charAt(i) == 'L' && i < j) { // 'L' cannot move right
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) { // 'R' cannot move left
                return false;
            }
            
            // Move both pointers
            i++;
            j++;
        }
        
        return true;
    }
}