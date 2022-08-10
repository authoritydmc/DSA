# 567. Permutation in String
# https://leetcode.com/problems/permutation-in-string/


class Solution:
    def match(self,s1:dict,s2:dict):
        print("checking ",s2)
        for k,v in s1.items():
            if s2.get(k,-1)!=v:
                return False
        return True


    def checkInclusion(self, s1: str, s2: str) -> bool:
        print()
        hashMap={}
        map_s1={k:s1.count(k) for k in s1}
        k=len(s1)
        match_str=[k for k in s2]
        fast,slow=0,0
        # print(match_str)
        # sliding window
        if k > len(match_str):
            return False



        for i in range(k):
            hashMap[match_str[i]]=hashMap.get(match_str[i],0)+1
            fast+=1

        t=self.match(map_s1,hashMap)

        if t:
            return True

        # now its time to move window and 

        while fast<len(match_str):
            # added next char to hashmap
            hashMap[match_str[fast]]=hashMap.get(match_str[fast],0)+1
            # remove last slow one
            hashMap[match_str[slow]]=hashMap.get(match_str[slow],0)-1
            # compare  hashmap now 

            if self.match(map_s1,hashMap):
                return True
            # move pointers

            fast+=1
            slow+=1
        
        return False



# q=[["ab","eidbaooo"],["ab","eidboaoo"],["ab","a"]]

# s=Solution()
# for j in q:
#     print("*"*90)
#     print("For ",j[1])
#     print(s.checkInclusion(j[0],j[1]))




