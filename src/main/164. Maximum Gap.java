class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int k : nums) {
            min = Math.min(k, min);
            max = Math.max(k, max);
        }
        int gap = (int) Math.ceil((1.0*max - 1.0*min)/(n - 1.0));
        Bucket[] buckets = new Bucket[n - 1];
        for (int num : nums) {
            if (num == min || num == max) continue;
            int idx = (num - min)/gap;
            if (buckets[idx] == null) {
                buckets[idx] = new Bucket(Integer.MAX_VALUE, Integer.MIN_VALUE);
            }
            buckets[idx].max = Math.max(buckets[idx].max, num);
            buckets[idx].min = Math.min(buckets[idx].min, num);
        }
        int pre = min;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            res = Math.max(res, buckets[i].min - pre);
            pre = buckets[i].max;
        }
        res = Math.max(res, max - pre);
        return res;
    }
    
    private static class Bucket{
        int min;
        int max;
        private Bucket(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
