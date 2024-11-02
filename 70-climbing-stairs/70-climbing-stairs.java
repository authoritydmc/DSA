class Solution {
    
    private int recSolve(int n,int [] memo)
    {
          if(n==0)
             return 1;
        else if(n<0)
            return 0;
        if(memo[n]!=-1)
            return memo[n];
        int step1=recSolve(n-1,memo);
        int step2=recSolve(n-2,memo);
        
        memo[n]=step1+step2;
        return memo[n];
    }
    public int climbStairs(int n) {

       
        int  [] memo=new int[n+1];
        
        
        Arrays.fill(memo,-1);
        
        return recSolve(n,memo);
            
        
        
        
        
        
    }
}