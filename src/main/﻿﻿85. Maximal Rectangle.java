import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = (matrix[0][j] == '1' ? 1 : 0);
        }
        int max = -1;
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = (matrix[i][j] == '0' ? 0 : dp[i - 1][j] + 1);
            }
        }
        
        for (int  i = 0; i < dp.length; i++) {
            max = Math.max(max, getMaxHist(dp[i]));
        }
        
        return max;
    }

    private int getMaxHist(int[] ints) {
        if (ints == null || ints.length ==0 ) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.add( - 1);
        int max = -1;
        
        for (int i  = 0; i < ints.length; i++) {
            while (stack.peek() != -1 && ints[stack.peek()] > ints[i]) {
                int idx = stack.pop();
                max = Math.max(max, (i - 1 - stack.peek())*ints[idx]);
            }
            stack.add(i);//wrong 1
        }
        
        while (stack.peek() != -1) {
            int idx = stack.pop();
            max = Math.max(max, (ints.length - 1 - stack.peek()) * ints[idx]);
        }
        
        return max;
    }
}
