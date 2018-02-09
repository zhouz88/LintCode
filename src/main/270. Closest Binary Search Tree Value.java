270. Closest Binary Search Tree Value
DescriptionHintsSubmissionsDiscussSolution
DiscussPick One
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
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
        if (root == null) {
            return 0;
        }
        return getcloset(root, target, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private int getcloset(TreeNode root, double target, double a, double b) {
        if (root == null) {
            return target - a > b - target ? (int)b : (int)a;
        } 
        if ((double)root.val == target) {
            return root.val;
        }
        
        if (root.val < target) {
            return getcloset(root.right, target, root.val, b);
        } else {
            return getcloset(root.left, target, a, root.val);
        }
        
    }
}

//method 2
class Solution {
    public int closestValue(TreeNode root, double target) {
         int v1 = root.val;
        TreeNode c =  target<v1? root.left: root.right;
        if(c == null) return v1;
        int v2 = closestValue(c,target);
        return Math.abs(target - v1) < Math.abs(target - v2)? v1 : v2;       
    }
}
