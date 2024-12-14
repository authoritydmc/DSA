class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] res=new int[nums1.length];
        Map<Integer,Integer> indexMap=new HashMap<>();
        for(int i=0;i<nums2.length;i++)
        {
            indexMap.put(nums2[i],i);
        }

        for(int i=0;i<nums1.length;i++)
        {
            int nextMax=-1;
            int n=nums1[i];
            for(int j=indexMap.get(n)+1;j<nums2.length;j++)
            {
                if(nums2[j]>n)
                    {
                        nextMax=nums2[j];
                        break;
                    }
            }
            res[i]=nextMax;
        }
        return res;
    }
}