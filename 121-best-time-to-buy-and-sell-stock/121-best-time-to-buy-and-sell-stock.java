class Solution {
    public int maxProfit(int[] prices) {
        
        
        int bstProfit=Integer.MIN_VALUE;
        
        int cur_profit=Integer.MIN_VALUE;
        
        int min_stock=Integer.MAX_VALUE;
        
        
        
        for(int i=0;i<prices.length;i++)
        {
            
            
            if(min_stock>prices[i])
                min_stock=prices[i];
            
            cur_profit=prices[i]-min_stock;
            
            bstProfit=Math.max(bstProfit,cur_profit);
            
        }
        
        return bstProfit;
        
    }
}