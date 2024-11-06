class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int n:nums)
        {
            map.merge(n,1,Integer::sum);
        }

   return     map.entrySet()
            .stream()
                .max(Map.Entry.comparingByValue()).get().getKey();
    }
}