import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                sb.append(node.val + ",");
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if (data.length() == 0) {
             return null;
         }
         String[] t = data.split(",");
         Queue<TreeNode> q = new LinkedList<>();
         for (int i = 0; i < t.length; i++) {
             q.add(new TreeNode(Integer.parseInt(t[i])));
         }
         return getNode(q);
    }

    private TreeNode getNode(Queue<TreeNode> q) {
        if (q.size() == 0) return null;
        TreeNode root = q.poll();
        Queue<TreeNode> smallQueue = new LinkedList<>();
        while (!q.isEmpty() && q.peek().val < root.val) {
            smallQueue.add(q.poll());
        }
        root.left = getNode(smallQueue);
        root.right = getNode(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
