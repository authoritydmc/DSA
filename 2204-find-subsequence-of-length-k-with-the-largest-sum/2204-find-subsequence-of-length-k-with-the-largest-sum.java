class Solution {
    private void print(String s)
    {
        System.out.println(s);
    }
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer,Integer> freq=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int n=nums[i];
            pq.add(n);
        }
        
        int [] rslt=new int [k];
        int index=0;
        while(k-->0)
        { 
        freq.merge(pq.poll(),1,Integer::sum);
        }
        for(int n:nums)
        {
            if(freq.containsKey(n))
            {
                //this element is present .. insert it in result ...
                int times=freq.get(n);
                // print(" will use "+n+" times "+times);
             rslt[index++]=n;
             if(times==1)
                freq.remove(n);
            else
            freq.merge(n,-1,Integer::sum);

            }
        }

        return rslt;
    }
}