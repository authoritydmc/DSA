class Solution {
    public long findScore(int[] nums) {
        boolean[] marked = new boolean[nums.length];
        Map<Integer, Queue<Integer>> indexMap = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            indexMap.putIfAbsent(n, new LinkedList<>());
            indexMap.get(n).add(i);
            pq.add(n);
        }

        long score = 0;
        while (!pq.isEmpty()) {

            int smallest = pq.poll();
            int index = indexMap.get(smallest).poll();
            if (marked[index] == true)
                continue;
            score += smallest;
            marked[index] = true;
            if (index > 0)
                marked[index - 1] = true;
            if (index + 1 < nums.length)
                marked[index + 1] = true;
            // System.out.println("Smallest is "+smallest+" its indx is "+index + " current score is "+score);

            // System.out.println(Arrays.toString(marked));
        }

        return score;

    }
}