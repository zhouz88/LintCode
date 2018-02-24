import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<>();
        int len = input.length();
        List<Integer>[][] dp = new ArrayList[len][len];
        return dfs(input, 0, input.length() - 1, dp);
    }

    private List<Integer> dfs(String input, int start, int end, List<Integer>[][] dp) {
        //base case

        if (dp[start][end] != null) {
            return dp[start][end];
        }
        boolean flag = false;
        dp[start][end] = new ArrayList<>();

        //general
        List<Integer> ret = dp[start][end];
        for (int i = start; i <= end; i++) {
            switch (input.charAt(i)) {
                case '+':
                    flag = true;
                    List<Integer> left = dfs(input,start, i - 1, dp);
                    List<Integer> right = dfs(input,i + 1, end, dp);
                    for (int j : right) {
                        for (int k : left) {
                            ret.add(j + k);
                        }
                    }
                    break;
                case '-' :
                    flag = true;
                    List<Integer> l = dfs(input,start, i - 1, dp);
                    List<Integer> r = dfs(input,i + 1, end, dp);
                    for (int j : r) {
                        for (int k : l) {
                            ret.add(k - j);
                        }
                    }
                    break;
                case '*' :
                    flag = true;
                    List<Integer> lo = dfs(input,start, i - 1, dp);
                    List<Integer> hi = dfs(input,i + 1, end, dp);
                    for (int j : lo) {
                        for (int k : hi) {
                            ret.add(j*k);
                        }
                    }
                    break;
            }
        }
        if (!flag) {
            ret.add(Integer.parseInt(input.substring(start, end + 1)));
        }

        return ret;
    }
}
