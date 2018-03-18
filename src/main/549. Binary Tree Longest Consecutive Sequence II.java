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
    
    private static class Node{
        int increasingLength;
        int decreasingLength;
        public Node(int a, int b) {
            this.increasingLength = a;
            this.decreasingLength = b;
        }
    }
    
    int max = 1;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
         dfs(root);
         return max;
    }
    
    private Node dfs(TreeNode root) {
        if (root == null) {
            return new Node(0, 0);
        }
        
        Node left = dfs(root.left);
        Node right = dfs(root.right);
        
        int increasing = 1;
        int decreasing = 1;
        
        if (root.left != null && root.left.val + 1 == root.val) {
            increasing = Math.max(left.increasingLength + 1, increasing);
        }
        if (root.left != null && root.left.val - 1 == root.val) {
            decreasing = Math.max(left.decreasingLength + 1, decreasing);
        }
        if (root.right != null && root.right.val + 1 == root.val) {
            increasing = Math.max(right.increasingLength + 1, increasing);
        }
        if (root.right != null && root.right.val - 1 == root.val) {
            decreasing = Math.max(right.decreasingLength + 1, decreasing);
        }
        
        max = Math.max(decreasing + increasing - 1, max);
        
        return new Node(increasing, decreasing);
    }
}
