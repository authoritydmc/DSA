class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        cnt=0
        l=len(s)-1
        while(l>=0 and s[l]==' '):
            l-=1
        while(l>=0 and s[l]!=' '):
            l-=1
            cnt+=1
        return cnt
