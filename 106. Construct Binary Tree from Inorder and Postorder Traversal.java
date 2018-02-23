import java.util.HashMap;
import java.util.Map;

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
    int idx ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.idx = postorder.length - 1;
        return update(postorder, map, 0 , inorder.length - 1);
    }

    private TreeNode update(int[] postorder, Map<Integer, Integer> map, int start, int end) {
        if (start > end) {
            return null;
        }
        int tmp = postorder[idx--];
        int i = map.get(tmp);
        TreeNode root = new TreeNode(tmp);
        root.right = update(postorder, map, i + 1, end);
        root.left = update(postorder, map, start, i - 1);
        return root;
    }
}
