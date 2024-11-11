class Solution {
    public int minimumOperations(int[] nums) {
        int rslt=0;
        for(int n:nums)
        {
            if(n%3!=0)
            {
                
                 rslt+=1;
            }
        }
        return rslt;
    }
}