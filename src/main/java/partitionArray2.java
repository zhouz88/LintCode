public class Solution {
    /*
     * @param nums: an integer array
     * @param low: An integer
     http://www.lintcode.com/en/problem/partition-array-ii/
     * @param high: An integer
     * @return: 
     */
    public void partition2(int[] nums, int low, int high) {
        // write your code here
        sortLeft(nums, low);//<=r
        sortRight(nums, high);
    }
    
    private int sortLeft(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        
        while (l <= r) {
            while (l <= r && nums[l] <= k) {
                l++;
            }
            while (l <= r && nums[r] > k) {
                r--;
            }
            if (l <= r) {
                swap(nums, l, r);
            }
            l++;
            r--;
        }
        return r;
    }

    private int sortRight(int[] nums, int k) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            while (l <= r && nums[l] < k) {
                l++;
            }
            while (l <= r && nums[r] >= k) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
            }
            l++;
            r--;
        }
        return r+1;
    }
    
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
