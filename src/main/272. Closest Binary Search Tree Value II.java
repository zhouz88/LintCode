import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 272. Closest Binary Search Tree Value II
 *     TreeNode(int x) { val = x; }
 272. Closest Binary Search Tree Value II
DescriptionHintsSubmissionsDiscussSolution
DiscussPick One
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?


 * }
 */
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.add(p);
                p = p.left;
            } else {
                p = stack.pop();
                ret.add(p.val);
                p = p.right;
            }
        }
        
        int l = 0, r = ret.size() - k;
        
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (mid + k == ret.size() || 2*target < ret.get(mid) + ret.get(mid + k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }             
        }
    
        return ret.subList(l, l + k);
        
    }
}
