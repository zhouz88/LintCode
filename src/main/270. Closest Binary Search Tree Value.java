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
    public int closestValue(TreeNode root, double target) {
        double res = Double.POSITIVE_INFINITY;
        int ret = 0;
        while (root != null) {
            if (Math.abs(root.val - target) < res) {
                res = Math.abs(root.val - target);
                ret = root.val;
            }
            if (root.val < target) {
                root = root.right;
            } else if (root.val > target) {
                root = root.left;
            } else if (root.val - target == 0) {
                return root.val;
            }
        }
        return ret;
    }
}
