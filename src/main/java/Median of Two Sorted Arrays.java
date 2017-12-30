/*
4. Median of Two Sorted Arrays
DescriptionHintsSubmissionsDiscussSolution

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) 
            return 0.0;
        
        int m = nums1.length, n = nums2.length;
        
        if ((m + n)%2 == 1) 
            return 1.0*findKth((m+n-1)/2+1, nums1, nums2, 0, 0);
        else 
            return (findKth((m+n-1)/2+1, nums1, nums2, 0, 0) + findKth((m+n-1)/2+2, nums1, nums2, 0, 0))/2.0 ;
    }
    
    private int findKth(int k, int[] nums1, int[] nums2, int startA, int startB) {
        if (startA >= nums1.length)
            return nums2[startB + k - 1];
        
        if (startB >= nums2.length)
            return nums1[startA + k - 1];
        
        if (k == 1) 
            return Math.min(nums1[startA], nums2[startB]);
        
        int A = startA + k/2 - 1 < nums1.length ? nums1[startA + k/2 - 1] : Integer.MAX_VALUE;
        int B = startB + k/2 - 1 < nums2.length ? nums2[startB + k/2 - 1] : Integer.MAX_VALUE;
        
        if (A > B) {
            return findKth(k - k/2, nums1, nums2, startA, startB + k/2);
        } else {
            return findKth(k - k/2, nums1, nums2, startA + k/2, startB);
        }
    }
}
