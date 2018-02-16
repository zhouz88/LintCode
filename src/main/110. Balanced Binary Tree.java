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
    public boolean isBalanced(TreeNode root) {
        ResultType r = getHeight(root);
        return r.isbalance;
    }


    public ResultType getHeight(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        ResultType left = getHeight(root.left);
        ResultType right = getHeight(root.right);
        boolean isbalance = false;
        if (left.isbalance && right.isbalance && Math.abs(left.height - right.height) <= 1) {
            isbalance = true;
        }
        int h = Math.max(left.height, right.height) + 1;
        return new ResultType(isbalance, h);
    }

    class ResultType {
        boolean isbalance;
        int height;
        public ResultType(boolean flag, int h) {
            isbalance = flag;
            height = h;
        }
    }
}
