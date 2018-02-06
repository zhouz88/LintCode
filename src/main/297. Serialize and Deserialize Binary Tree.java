import java.util.LinkedList;
import java.util.Queue;

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
        //corner case
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(root.val + ",");
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.add(node.left);
                sb.append(node.left.val + ",");
            } else {
                sb.append("#,");
            }
            if (node.right != null) {
                q.add(node.right);
                sb.append(node.right.val + ",");
            } else {
                sb.append("#,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] s = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        q.add(root);
        int idx = 1;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if (!s[idx].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(s[idx]));
                q.add(node.left);
                idx++;
            } else {
                idx++;
            }
            
            if (!s[idx].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(s[idx]));
                q.add(node.right);
                idx++;
            } else {
                idx++;
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
