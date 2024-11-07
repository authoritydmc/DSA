class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s)!=len(t):
            return False
        d={}
        for c in s:
            d[c]=d.get(c,0)+1
        print(d)

        for c in t:
            cnt= d.get(c,0)
            print("consuming ",c,cnt-1)

            if cnt <=0 :
                return False
            d[c]=cnt-1
        return True
        