public class Solution {
    /*
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // write your code here
        double l = Double.POSITIVE_INFINITY;
        double r = Double.NEGATIVE_INFINITY;
        for (int t : nums) {
            l = Math.min(l, t);
            r = Math.max(r, t);
        }
        while (r - l > 0.000001) {
            double mid = (l + r)/2;
            if (ok(nums, k, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }
    
    private boolean ok(int[] A, int k, double target) {
        double[] sum = new double[A.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = (A[i - 1] - target) + sum[i - 1];
        }
        double min = Double.POSITIVE_INFINITY;
        for (int i = k; i < sum.length; i++) {
            min = Math.min(min, sum[i - k]);
            if (sum[i] - min >= 0.0) return true;
        }
        return false;
    }
}
