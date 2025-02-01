class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length==1)
        return true;

        int parity=nums[0]%2;

        for(int i=1;i<nums.length;i++)
        {
            int newPar=nums[i]%2;
            if(parity==newPar)
            return false;
            parity=newPar;
        }


        return true;
    }
}