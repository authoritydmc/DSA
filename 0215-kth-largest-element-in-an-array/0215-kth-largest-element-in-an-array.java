class Solution {
    public int findKthLargest(int[] nums, int k) {
        // kth largest using min heap
        Queue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}