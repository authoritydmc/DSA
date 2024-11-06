class Solution:

    def solve(self,coins,amount,memo):
        # print("checking for ",amount,memo)
        if amount ==0:
            return 0
        if amount in memo :
            return memo[amount]
        memo[amount]=sys.maxsize
        for coin in coins:
            target=amount-coin
            if target>=0:
                ans=self.solve(coins,target,memo)+1
                memo[amount]=min(ans,memo[amount])
        return memo[amount]

    def coinChange(self, coins: List[int], amount: int) -> int:
        ans= self.solve(coins,amount,{})
        if ans==sys.maxsize:
            return -1 
        
        return ans
        