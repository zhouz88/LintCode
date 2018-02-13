class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    public int helper(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return -1;
        }
        int height = 1 + Math.max(helper(root.left, result), helper(root.right, result));
        if (height + 1 > result.size() ) {
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);
        return height;
    }
}
