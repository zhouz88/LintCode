import java.util.ArrayList;
import java.util.List;
/*
247. Strobogrammatic Number II
DescriptionHintsSubmissionsDiscussSolution
Pick One
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].


*/
class Solution {
    public List<String> findStrobogrammatic(int n) {
        if (n < 0) {
            return new ArrayList<>();
        }
        List<String>[] dp = new ArrayList[n + 1];
        dfs(dp, n);
        if (n == 1 || n == 0) {
            return dp[n];
        }
        List<String> res = new ArrayList<>();
        for (String k : dp[n - 2]) {
            res.add("1" + k + "1");
            res.add("8" + k + "8");
            res.add("6" + k + "9");
            res.add("9" + k + "6");
        }
        return res;
    }

    private List<String> dfs(List<String>[] dp, int n) {
        if (dp[n] != null) {
            return dp[n];
        }
        dp[n] = new ArrayList<>();
        List<String> ret = dp[n];
        switch (n) {
            case 0:
                dp[0].add("");
                break;
            case 1 :
                dp[1].add("0");
                dp[1].add("1");
                dp[1].add("8");
                break;
            default:
                List<String> res = dfs(dp, n - 2);
                for (String k : res) {
                    ret.add("0" + k + "0");
                    ret.add("1" + k + "1");
                    ret.add("8" + k + "8");
                    ret.add("6" + k + "9");
                    ret.add("9" + k + "6");
                }
                break;
        }
        return dp[n];
    }
}
