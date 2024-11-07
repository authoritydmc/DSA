class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        bp=0
        mp=0
        least=9999999999
        for price in prices:
            if price<least:
                least=price
            pft=price-least
            if pft>0:
                least=price
                mp+=pft

        return mp

        