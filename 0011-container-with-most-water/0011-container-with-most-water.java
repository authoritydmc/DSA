class Solution {
    public int maxArea(int[] height) {
       
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

 
        while (left < right) {
            
            int currentArea = (right - left) * Math.min(height[left], height[right]);

           
            maxArea = Math.max(maxArea, currentArea);

            
            // System.out.println("left: " + left + ", right: " + right + 
            //                    ", height[left]: " + height[left] + ", height[right]: " + height[right] + 
            //                    ", currentArea: " + currentArea + ", maxArea: " + maxArea);

            
            if (height[left] < height[right]) {
                left++;  
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
