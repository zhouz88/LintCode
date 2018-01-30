public class Solution {
    /*
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            while (l <= r && nums[l] < k) {
                l++;
            }
            while (l <=r && nums[r] >= k) {
                r--;
            }
            // 2222231  sortcolor2
            // 3122222 this problme
            if (l < r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        return l;
    }

    private void swap(int[] nums, int i, int j)  {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
