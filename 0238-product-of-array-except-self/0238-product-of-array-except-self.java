
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] res = new int[nums.length];
        int zeroCount = 0;
        for (int n : nums) {
            if (n == 0)
                zeroCount++;
            else
                product *= n;
        }

        System.out.println("Product is " + product);
        if (zeroCount > 1) {

            return res;
        } else if (zeroCount == 1) {
            // except at zero index ...all other points will be zero....
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    res[i] = product;
                    break;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
              //  System.out.println(product +" divided by "+nums[i]);
                res[i] = product / nums[i];
                

            }
        }

        return res;

    }
}