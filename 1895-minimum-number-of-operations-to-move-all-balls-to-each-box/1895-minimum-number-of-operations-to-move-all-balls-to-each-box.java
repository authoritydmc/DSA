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

    public int[] minOperations(String boxes) {
        return solveBrute(boxes.toCharArray());
    }
}