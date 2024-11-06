class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        writeIndex=0
        count=1
        for i in range(1,len(nums)):
            if  nums[writeIndex]!=nums[i]:
                count=1
                writeIndex+=1
                nums[writeIndex]=nums[i]
            elif count<2:
                count+=1
                writeIndex+=1
                nums[writeIndex]=nums[i]
        print(writeIndex)
        return writeIndex+1

        