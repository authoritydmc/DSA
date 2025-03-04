class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false; // If any remainder is 2, we can't represent n as distinct powers of 3
            }
            n /= 3; // Move to the next digit in base 3
        }
        return true;
    }
}
