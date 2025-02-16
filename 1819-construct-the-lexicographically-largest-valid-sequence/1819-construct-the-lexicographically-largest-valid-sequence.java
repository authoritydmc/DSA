class Solution {

    private boolean backtrack(int n, int i, int[] res, Set<Integer> used) {
         if (i >= res.length)
            return true;
         if (res[i] != -1)
            return backtrack(n, i + 1, res, used);

        for (int j = n; j >= 1; j--) {

            if (used.contains(j))
                continue;

            used.add(j);
            res[i] = j;

            if (j == 1) {
                if (backtrack(n, i + 1, res, used) == true)
                    return true;
            } else {
                int next_ind = i + j;
                if (next_ind < res.length && res[next_ind] == -1) {
                    res[next_ind] = j;

                    if (backtrack(n, i + 1, res, used) == true)
                        return true;

                    res[next_ind] = -1;
                }

            }

            used.remove(j);
            res[i] = -1;

        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        Arrays.fill(res,-1);
        Set<Integer> used = new HashSet<>();
        backtrack(n, 0, res, used);

        return res;
    }
}