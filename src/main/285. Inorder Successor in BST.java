/**
 * Definition for a binary tree node.
 public class TreeNode {
 Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int x) { val = x; }
 }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        
        if (root.val > p.val) {
            TreeNode tmp = inorderSuccessor(root.left, p);
            if (tmp == null) {
                return root;
            } else {
                return tmp;
            }
        } else {
            return inorderSuccessor(root.right, p);
        }
        
    }
}

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
     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        int val = p.val + 1;
        TreeNode cur = root;
        TreeNode res = null;
        int min = Integer.MAX_VALUE;
        while (cur != null) {
            if (cur.val > val && cur.val - val < min) {
                res = cur;
                min = cur.val - val;
            }
            if (cur.val == val) {
                return cur;
            } else if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }
}
