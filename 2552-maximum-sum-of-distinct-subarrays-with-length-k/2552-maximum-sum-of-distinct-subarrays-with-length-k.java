class Solution {
    private void print(String s)
    {
        System.out.println(s);
    }
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;

    
        Map<Integer, Long> freqMap = new HashMap<>();
        boolean reset=false;
        // init the set ==
        long sum = 0;

        for (int i = 0; i < k; i++) {
            int n = nums[i];
            sum += n;
            max = sum;
            freqMap.merge(n,1l,Long::sum);
        }
        if(freqMap.size()!=k)
            max=0;

        // System.out.println("init max " + max+ " k= "+k+" total item "+nums.length);
        for (int i = k; i < nums.length; i++) {
            int rmElement = nums[i - k];
            int n = nums[i];
            freqMap.merge(n,1l,Long::sum);
            sum -= rmElement;
        //    print("item to remove is "+rmElement+" cur sum "+sum+"  cur max "+max+" cur num "+n);

            sum += n;
           long rmfreq= freqMap.merge(rmElement,-1l,Long::sum);
            if(rmfreq==0)
            freqMap.remove(rmElement);
            if ( freqMap.size()==k) {
                // this number is distinct hence only this time update max
                max = Math.max(sum, max);

            }

        }

        return max ;
    }
}