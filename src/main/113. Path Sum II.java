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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        update(ret, root, new ArrayList<Integer>(), sum, 0);
        return ret;
    }

    private void update(List<List<Integer>> ret, TreeNode root, ArrayList<Integer> integers, int sum, int total) {
        if (root == null) {
            return;
        }
        total += root.val;
        integers.add(root.val);
        if (root.right == null && root.left == null && total == sum) {
            ret.add(new ArrayList<>(integers));
        }
        update(ret, root.left, integers, sum, total);
        update(ret, root.right, integers, sum, total);
        integers.remove(integers.size() - 1);
        total -= root.val;
    }
}
