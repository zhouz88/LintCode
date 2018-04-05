import java.util.Arrays;

class Solution {
    public int expressiveWords(int[] array) {
        int n = array.length;
        int[][] dp = new int[n][n];
        int min = n - n/2;
        for (int len = min + 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n ; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(dp[i][j - 1] + array[j], dp[i + 1][j] + array[i]);
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().expressiveWords(new int[]{232323,1,22,2,43,32323,32}));
    }
    //有N个硬币排成一排，每次要你从最左边或者最右侧拿出一个硬币。总共拿N/2次，写一个算法，使能拿到的硬币的和最大。
}
