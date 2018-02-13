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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode left, right, p, middle;
        p = root.left;
        middle = root.right;
        root.left = null;
        root.right = null;
        
        while (p != null) {
            left = p.left;
            right = p.right;
            
            p.left = null;
            p.right = null;
            
            p.left = middle;
            p.right = root;
            
            root = p;
            p = left;//wrong 1 烦了
            middle = right;
        }
        return root;
    }
}
