import java.util.ArrayList;
import java.util.Collections;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root, pre;
        while (cur != null) {
            if (cur.right == null) {
                res.add(cur.val);
                cur = cur.left;
            } else {
                pre = cur.right;
                while (pre.left != null) {
                    pre = pre.left;
                }
                res.add(cur.val);
                pre.left = cur.left;
                cur = cur.right;
            }
        }
        Collections.reverse(res);
        return res;
    }
}
