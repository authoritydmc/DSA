class Solution {
    public int thirdMax(int[] nums) {
        Queue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        Set<Integer> added=new HashSet<>();

        for(int n:nums)
        {
            if(added.contains(n))
             continue;
            pq.add(n);
            added.add(n);

        }
        
        if(pq.size()<3)
            return pq.peek();
        
        pq.poll();
        pq.poll();
        return pq.poll();
    }
}