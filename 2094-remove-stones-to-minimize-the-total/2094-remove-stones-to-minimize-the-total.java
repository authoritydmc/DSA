class Solution {
    public int minStoneSum(int[] piles, int k) {
        // minimum possible so have max heap ::
        int s = 0;

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : piles) {
            pq.add(n);
            s += n;
        }

        while (k-- > 0) {
            int r = pq.poll();
            int n = r / 2;
            s-=n;
            // System.out.println("replaced "+r+" with "+(r-n));
            pq.add(r - n);

        }

        return s;
    }
}