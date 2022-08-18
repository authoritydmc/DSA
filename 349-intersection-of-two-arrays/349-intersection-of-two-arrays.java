class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        int i=0;
        int j=0;
        int n1=0;
        int n2=0;
        int cnt=0;
        HashSet<Integer> set=new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<nums1.length && j<nums2.length)
        {
            
            n1=nums1[i++];
                         
       
            while(nums2[j]<n1 && j<nums2.length-1)
            {
   
                j++;
            }
                     n2=nums2[j];
                if(n1==n2)
                    set.add(n1);
            
        }
                int [] ans=new int [set.size()];

        for(Integer m:set)
            ans[cnt++]=m;
        return  ans;
        
    }
}