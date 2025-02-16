class Solution {

    private boolean backtrack(int n, int i, int[] res, boolean[] used) {
        // Base case: if we reach the end of the array
        if (i >= res.length)
            return true;
    
        if (res[i] != -1)
            return backtrack(n, i + 1, res, used);

        // Try placing numbers from n to 1
        for (int j = n; j >= 1; j--) {
            if (used[j]) continue;
            
        
            used[j] = true;
            res[i] = j;
            
            if (j == 1) { 
                if (backtrack(n, i + 1, res, used)) return true;
            } else {
                int next_ind = i + j;
                if (next_ind < res.length && res[next_ind] == -1) {
                    res[next_ind] = j;

                    if (backtrack(n, i + 1, res, used)) return true;

                   
                    res[next_ind] = -1;
                }
            }

           
            res[i] = -1;
            used[j] = false;
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        Arrays.fill(res, -1);  
        boolean[] used = new boolean[n + 1];  
        
        backtrack(n, 0, res, used);
        return res;
    }

   
}
