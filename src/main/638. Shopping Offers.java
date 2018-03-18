
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int total = special.size() + price.size();
        int[][] choices = new int[total][6];
        int[] values = new int[total];
        int idx = 0;
        for (List<Integer> tmp : special) {
            for (int i = 0; i < tmp.size() - 1; i++) {
                choices[idx][i] = tmp.get(i);
            }
            values[idx] = tmp.get(tmp.size() - 1);
            idx++;
        }
        for (int j = 0; j < price.size(); j++) {
            choices[idx][j] = 1;
            values[idx] = price.get(j);
            idx++;
        }
        int[] m = new int[6];
        Arrays.fill(m, 1);
        
        for (int i = 0; i < needs.size(); i++) {
            m[i] += needs.get(i);
        }

        int[][][][][][] dp = new int[m[0]][m[1]][m[2]][m[3]][m[4]][m[5]];
        for (int a = 0; a < m[0]; a++)
            for (int b = 0; b < m[1]; b++)
                for (int c = 0; c < m[2]; c++)
                    for (int d = 0; d < m[3]; d++)
                        for (int e = 0; e < m[4]; e++)
                            for (int f = 0; f < m[5]; f++) {
                                if  (a==0&&b==0&&c==0&&d==0&&e==0&&f==0) continue;
                                int cur = Integer.MAX_VALUE;
                                for (int i = 0; i < choices.length; i++) {
                                    if (a >= choices[i][0] && b >= choices[i][1] && c >= choices[i][2] && d >= choices[i][3] && e >= choices[i][4] && f >= choices[i][5] && dp[a - choices[i][0]][b - choices[i][1]][c - choices[i][2]][d - choices[i][3]][e - choices[i][4]][f - choices[i][5]] != Integer.MAX_VALUE)
                                        cur = Math.min(cur, dp[a - choices[i][0]][b - choices[i][1]][c - choices[i][2]][d - choices[i][3]][e - choices[i][4]][f - choices[i][5]] + values[i]);
                                }

                                dp[a][b][c][d][e][f] = cur;
                            }
        return dp[m[0] - 1][m[1] - 1][m[2] - 1][m[3] - 1][m[4] - 1][m[5] - 1];
    }
}
