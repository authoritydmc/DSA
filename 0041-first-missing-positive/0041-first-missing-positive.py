class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        s=set()
        m=0
        for n in nums:
            s.add(n)
            if n>m:
                m=n

        for i in range(1,m):
            if i not in s:
                return i
        return m+1
        