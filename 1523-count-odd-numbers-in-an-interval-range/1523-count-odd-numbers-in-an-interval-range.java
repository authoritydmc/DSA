class Solution {
    public int countOdds(int low, int high) {
        
        
//         int start=low%2==0?low+1:low;
//         for(int i=start;i<=high;i+=2)
//         {
            
//         }
        int s=high-low;
        
        if(low%2==0 &&high%2==0)
        {
            return s/2;
            
            
        }else if(high%2!=0)
            return s/2+1;
        else
            return s/2+1;
        
       
    }
}