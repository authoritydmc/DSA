class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //abs(i-j)<=k we might be having a sliding window problem where we have slide length k
       Set<Integer> s=new HashSet<>();
       int start=0;
       int end=k;

       //init : sliding window fill
       for (int i=0;i<nums.length && i<=end;i++)
       {
        if(s.contains(nums[i]))
        return true;
        s.add(nums[i]);
       }

       //now we increase window 1 by 1 and see if this element exist or not 

       while(++end<nums.length)
       {
        //remove start element .
        s.remove(nums[start++]);
        if(s.contains(nums[end]))
        return true;
        s.add(nums[end]);

       }

       return false;

    }
}