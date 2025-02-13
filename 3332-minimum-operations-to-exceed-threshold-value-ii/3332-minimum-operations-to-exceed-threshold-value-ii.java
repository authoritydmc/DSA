class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();

        for(long n:nums)
        pq.offer(n);

        int ops=0;

        while(pq.peek()<k)
        {
            long a=pq.poll();
            long b=pq.poll();
            long c=Math.min(a,b)*2+Math.max(a,b);
            pq.offer(c);
            ops++;
        }

        return ops;
    }
}