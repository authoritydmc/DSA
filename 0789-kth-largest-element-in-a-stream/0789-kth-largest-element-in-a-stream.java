class KthLargest {
    Queue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int n : nums)
            add(n);
    }

    public int add(int val) {
        // System.out.println("Adding " + val + " current pq size " + pq.size());
        pq.add(val);
        if (pq.size() > k)
             pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */