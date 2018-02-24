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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = depth1(root.left);
        int j = depth2(root.left);
        if (j < i) {
            return countNodes(root.left) + (1 << j);
        } else {
            return (1 << j) + countNodes(root.right);
        }       
    }
    
    private int depth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = 1;
        while (root.left != null) {
            l++;
            root  = root.left;
        }
        return l;
    }

    private int depth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = 1;
        while (root.right != null) {
            l++;
            root  = root.right;
        }
        return l;
    }
}
