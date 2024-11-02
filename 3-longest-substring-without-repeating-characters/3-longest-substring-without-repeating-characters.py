class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        c={}
        i,j=0,0
        maxC=0
        # print("String==== ",''.join([str(k) for k in range(len(s))]))
        # print("String==== ",s)

        while(j<len(s)):
            # add to dict
            # print(":===>For J=",j)
            # print("Sliding Window: ",s[i:j+1])
            c[s[j]]=c.get(s[j],0)+1
            # total element now
            ele=j-i+1

            if ele==len(c):
                # all unique characters

                maxC=max(maxC,ele)
                # print(" Elements are unique updated maxC",maxC)
            else:
                # some duplicate characters 
                # print(" Element are not unique at j=",j, " elemenet size now ",ele, "dict =",len(c))
                elep=j-i+1
                while elep>len(c):
                    # remove 
                    # print(" I is at ",i)
                    # print("Sliding window ",s[i:j+1])
                    cnt=c.get(s[i],0)
                    # print("count of ",s[i]," is ",cnt)
                    if cnt==1:
                        c.pop(s[i])
                        # print("removing ",s[i]," from dict")
                    else:
                        c[s[i]]=cnt-1
                        # print("decreasing cnt of ",s[i]," to ",c.get(s[i]))
                    # print(f"removing {s[i]} from dict {c}: its count before: {cnt} now :{c.get(s[i])} len ={len(c)}")

                    i+=1
                    elep=j-i+1
            j+=1
            
            
        # print(c)
        return maxC