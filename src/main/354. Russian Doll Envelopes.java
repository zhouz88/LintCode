import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? Integer.compare(o1[1], o2[1])
                        : Integer.compare(o1[0], o2[0]);
            }
        });

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int max = 1;
        int i, j;
        for (i = 1; i < envelopes.length; i++) {
            for (j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

//nlog(n);
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? Integer.compare(o2[1], o1[1])
                        : Integer.compare(o1[0], o2[0]);
            }
        });

        int[] dp = new int[envelopes.length];
        int len = 1;
        dp[0] = envelopes[0][1];
        
        for (int i = 1; i < envelopes.length; i++) {
            int l = search(dp, envelopes[i][1], len);
            dp[l] = envelopes[i][1];
            if (l == len) {
                len++;
            }
        }
        
        return len;
    }

    private int search(int[] dp, int target, int len) {
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (r - l)/2 + l;
            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
