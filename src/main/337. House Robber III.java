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
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return  map.get(root);
        }
        int res1 = rob(root.left) + rob(root.right);
        int res2 = root.val + (root.left == null ? 0 : rob(root.left.left)  + rob(root.left.right)  ) + (root.right == null ? 0 : rob(root.right.right) + rob(root.right.left));
        map.put(root, Math.max(res1, res2));
        return Math.max(res1, res2);
    }
}
