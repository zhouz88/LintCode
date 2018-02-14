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
    public TreeNode deleteNode(TreeNode root, int key) {
         if (root == null) {
             return null;
         }
         if (root.val < key) {
             TreeNode right = deleteNode(root.right, key);
             root.right = right;
             return root;
         } else if (root.val > key) {
             TreeNode left = deleteNode(root.left, key);
             root.left = left;
             return root;
         } else {
             if (root.right != null) {
                 TreeNode rightMin = findMin(root.right);
                 root.val = rightMin.val;
                 TreeNode right = deleteNode(root.right, rightMin.val);
                 root.right = right;
                 return root;
             } else if (root.left != null) {
                 return root.left;
             } else {
                 return null;
             }
         }
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left!= null) {
            root = root.left;
        }
        return root;
    }
}
