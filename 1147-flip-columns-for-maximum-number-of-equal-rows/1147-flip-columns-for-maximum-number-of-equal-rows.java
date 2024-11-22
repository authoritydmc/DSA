class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder key = new StringBuilder();
            StringBuilder invkey = new StringBuilder();

            for (int j = 0; j < matrix[0].length; j++) {
                key.append(matrix[i][j]);
                invkey.append(matrix[i][j] == 0 ? 1 : 0);
            }

            map.merge(key.toString(), 1, Integer::sum);
            map.merge(invkey.toString(), 1, Integer::sum);

        }
        int max = 1;
        for (int val : map.values())
            max = Math.max(max, val);

        return max;
    }
}