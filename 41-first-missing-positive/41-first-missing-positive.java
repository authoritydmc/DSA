class Solution {
    public int firstMissingPositive(int[] nums) {
        
        HashSet<Integer> set=new HashSet<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int num:nums)
        {
            set.add(num);
            if(num>max)
                max=num;
            if(num<min)
                min=num;
        }
        System.out.println(set);
       
        if (max<1)
            return 1;
        
        for(int i=1;i<max;i++)
        {
            if(!set.contains(i))
                return i;
        }
           return max+1;
        }
 
    
    
}