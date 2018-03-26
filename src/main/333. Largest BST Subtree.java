/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int max = 0;

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);//难点是处理null
        }
        Result left = dfs(root.left);
        Result right = dfs(root.right);
        if (left.count != -1 && right.count != -1 && left.max < root.val && root.val < right.min) {
            max = Math.max(max, left.count + right.count + 1);
            return new Result(left.count + right.count + 1, Math.min(root.val, left.min), Math.max(root.val, right.max));
        }
        return new Result(-1, 21, 2121);
    }

    private class Result {
        int min;
        int max;
        int count;
        public Result(int cnt, int min, int max) {
            this.count = cnt;
            this.min = min;
            this.max = max;
        }
    }
}
