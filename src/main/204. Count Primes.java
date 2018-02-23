class Solution {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] res = new boolean[n + 1];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (res[i]) {
                continue;
            }
            cnt++;
            for (int j = i; j < n; j += i) {
                res[j] = true;
            }
        }
        return cnt;
    }
}
