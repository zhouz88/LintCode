import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
        int i, j ;
        for (i = 0; i < m; i++) 
            dp[i][i] = true;
        
        for (i = m - 2; i >= 0; i--) {
            for (j = i + 1; j < m; j++) {
                if (j - i == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));//bug 1
                }
            }
        }
        
        update(ret, s.toCharArray(), new ArrayList<String>(), 0, dp);
        
        return ret;
    }

    private void update(List<List<String>> ret, char[]t, ArrayList<String> list, int start, boolean[][] dp) {
        if (start == t.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < t.length; i ++) {
            if (dp[start][i]) {
                list.add(String.valueOf(t, start, i - start + 1));
                update(ret, t, list, i + 1, dp);
                list.remove(list.size() - 1);
            }
        }
    }
}
