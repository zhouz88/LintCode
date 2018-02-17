import java.util.Arrays;

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        return find(nums, 0, nums.length - 1);
    }
    
    private int find(int[] nums, int l, int r) {
            if (r - l == 1) {
                if (nums[r] ==nums[l]) {
                    return nums[l];
                } else {
                    return -1;
                }
            }
            
            int mid = (l + r)/2;
            
            if (nums[mid] == mid + 1) {
                return Math.max(find(nums, l, mid), find(nums, mid, r));
            } else if (nums[mid] > mid + 1) {
                return find(nums, mid, r);
            } else {
                return find(nums, l, mid);
            }
    }
}

//method 2

import java.util.Arrays;

class Solution { n + 1 个边 less than n个点 不可能有最小生成树，一定有环！// minimum spanning tree must not exist!
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        fast = nums[0];
        
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return fast;
    }
}
