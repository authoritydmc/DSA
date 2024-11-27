class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0;

        int total = nums1.length + nums2.length;
        double mid = 0.0;
        double mid_1 = 0.0;
        int findTill = (total / 2) ;
        int i = 0;
        int j = 0;
        while (findTill > 0) {
            if (i < nums1.length) {
                if (j < nums2.length) {
                    // we can compare now
                    if (nums1[i] < nums2[j]) {
                        mid = nums1[i];
                        i++;
                    } else {
                        mid = nums2[j];
                        j++;
                    }
                } else {
                    mid = nums1[i];
                    i++;
                }
            } else {
                mid = nums2[j];
                j++;
            }

            findTill--;
        }

        if (i < nums1.length) {
            if (j < nums2.length) {
                mid_1 = nums1[i] < nums2[j] ? nums1[i] : nums2[j];
            } else
                mid_1 = nums1[i];
        } else {
            mid_1 = nums2[j];
        }

        median = total % 2 == 0 ? (mid + mid_1) / 2 : mid_1 / 1;
        // System.out.println(" Mid found as "+mid+" for totak "+total);
        return median;
    }
}