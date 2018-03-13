class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int l = 0, r = nums.length - 1;
        int[] res = new int[nums.length];
        int idx = a >= 0 ? res.length - 1 : 0;

        while (l <= r) {
            int A = f(nums[l], a, b, c);
            int B = f(nums[r], a, b, c);
            if (a >= 0) {
                if (A >=  B) {
                    res[idx--] = A;
                    l++;
                } else {
                    res[idx--] = B;
                    r--;
                }
            } else {
                if (A >= B) {
                    res[idx++] = B;
                    r--;
                } else {
                    res[idx++] = A;
                    l++;
                }
            }
        }
        return res;
    }

    private int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
