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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = null;
        flatten(left);
        flatten(root.right);
        TreeNode p = left;
        if (p == null) {
            return;
        }
        while (p.right != null) {
            p = p.right;
        }
        p.right = root.right;
        root.right = left;
    }
}
