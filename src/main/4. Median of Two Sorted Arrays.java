class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 0) {
            return 1.0 * (findKth(nums1, nums2, (m + n)/2, m, n) + findKth(nums1, nums2, (m + n)/2 + 1, m, n))/2;
        } else {
            return 1.0 * findKth(nums1, nums2, (m + n + 1)/2, m, n);
        }
    }

    private int findKth(int[] nums1, int[] nums2, int k, int m, int n) {
        int l = 0, r = 0;
        
        while (true) {
            if (l == m) {
                return nums2[r + k - 1];
            }
            
            if (r == n) {
                return nums1[l + k - 1];
            }
            
            if (k == 1) {
                return Math.min(nums1[l], nums2[r]);
            }
            
            int first = l + k/2 - 1;
            int second = r + k/2 - 1;
            
            if (first < m && second < n) {
                if (nums1[first] < nums2[second]) {
                    l = l + k/2;
                } else {
                    r = r + k/2;
                }
            } else if (first < m) {
                l = l + k/2;
            } else {
                r = r + k/2;
            }
            
            k -= k/2;
        }
        
    }
}
