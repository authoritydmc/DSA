class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        mp=dict()
        mc=0
        for i in range(len(candies)):
            mp[i]=candies[i]+extraCandies
            if candies[i]>mc:
                mc=candies[i]
        return list([v>=mc for k,v in mp.items()] )

        