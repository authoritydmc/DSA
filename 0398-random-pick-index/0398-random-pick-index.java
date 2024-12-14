class Solution {
    Map<Integer,Queue<Integer>> map=new HashMap<>();
    public Solution(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            int n=nums[i];
            map.putIfAbsent(n,new LinkedList<>());
            map.get(n).add(i);
        }  
    }
    
    public int pick(int target) {
        Queue<Integer> lst=map.get(target);
        int random=lst.poll();
        lst.add(random);
        return random;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */