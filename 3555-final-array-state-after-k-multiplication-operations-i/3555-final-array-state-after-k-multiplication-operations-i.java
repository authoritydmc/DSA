class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        Queue<int[]> pq = new PriorityQueue<>((a,b)->{
           if(a[0]<b[0])
           return -1;
           if (a[0]>b[0])
           return 1;
           if(a[1]<=b[1])
           return -1;
           else 
           return 1;
        });
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i],i});
        }

        while(k-->0)
        
        {
            int [] n=pq.poll();
            pq.add(new int []{n[0]*multiplier,n[1]});
        }

        while(!pq.isEmpty())
        {
            int [] n=pq.poll();
            res[n[1]]=n[0];
        }

        return res;

    }
}