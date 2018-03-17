class Solution {
    public String findContestMatch(int N) {
        TreeNode root = new TreeNode(1);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        int n = (int)(Math.log(N)/Math.log(2) + 0.5);
        while (!q.isEmpty() && level <= n) {
            int size = q.size();
            for (int z = 0; z < size; z++) {
                TreeNode node = q.poll();
                node.left = new TreeNode(node.val);
                node.right = new TreeNode((1 << level)  + 1 - node.val);
                q.add(node.left);
                q.add(node.right);
            }
            level++;
        }
        return dfs(root);
    }

    private String dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val+"";
        }
        return "(" +dfs(root.left) +"," + dfs(root.right)+")";
    }
}
