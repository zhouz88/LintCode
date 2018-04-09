import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][m];
        int total = 0;
        for (int k = n - 1; k >= 0; k--) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if (grid[i][k] == 1) list.add(i);
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j ++) {
                    dp[list.get(i)][list.get(j)]++;
                    total += dp[list.get(i)][list.get(j)] - 1;
                }
            }
        }
        return total;
    }
}
