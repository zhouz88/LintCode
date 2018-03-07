import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        k--;
        
        while (n >= 1) {
            int row = k/dp[n - 1];
            int col = k%dp[n - 1];
            sb.append(list.get(row));
            list.remove(row);
            k = col;
            n --;
        }
        
        return sb.toString();
    }
}
