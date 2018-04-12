class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = 0, r = 0;
        Integer  pre = null;
        int max = Integer.MIN_VALUE;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] < nums2[r]) {
                if (pre != null) {
                    max = Math.max(nums1[l] - pre, max);
                }
                pre = nums1[l++];
            } else {
                if (pre != null) {
                    max = Math.max(nums2[r] - pre, max);
                }
                pre = nums2[r++];
            }
        }
        while (l < nums1.length) {
            if (pre != null) {
                max = Math.max(nums1[l] - pre, max);
            }
            pre = nums1[l++];
        }
        while (r < nums2.length) {
            if (pre != null) {
                max = Math.max(nums2[r] - pre, max);
            }
            pre = nums2[r++];
        }
        return max;
    }
}
