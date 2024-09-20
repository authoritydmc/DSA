class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        ml=len(flowerbed)-1
        for k in range(0,ml+1):
            # print(f"k={k} and flowerbed is {flowerbed}")
            if flowerbed[k]==0:
                # print("current pos can be candidate to plant flower checking ...")
                if k>0 and flowerbed[k-1]!=1 or k==0:
                    if k<ml and flowerbed[k+1]!=1 or k==ml:
                        flowerbed[k]=1
                        # print("placed a flower at ",k,"now bed is ",flowerbed)
                        n-=1

        return n<=0

        
'''
Okay:
simply loop through the array and when found 0 try to place a plant if previous is 0 so essentialy all 000 become 010
'''
