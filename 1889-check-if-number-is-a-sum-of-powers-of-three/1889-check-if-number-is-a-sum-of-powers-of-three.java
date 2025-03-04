import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean checkPowersOfThree(int n) {
        // Generate all powers of 3 up to n
        List<Integer> powers = new ArrayList<>();
        int power = 1;
        while (power <= n) {
            powers.add(power);
            power *= 3;
        }
        return backtrack(n, 0, powers);
    }
    
    private boolean backtrack(int target, int index, List<Integer> powers) {
        if (target == 0) {
            return true;
        }
        if (index >= powers.size() || target < 0) {
            return false;
        }
        if (backtrack(target - powers.get(index), index + 1, powers)) {
            return true;
        }
        
        return backtrack(target, index + 1, powers);
    }
}
