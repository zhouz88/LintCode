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

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: new root
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode A = root, B = root.left, C = root.right;
        A.left = null;
        A.right = null;
        TreeNode temp1, temp2;
        while (B != null) {
            temp1 = B.left;
            temp2 = B.right;
            
            B.left = C;
            B.right = A;
            
            A = B;
            B = temp1;
            C = temp2;
        }
        return A;
    }
}
