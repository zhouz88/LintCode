/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
 250. Count Univalue Subtrees
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.


 */
class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        count(root);
        return cnt;
    }
    
    private int cnt = 0;
    
    private boolean count(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = count(root.left);
        boolean right = count(root.right);
        if (left && right) {
            boolean L = (root.left != null ? root.left.val == root.val: true);
            boolean R = (root.right != null ? root.right.val == root.val: true);
            if (L && R) cnt++;
            return L && R;
        } else {
            return false;
        }
    }
}
