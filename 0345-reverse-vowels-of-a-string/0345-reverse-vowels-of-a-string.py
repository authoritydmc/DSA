class Solution:
    def reverseVowels(self, s: str) -> str:
        start=0
        end=len(s)-1
        vowels="aeiouAEIOU"
        res=list(s)
        while start<=end:
            if s[start] in vowels and s[end] in vowels:
                res[start]=s[end]
                res[end]=s[start]
                start+=1
                end-=1
            elif s[start] in vowels and s[end] not in vowels:
                end-=1
            elif s[start] not in vowels and s[end] in vowels:
                start+=1
            elif s[start] not in vowels and s[end] not in vowels:
                res[start]=s[start]
                res[end]=s[end]
                start+=1
                end-=1
        return "".join(res)


        