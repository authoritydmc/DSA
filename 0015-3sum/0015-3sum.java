class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // first sort the array :::
        List<List<Integer>> lst = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        while (i<n && nums[i] <= 0) {
            // avoid duplicates
            if (i > 0 && nums[i - 1] == nums[i])
            {
                i++;
                continue;

            }
            // System.out.println("For i "+i+ " val "+nums[i]);
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum=nums[i]+nums[l]+nums[r];
                // System.out.println(" l "+l+" r"+r+" sum "+sum);
                //sum is greater we have to reduce so shift r 
                if(r+1<n && nums[r]==nums[r+1])
                {
                    r--;
                    continue;
                }
                if(l-1> i && nums[l]==nums[l-1])
                {
                    l++;
                    continue;
                }
                if(sum==0)
                {
                    //match found insert in result and break;
                    lst.add(List.of(nums[i],nums[l],nums[r]));
                    l++;
                    // r--;
                }
               else if(sum>0)
                {
                    r--;
                }
                else if (sum<0)
                {
                    l++;
                }
                
            }

            i++;
        }

        return lst;

    }
}