无序数组的题目如果要O(n)解法往往要用到hash table，但这题要求constant space。所以可以用数组本身作为一个"hash table"：A[0] = 1, A[1] = 2, .... A[n-1] = n。目标是尽可能将数字i放到数组第i-1个位置。

扫描数组中每个数：
1. 如果A[i]<1或者A[i]>n。说明A[i]一定不是first missing positive。跳过
2. 如果A[i] = i+1，说明A[i]已经在正确的位置，跳过
3. 如果A[i]!=i+1，且0<A[i]<=n，应当将A[i]放到A[A[i]-1]的位置，所以可以交换两数。
这里注意，当A[i] = A[A[i]-1]时会陷入死循环。这种情况下直接跳过。
//two pointers
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] > n) {
                i++;
            } else {
                int rightLocation = nums[i] - 1;
                if (rightLocation == i || nums[rightLocation] == nums[i]) {
                    i++;
                } else {
                    swap(nums, i, rightLocation);
                }
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int rightLocation) {
        int tmp = nums[i];
        nums[i] = nums[rightLocation];
        nums[rightLocation] = tmp;
    }
}
