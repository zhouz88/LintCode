import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        List<Integer> ret = new ArrayList<>();
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (A[i] == -1) continue;
            for (int j = Math.max(0, i - B); j < i; j++) {
                if (A[j] == -1) continue;
                dp[i] = Math.min(dp[j] + A[i], dp[i]);
            }
        }
        if (dp[A.length - 1] == Integer.MAX_VALUE) {
            return ret;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        dfs(A, 0, dp, list, B, ret);
        return ret;
    }

    private void dfs(int[] A, int start, int[] dp, List<Integer> res, int B, List<Integer> ret) {
        if (ret.size() != 0) {
            return;
        }
        if (ret.size() == 0 && start == A.length - 1) {
            ret.addAll(new ArrayList<>(res));
            return;
        }
        for (int i = start + 1; i <= Math.min(start + B, A.length - 1); i++) {
            if (dp[i] != Integer.MAX_VALUE  && dp[start] + A[i] == dp[i]) {
                res.add(i + 1);
                dfs(A, i, dp, res, B, ret);
                res.remove(res.size() - 1);
            }
        }
    }
}
