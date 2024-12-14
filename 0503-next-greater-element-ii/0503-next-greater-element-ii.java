class Solution {
    private void solveMono(int[] nums,int [] res,Stack<Integer> stack) {
        int index = nums.length - 1;
        // now use simple monotonoic stack ::
        while (index >= 0)
        {
            int n = nums[index];
            if (stack.isEmpty()) {
                // get the data from previous set value :::
                res[index] = -1;
            } else {
                int top = stack.peek();

                while (n >= top) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        top = -1;
                        break;
                    }
                    top = stack.peek();
                }
                res[index] = top;
            }
            stack.push(n);

            index--;
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        // return solveBrute(nums);
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

         solveMono(nums,res,stack);
         solveMono(nums,res,stack);

         return res;
    }

    private int[] solveBrute(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int curr=nums[i];
            int nge=-1;
            for(int j=1;j<n;j++)
            {
                int index=(i+j)%n;
                if(nums[index]>curr)
                {
                    nge=nums[index];
                    break;
                }
            }
            res[i]=nge;
        }

        return res;
    }
}