class Solution {

    private static final Set<Integer> specialNumbers = Set.of(1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370,
            379, 414, 657, 675, 703, 756, 792, 909, 918, 945, 964, 990, 991, 999, 1000);

    public boolean isSpecialNumber(int n) {
        return specialNumbers.contains(n);
    }

    private boolean checkSpcl(String square, int num, int curSum, int ind) {
        // Base condition: If the sum matches num and we used all digits, it's valid
        if (curSum == num && ind == square.length()) {
            return true;
        }

        // If sum exceeds num or all characters are processed without matching num
        if (curSum > num || ind >= square.length()) {
            return false;
        }

        // Try different partitions of the number string
        for (int j = ind; j < square.length(); j++) {
            String sub = square.substring(ind, j + 1); // Extracting valid substring

         

            int subVal = Integer.parseInt(sub);
            if (checkSpcl(square, num, curSum + subVal, j + 1)) {
                return true; // If valid, return immediately
            }
        }

        return false;
    }

    public int punishmentNumber(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            String sq = String.valueOf(i * i);
            if (checkSpcl(sq, i, 0, 0)) {
                sum += i * i;
            }
        }
        return sum;
    }

}
