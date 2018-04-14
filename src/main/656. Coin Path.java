import java.util.*;

class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int[] dp = new int[A.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] == -1)continue;
            for (int j = Math.max(i - B, 0); j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + A[i]);
                }
            }
        }
        if (dp[A.length - 1] == Integer.MAX_VALUE) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        dfs(dp, A, list, 0, B);
        return list;
    }

    private boolean dfs(int[] dp, int[] A, List<Integer> list, int start, int B) {
        if (start == A.length - 1) {
            return true;
        }
        for (int i = start + 1 ; i <= start + B && i < A.length; i++) {
            if (dp[i] == dp[start] + A[i]) {
                list.add(i + 1);
                if (dfs(dp, A, list, i, B)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
