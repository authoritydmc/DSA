class Solution {

    public int[] pivotArray(int[] nums, int pivot) {
        int cnt = 0;

        Queue<Integer> lq = new LinkedList<>();
        Queue<Integer> rq = new LinkedList<>();

        for(int n:nums)
        {
            if(n<pivot)
            lq.offer(n);
            else if(n>pivot)
            rq.offer(n);
            else
            cnt++;
        }

        int start = 0;

        while (!lq.isEmpty())
            nums[start++] = lq.poll();

        while (cnt-- > 0)
            nums[start++] = pivot;

        while (!rq.isEmpty())
            nums[start++] = rq.poll();
        return nums;
    }
}