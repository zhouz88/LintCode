class Solution {//划分形动态规划和WORD BREAK 一回事
    public int minCut(String s) {
        //edge case
        if (s == null) {
            return 0;
        }
        int m = s.length();

        if (m <= 1) {
            return 0;
        }

        boolean[][] isPa = new boolean[m][m];
        int i , j;
        
        for (i = 0; i < m; i++) {
            isPa[i][i] = true;
        }

        for (i = m - 2; i >= 0; i--) {
            for (j = i + 1; j < m; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    isPa[i][j] = (j - i == 1 ? true : isPa[i + 1][j - 1]);
                }
            }
        }


        int[] dp = new int[m];
        
        for (i = 0; i < m; i++) {
            if (isPa[0][i]) {
                dp[i] = 0;
                continue;
            }
            int cut = i;
            for (j = 0; j < i; j++) {
                if (isPa[j + 1][i]) {
                    cut = Math.min(dp[j] + 1 , cut);
                }
            }
            dp[i] = cut;
        }

        return dp[m - 1];

    }
}
