class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        Arrays.sort(stations);
        double l = 0.0;
        double r = (double)1e8;
        while (r - l >= 1e-6) {
            double mid = (r + l)/2;
            if (check(mid, stations, K)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private boolean check(double D, int[] stations, int K) {
        int sum = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            double d = stations[i + 1] - stations[i];
            if (1.0*d <= D) continue;
            else sum += (int)Math.ceil(d/D) - 1;
        }
        return sum > K;
    }
}
/*
774. Minimize Max Distance to Gas Station
DescriptionHintsSubmissionsDiscussSolution
Pick One
On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.

Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

Return the smallest possible value of D.

Example:

Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000
Note:

stations.length will be an integer in range [10, 2000].
stations[i] will be an integer in range [0, 10^8].
K will be an integer in range [1, 10^6].
Answers within 10^-6 of the true value will be accepted as correct.

*/

