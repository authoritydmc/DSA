class Solution {
    private int getDigitSum(int num) {
        int sum = 0;

        while (num > 0) {
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }

        return sum;
    }

    private void addToVault(Map<Integer, PriorityQueue<Integer>> vault, int ds, int num) {
        vault.putIfAbsent(ds, new PriorityQueue<>());
        PriorityQueue<Integer> pq = vault.get(ds);
        pq.offer(num);
        if (pq.size() > 2)
            pq.poll();

    }

    public int maximumSum(int[] nums) {

        Map<Integer, PriorityQueue<Integer>> vault = new HashMap<>();

        for (int n : nums) {
            int ds = getDigitSum(n);
            // System.out.println("Digit sum of "+n+" is "+ds);
            addToVault(vault, ds, n);
        }

        int biggest = -1;
        for(PriorityQueue<Integer> pq:vault.values())
        {
            if(pq.size()<2)
            continue;
            int total=0;
            while(!pq.isEmpty())
            total+=pq.poll();
            biggest=Math.max(biggest,total);
        }
        return biggest;
    }
}