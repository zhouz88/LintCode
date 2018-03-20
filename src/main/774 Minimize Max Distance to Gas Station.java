class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double l = 0.0;
        double r = 100000000;
        for (int i = 0; i < stations.length - 1; i++) {
            r = Math.max(stations[i + 1] - stations[i], r);
        }
        while (r - l >= 1e-7) {
            double mid = (r + l)/2;
            if (check(stations, mid) > K) {
                l = mid;
            } else {
                r = mid; // == K时候 R还要减小。
            }
        }
        return r;
    }

    private int check(int[] stations, double mid) {
        int cnt = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            double len = stations[i + 1] - stations[i];
            //if (len <= mid) continue;
            cnt += (int)Math.ceil(len/mid) - 1;
        }
        return cnt;
    }
}
