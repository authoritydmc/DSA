class Solution:
    def solve(self,m,n,memo):
        if m==1 or n ==1:
            return 1
        key=f"{m}-{n}"
        if key in memo:
            return memo[key]
        memo[key]=self.solve(m-1,n,memo)+self.solve(m,n-1,memo)
        return memo[key]
        
    def uniquePaths(self, m: int, n: int) -> int:
        
        return self.solve(m,n,{})
        