import java.util.Arrays;

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i  < nums.length - 1; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int total = nums[i] + nums[l] + nums[r];
                if (total < target) {
                    cnt += r - l;
                    l++;
                } else if (total >= target) {
                    r--;
                } 
            }
        }
        return cnt;
   
  }
}

/*
259. 3Sum Smaller
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?
*/

import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        //2sum smaller than 0;
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 2; i < nums.length; i++) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    cnt += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return cnt;
    }
}

611. Valid Triangle Number
