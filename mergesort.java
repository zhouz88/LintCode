// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    int max = 0;
    public int solution(int[] nums) {
        long[] dp = new long[nums.length + 1];
        Node[] nodes = new Node[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = nums[i] + dp[i];
        }
        for (int i = 0; i< dp.length; i++) {
            nodes[i]= new Node(dp[i], i);
        }
        mergeSort(nodes, 0, dp.length - 1);
        return max;
    }

    private void mergeSort(Node[] nodes, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end - start)/2 + start;
        mergeSort(nodes, start, mid);
        mergeSort(nodes, mid + 1, end);
        int l = start, r = mid + 1;
        Node[] array = new Node[end - start + 1];
        int idx = 0;
        int j = l, min = Integer.MAX_VALUE;
        while (l <= mid && r <= end) {
            if (nodes[l].val > nodes[r].val) {
                if (min != Integer.MAX_VALUE) max = Math.max(nodes[r].idx - min, max);
                array[idx++] = nodes[r++];
            } else {
                min = Math.min(min, nodes[l].idx);
                array[idx++] = nodes[l++];
            }
        }
        while (l <= mid) {
            array[idx++] = nodes[l++];
        }
        while (r <= end) {
            if (min != Integer.MAX_VALUE) max = Math.max(nodes[r].idx - min, max);
            array[idx++] = nodes[r++];
        }
        for (int i = start; i <= end; i++) {
            nodes[i] = array[i - start];
        }
    }

    private static class Node{
        long val;
        int idx;

        public Node(long val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[]a) {

    }
}
