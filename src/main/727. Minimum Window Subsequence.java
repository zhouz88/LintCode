import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String minWindow(String S, String T) {
        int m = S.length(), n = T.length();
        int[] dp = new int[m];
        int[] starts = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int i, j;
        for (i = 0; i < m; i++) {
            if (S.charAt(i) == T.charAt(0)) {
                dp[i] = 1;
                starts[i] = i;
            }
        }
        for (j = 1; j < n; j++) {
            int[] ndp = new int[m];
            int[] nstarts = new int[m];
            Arrays.fill(ndp, Integer.MAX_VALUE);
            for (i = 0; i < m; i++) {
                if (dp[i] != Integer.MAX_VALUE) {
                    for (int k = i + 1; k < m; k++) {
                        if (S.charAt(k) == T.charAt(j)) {
                            ndp[k] = dp[i] + k - i;
                            nstarts[k] = starts[i];
                            break;
                        }
                    }
                }
            }
            dp = ndp;
            starts = nstarts;
        }

        int minIDx = 0;

        for (i = 1; i < m; i++) {
            if (dp[minIDx] > dp[i]) {
                minIDx = i;
            }
        }

        if (dp[minIDx] == Integer.MAX_VALUE) return "";
        return S.substring(starts[minIDx], minIDx + 1);
    }
}
