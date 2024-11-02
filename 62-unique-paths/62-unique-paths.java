class Solution {
    
    private int recSolve(int m,int n,HashMap<String,Integer> memo)
    {
        
        
        if(m==0 || n==0)
            return 0;
        else if (m==1 || n==1)
            return 1;
        
        String key=m+"-"+n;
        
        
        if(memo.containsKey(key))
            return memo.get(key);
        int downPath=recSolve(m-1,n,memo);
        int rightPath=recSolve(m,n-1,memo);
        
        memo.put(key,downPath+rightPath);
        return memo.get(key);
        
        
    }
    public int uniquePaths(int m, int n) {
        
        HashMap<String,Integer> memo=new HashMap<>();
        
        
        return recSolve(m,n,memo);
        
    }
}