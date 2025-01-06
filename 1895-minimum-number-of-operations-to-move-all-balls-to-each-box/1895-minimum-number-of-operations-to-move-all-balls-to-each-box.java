class Solution {
    private int[] solveBrute(char[] boxes) {
        int n = boxes.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (boxes[j] == '1') {
                    cnt += Math.abs(j - i);
                }
            }
            res[i] = cnt;
        }

        return res;
    }

    private int[] optimal(char[] boxes) {
        int n = boxes.length;
        int[] res = new int[n];

        // Left pass: Calculate moves to bring '1's from left to each index
        int leftMoves = 0, leftCount = 0;
        for (int i = 0; i < n; i++) {
            res[i] = leftMoves;
            if (boxes[i] == '1') {
                leftCount++;
            }
            leftMoves += leftCount;
        }

        // Right pass: Calculate moves to bring '1's from right to each index
        int rightMoves = 0, rightCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            res[i] += rightMoves;
            if (boxes[i] == '1') {
                rightCount++;
            }
            rightMoves += rightCount;
        }

        return res;
    }

    public int[] minOperations(String boxes) {
        // return solveBrute(boxes.toCharArray());
        return optimal(boxes.toCharArray());
    }
}