class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] stk = new int[heights.length + 1];
        int idx = 0;
        stk[0] = -1;
        int max = -1;
        for (int i = 0; i < heights.length; i++) {
            while (idx != 0 && heights[stk[idx]] > heights[i]) {
                int tmp = stk[idx--];
                max = Math.max(max, heights[tmp] * (i - stk[idx] - 1));
            }
            stk[++idx] = i;
        }
        while (idx != 0) {
            int tmp = stk[idx--];
            max = Math.max(max, heights[tmp] * (heights.length - stk[idx] - 1));
        }
        return max;
    }
}
