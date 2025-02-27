class Solution {
    int maxLength = 0;
    Map<Integer, Integer> map;
    int[][] memo;

    private int recursive(int[] arr, int i, int j) {
        if(memo[i][j]!=-1)
        return memo[i][j];
        if (i >= arr.length || j >= arr.length)
            return 0;
        int length = 0;
        int n = arr[i] + arr[j];
        if (map.containsKey(n))
            length += 1 + recursive(arr, j, map.get(n));
        memo[i][j]=length;

        maxLength = Math.max(length, maxLength);
        return length;
    }

    public int lenLongestFibSubseq(int[] arr) {
        map = new HashMap<>();
        memo = new int[arr.length][arr.length];
        for (int [] a : memo)
            Arrays.fill(a, -1);
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], i);

        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                recursive(arr, i, j);
        return maxLength == 0 ? 0 : maxLength + 2;
    }
}