class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        int res=0;
        while (pq.size()>1) {
           
                int y=pq.poll();
               
                int x=pq.poll();
                if(x!=y)
                pq.add(y-x);
        }
        if(pq.size()!=0)
        res=pq.poll();
        return res;
    }
}