class Solution {
    int first=-1;
    int second=-1;
    int index=-1;
    public int dominantIndex(int[] nums) {
        
        for (int i=0;i<nums.length;i++)
        {

            int num=nums[i];
            if(num>first)
            {
                second=first;
                first=num;
                index=i;
            }
            if(num>second && num <first)
            second=num;
        }
        System.out.println(first+" "+second);
        if(first-second>=second)
        return index;
        return -1;
    }
}