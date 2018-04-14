import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String findContestMatch(int n) {
        TreeNode root = new TreeNode(1);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int lev = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            lev <<= 1;
            for (int z = 0; z < size; z++) {//care!!!
                TreeNode node = q.poll();
                node.left = new TreeNode(node.val);
                node.right = new TreeNode(lev + 1 - node.val);
                q.add(node.left);
                q.add(node.right);
            }
            if (lev == n) break;
        }
        return dfs(root);
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return root.val + "";
        }
        String l = dfs(root.left);
        String r = dfs(root.right);
        return "(" + l + "," + r + ")";
    }
}
