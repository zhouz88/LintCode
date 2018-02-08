import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class Solution {
    private int[] nums;
    private Random random;
    private Integer[] idxArray;

    public Solution(int[] nums) {
        this.nums = nums;//wrong 3
        idxArray = new Integer[nums.length];
        for (int i = 0;  i< nums.length; i++) {
            idxArray[i] = i;
        }
        Comparator<Integer> valueComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(nums[o1], nums[o2]);
            }
        };
        random = new Random();
        Arrays.sort(idxArray, valueComparator);
    }

    public int pick(int target) {
        int l = 0, r = nums.length  - 1;
        int mid;
        while (l <= r) {
            mid = ((r - l) /2) + l;
            int midValue = nums[idxArray[mid]];
            if (midValue == target) {
                r = mid - 1;
            } else if (midValue > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        if (l == nums.length || nums[idxArray[l]] != target) {
            return -1;
        }
        
        int L = l, R = nums.length  - 1;
        
        while (L <= R) {
            mid = ((R - L)/2) + L;
            int midValue = nums[idxArray[mid]];
            if (midValue == target) {
                L = mid + 1;
            } else if (midValue > target) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        
        //System.out.println(l + ":" + R);
        int ret = l + random.nextInt(R - l + 1); //wrong 1
        
        return idxArray[ret]; //wrong 2
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */


import java.util.Random;

class Solution {
    private int[] nums;
    private Random random;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int cnt = 0;
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                cnt++;
                if (random.nextInt(cnt) == 0) {
                    ans = i;
                }
            }
        }
        
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
