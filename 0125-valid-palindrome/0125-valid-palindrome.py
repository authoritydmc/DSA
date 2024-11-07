class Solution:
    def isPalindrome(self, s: str) -> bool:
        start=0
        end=len(s)-1
        s=s.lower()
        als="0123456789abcdefghijklmnopqrstuvwxyz"
        while start<end:
            while start< len(s)  and s[start] not in als:
                start+=1
            while end >0 and  s[end] not in  als:
                end-=1
            if start>=end:
                return True
            sc=s[start]
            ec=s[end]
            print("compare" ,sc,ec)
            if sc!=ec:
                return False
            end-=1
            start+=1
        return True
            
        