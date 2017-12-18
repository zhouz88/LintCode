public class Solution {
    /*
     * @param A: An integer array
      402. Continuous Subarray Sum

    Description
    Notes
    Testcase
    Judge

Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return anyone)
Have you met this question in a real interview?
Example

Give [-3, 1, 3, -3, 4], return [1,4].

     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySum(int[] A) {
        // write your code here
        if (A == null) {
            throw new RuntimeException();
        }
        
        if (A.length == 0) {
            return new ArrayList<>();
        }
        
        int m = A.length;
        
        List<Integer> ret = new ArrayList<>();
        int[] dp = new int[m];
        int[] start = new int[m];
        dp[0] = A[0];
        start[0] = 0;
        int res = dp[0];
        
        int left = 0;
        int right = 0;
        
        for (int i = 1; i < m; i++) {
            dp[i] = Math.max(dp[i - 1] + A[i], A[i]);
            if (dp[i] == A[i]) {
               start[i] = i;
            } else {
               start[i] = start[i - 1];
            }
            if (dp[i] > res) {
                res = dp[i];
                left = start[i];
                right = i;
            }
        }
        ret.add(left);
        ret.add(right);
        
        return ret;
    }
}
