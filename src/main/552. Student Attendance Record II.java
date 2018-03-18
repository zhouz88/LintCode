class Solution {
    public int checkRecord(int n) {
        long[] ldp = new long[100001];
        long[] pdp = new long[100001];
        pdp[0] = 1;
        ldp[0] = 0;
        final long MOD = (long) 1e9 + 7L;
        for (int i = 1; i <= 100000; i++) {
            ldp[i] = (pdp[i - 1] + (i >= 2 ? pdp[i - 2] : 0)) % MOD;
            pdp[i] = (ldp[i - 1] + pdp[i - 1]) % MOD;
        }

        long res = (ldp[n] + pdp[n]) % MOD;
        for (int i = 0; i <= n - 1; i++) {
           long t = ((ldp[i] + pdp[i])%MOD) * ((ldp[n - i - 1] + pdp[n - i - 1])%MOD);
           res += t%MOD;
        }
        return (int) (res % MOD);
    }
}
