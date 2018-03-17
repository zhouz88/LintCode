import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int findRotateSteps(String ring, String key) {
        List<Integer>[] map = new ArrayList[26];
        int m = ring.length();
        int n = key.length();

        for (int i = 0; i < ring.length(); i++) {
            if (map[ring.charAt(i) - 'a'] == null) {
                map[ring.charAt(i) - 'a'] = new ArrayList<>();
            }
            map[ring.charAt(i) - 'a'].add(i);
        }

        int[][] dp = new int[n][m];

        for (int k : map[key.charAt(n - 1) - 'a']) {
            dp[n - 1][k] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            Arrays.fill(dp[i], 999999999);
            for (int k : map[key.charAt(i) - 'a']) {
                for (int j : map[key.charAt(i + 1) - 'a']) {
                    dp[i][k] = Math.min(dp[i][k], dp[i + 1][j] + distance(k, j, m)  + 1);
                }
            }
        }

        int min = 999999999;
        for (int j : map[key.charAt(0) - 'a']) {
            min = Math.min(dp[0][j] + distance(0, j, m), min);
        }
        return min;
    }

    private int distance(int k, int j, int m) {
        return  Math.min(Math.abs(k - j), m - Math.abs(k - j));
    }
}






//ring = "godding", key = "gd"
