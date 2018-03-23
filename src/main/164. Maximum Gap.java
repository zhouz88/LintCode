import java.math.BigInteger;

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        int min = nums[0];
        int max = nums[0];

        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int gap = (int) (Math.ceil((double)((long)max - (long)min)/(len*1.0 - 1)));
        Node[] buckets = new Node[len - 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min||nums[i] ==max) continue;
            int idx = (nums[i] - min)/gap;
            if (buckets[idx] == null) {
                buckets[idx] = new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
            }
            buckets[idx].minValue = Math.min(buckets[idx].minValue, nums[i]);
            buckets[idx].maxValue = Math.max(buckets[idx].maxValue, nums[i]);
        }
        int pre = min;
        int res = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            res = Math.max(buckets[i].minValue - pre, res);
            pre = buckets[i].maxValue;
        }
        res = Math.max(max - pre, res);
        return res;
    }

    private static class Node {
        int minValue;
        int maxValue;
        public Node(int a, int b) {
            this.maxValue = b;
            this.minValue = a;
        }
    }
}
