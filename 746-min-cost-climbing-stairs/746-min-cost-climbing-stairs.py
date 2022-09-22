class Solution:
    

    def minCostClimbingStairs(self, cost: List[int]) -> int:
        
        ans=[0]*len(cost)
        
        ans[0]=cost[0]
        ans[1]=cost[1]
        
        for i in range(2,len(cost)):
            cp1=ans[i-1]
            cp2=ans[i-2]
            ans[i]=cost[i]+min(cp1,cp2)
        print(ans)  
        
        return min(ans[-1],ans[-2])
            
        
        
        