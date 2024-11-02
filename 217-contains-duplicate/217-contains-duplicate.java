class Solution {
    public boolean containsDuplicate(int[] nums) {
        
       Map<Integer,Long> res= Arrays.stream(nums).mapToObj(num->(Integer)num)
           .collect(Collectors.groupingBy(num->num,Collectors.counting()));
   
        return res.entrySet().stream().map(Map.Entry::getKey).anyMatch(key->res.get(key)>1);
        
    }
}