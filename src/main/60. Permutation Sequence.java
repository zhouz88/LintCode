import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Solution {
    public String getPermutation(int n, int k) {
        int[] dp = new int[10];
        dp[0] = 1;
        for (int i = 1; i < 10; i++) {
            dp[i] = dp[i - 1] * i;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1;i <= n; i++) {
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while(list.size() != 0) {
            int a = (k - 1)/dp[n - 1];
            int b = (k - 1)%dp[n - 1];
            Integer tmp = list.get(a);
            sb.append(tmp);
            list.remove(tmp);
            n --;
            k = b + 1;
        }
        return sb.toString();
    }
}
