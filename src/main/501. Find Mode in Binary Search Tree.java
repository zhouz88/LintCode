import java.util.ArrayList;
import java.util.List;

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
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }
        dfs(root, list);
        if (cnt > max) {
            list.clear();
            list.add(pre.val);
        } else if (cnt == max) {
            list.add(pre.val);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int cnt = 0;
    private int max = 0;
    private TreeNode pre;

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        if (pre == null) {
            cnt = 1;
        } else {
            if (pre.val == root.val) {
                cnt++;
            } else {
                if (cnt > max) {
                    max = cnt;
                    list.clear();
                    list.add(pre.val);
                } else if (cnt == max) {
                    list.add(pre.val);
                } 
                cnt = 1;
            }
        }
        pre = root;
        dfs(root.right, list);
    }
}
