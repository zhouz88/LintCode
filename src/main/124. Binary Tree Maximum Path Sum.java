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
    public int maxPathSum(TreeNode root) {
        dfs(root);
        for (int k : result) {
            System.out.println(k);
        }
        return result.size() == 0 ? 0 : max;
    }
    
    private int max = -999999999;
    private List<Integer> result = null;
    
    public List<Integer> dfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ret = new ArrayList<>();
        List<Integer> leftMax = dfs(root.left);
        List<Integer> rightMax = dfs(root.right);
        int l = 0;
        int r = 0;
        if (leftMax.size() > 0 && leftMax.get(0) > 0) {
            l = leftMax.get(0);
        }
        if (rightMax.size() > 0 && rightMax.get(0) > 0) {
            r = rightMax.get(0);
        }
        ret.add(Math.max(l, r) + root.val);
        ret.add(root.val);
        if (l > r) {
            ret.addAll(leftMax.subList(1 , leftMax.size()));
        } else if (l < r) {
            ret.addAll(rightMax.subList(1, rightMax.size()));
        } else {
            if (leftMax.size() > 0) {
                ret.addAll(leftMax.subList(1, leftMax.size()));
            }
        }
        if (l + r + root.val > max) {
            max = l + r + root.val;
            result = new ArrayList<>();
            result.add(root.val);
            if (l > 0) result.addAll(leftMax.subList(1 , leftMax.size()));
            if (r > 0) result.addAll(rightMax.subList(1 , rightMax.size()));
        }
        return ret;
    }
}
