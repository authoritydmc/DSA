class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int first = 0;
        int last = 0;
        Map<Integer,Integer> frq=new HashMap<>();

        // initialise the window
        List<Integer> rslt = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int n = nums[i];
            max = Math.max(max, n);
            first++;
            frq.merge(n,1,Integer::sum);
        }
        rslt.add(max);
        while (first < nums.length) {
                int n=nums[first];
                int removed=nums[last];
                int rmCnt=frq.get(removed);
                //remove the last pointed element 
                if(removed==max && n<removed && rmCnt<=1)
                {
                    max=Integer.MIN_VALUE;
                    //we have removed max ..hence we have to find new max ...go back k steps 
                    for(int i=first-1;i>last;i--)
                        max=Math.max(max,nums[i]);
                }
                max=Math.max(max,n);
                frq.merge(n,1,Integer::sum);
                frq.merge(removed,-1,Integer::sum);
                rslt.add(max);
                first++;
                last++;
        }

        return rslt.stream().mapToInt(Integer::intValue).toArray();
    }
}