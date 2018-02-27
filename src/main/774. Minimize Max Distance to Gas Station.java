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

