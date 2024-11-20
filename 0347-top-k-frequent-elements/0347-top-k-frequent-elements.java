class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] rslt=new int [k];
        Map<Integer,Integer> map=new HashMap<>();
        Queue<Integer> q=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int n:nums)
            map.merge(n,1,Integer::sum);

        for(int val:map.keySet())
            q.add(val);

        for(int i=0;i<k;i++)
            rslt[i]=q.poll();



        return rslt;
    }
}