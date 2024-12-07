class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> s=new HashSet<>();
        int [] r=new int [2];
        int i=0;
        for(int n:nums)
        {
            if(s.contains(n))
            r[i++]=n;
            s.add(n);
        }
        return r;
    }
}