class Solution {
    public int largestInteger(int num) {
        Queue<Integer> odds=new LinkedList<>();
        Queue<Integer> evens=new LinkedList<>();
        Queue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int n=num;
        List<Integer> nums=new ArrayList<>();
        while(n>0)
        {
            int rem=n%10;
            nums.add(rem);
            n/=10;
        }
        // System.out.println(" Nums is "+nums);
        for(int j=nums.size()-1;j>=0;j--)
        {
            int index=(nums.size()-j-1)%nums.size();
            int ori_num=nums.get(j);
            pq.add(ori_num);
            if(ori_num%2==0)
            {
                evens.add(index);
            }else
            odds.add(index);
        }

        //System.out.println("Odds "+odds+" evens "+evens);

        int [] res=new int[nums.size()];

        while(!pq.isEmpty())
        {
            int cur_num=pq.poll();
           // System.out.println("cur _ num is "+cur_num);
            if(cur_num%2==0)
            {
                res[evens.poll()]=cur_num;
            }else
            res[odds.poll()]=cur_num;
        }
       // System.out.println("res is "+Arrays.toString(res));
        int final_res=0;
        for(int nq:res)
        {
            final_res=final_res*10+nq;
        }
        return final_res;

    }
}