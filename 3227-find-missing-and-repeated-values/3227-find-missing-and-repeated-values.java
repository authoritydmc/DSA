class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int [] res = new int[2];
        int n = grid.length;
        Set<Integer> exist = new HashSet<>();
      

        for (int[] m : grid) {
            for (int k : m) {
                if (exist.contains(k))
                    res[0] = k;
                exist.add(k);
            }
        }

          for (int i = 1; i <= n * n; i++) {
            if(!exist.contains(i))
            {
                res[1]=i;
                break;
            }
        }

        return res;
    }
}