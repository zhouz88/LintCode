public class Solution {
    public int splitArray(int[] nums, int m) {
        double l = 0.0;
        double r = 21474800000.0;
        for (int num: nums) {
            l = Math.max(num, l);
        }
        while (r - l >= 0.0001) {
            double mid = (r + l)/2;
            if (check(nums, mid, m) == -1) {
                l = mid;
            } else if (check(nums, mid, m) == 1) {
                r = mid;
            } else {
                r = mid;
            }
        }
        return (int)(l + 0.5);
    }

    private int check(int[] nums, double mid, int m) {
        double cur = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (cur > mid) {
                cur = nums[i];
                cnt++;
            }
            if (cnt > m) {
                return -1;
            }
        }
        if (cur != 0) {
            cnt++;
        }
        if (cnt > m) {
            return -1;
        }
        if (cnt == m) {
            return 0;
        }
        return 1;
    }
}
