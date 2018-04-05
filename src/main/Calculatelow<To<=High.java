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
    public int maxDepth(TreeNode root) {
        int total = 0;
        int low = 7, high = 21;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == low) {
                stack.add(cur);
                break;
            } else if (cur.val > low) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        while (!stack.isEmpty() && stack.peek().val <= high) {
            TreeNode node = stack.pop();
            if (node.val > low) total += node.val;
            node = node.right;
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
        }
        return total;
    }
}
