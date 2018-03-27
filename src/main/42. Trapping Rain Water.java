class Solution {
    public int trap(int[] height) {
        int L = 0, R = 0;
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                L = Math.max(height[l], L);
                res += L - height[l];
                l++;
            } else {
                R = Math.max(height[r], R);
                res += R - height[r];
                r--;
            }
        }
        return res;
    }
}
