class Solution {
    public int minStoneSum(int[] piles, int k) {
        //minimum possible so have max heap ::

        Queue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int n:piles)
            pq.add(n);

        while(k-->0)
        {
            int r=pq.poll();
           int n= (int)Math.floor(r/2);
            // System.out.println("replaced "+r+" with "+(r-n));
            pq.add(r-n);
        
        }
        int s=0;
        while(!pq.isEmpty())
        s+=pq.poll();

        return s;
    }
}