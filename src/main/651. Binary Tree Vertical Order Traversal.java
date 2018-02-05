import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
       public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList<>();
        }
        
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        q.add(root);
        levels.add(0);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int level = levels.poll();
                map.putIfAbsent(level, new ArrayList<>());
                map.get(level).add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                    levels.add(level - 1);
                }
                if (node.right != null) {
                    q.add(node.right);
                    levels.add(level + 1);
                }
            }
        }
        return new ArrayList<>(map.values());
    }
}
