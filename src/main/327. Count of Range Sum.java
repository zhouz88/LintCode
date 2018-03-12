class Solution {
    private int count = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] dp = new long[nums.length + 1];//bug 1  long not int
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = nums[i] + dp[i];
        }
        Node[] nodes = new Node[nums.length + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(dp[i], i);
        }
        mergeSort(nodes, 0, nodes.length - 1, lower, upper);
        return count;
    }

    private void mergeSort(Node[] nodes, int start, int end, int lower, int upper) {
        if (start >= end) {
            return;
        }
        int mid = (end - start)/2 + start;
        mergeSort(nodes, start, mid, lower, upper);
        mergeSort(nodes, mid +  1, end, lower, upper);
        int l = mid + 1, r = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (l <= end && nodes[l].val < nodes[i].val + (long)lower) {
                l++;
            }
            while (r <= end && nodes[r].val <= nodes[i].val + (long)upper) {
                r++;
            }
            count += r - l;
        }
        Node[] array = new Node[end - start + 1];
        int idx = 0;
        l = start;
        r = mid + 1;
        while (l <= mid && r <= end) {
            if (nodes[l].val < nodes[r].val) {
                array[idx++] = nodes[l++];
            } else {
                array[idx++] = nodes[r++];
            }
        }
        while (l <= mid) {
            array[idx++] = nodes[l++];
        }
        while (r <= end) {
            array[idx++] = nodes[r++];
        }
        for (int i = start; i <= end; i++) {
            nodes[i] = array[i - start];
        }
    }

    private static class Node {
        long val;
        int idx;
        public Node(long val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
