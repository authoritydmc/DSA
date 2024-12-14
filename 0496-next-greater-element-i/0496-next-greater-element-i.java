class Solution {
    private int[] solveMonotonic(int[] nums1, int[] nums2) {
        Map<Integer, Integer> monoMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        // for next greater element we use decreasing mono stack ..i.e
        // item at peek should be either less than or equal to current element , else
        // pop the item and put that as result
        // if no item in stack then result is -1 and put the item ::

        // also go from right to left

        int index = nums2.length - 1;
        while (index >= 0) {
            int n = nums2[index];

            if (stack.isEmpty()) {
                monoMap.put(n, -1);
            } else {
                // stack is not empty...
                int top = stack.peek();
                // current top cant be > current nums hence pop it and find the next greater
                // item
                while (n > top) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        top=-1;
                        break;
                    } 
                    top=stack.peek();
                } 
                monoMap.put(n,top);
            }
            stack.push(n);

            index--;
        }

        // System.out.println(Arrays.toString(monores));
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = monoMap.get(nums1[i]);
        }

        return res;
    }

    private int[] solveBrute(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int nextMax = -1;
            int n = nums1[i];
            for (int j = indexMap.get(n) + 1; j < nums2.length; j++) {
                if (nums2[j] > n) {
                    nextMax = nums2[j];
                    break;
                }
            }
            res[i] = nextMax;
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // return solveBrute(nums1,nums2);
        return solveMonotonic(nums1, nums2);
    }
}