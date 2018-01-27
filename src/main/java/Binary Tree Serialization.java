 7. Binary Tree Serialization

    Description
    Notes
    Testcase
    Judge

Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
Notice

There is no limit of how you deserialize or serialize a binary tree, LintCode will take your output of serialize as the input of deserialize, it won't check the result of serialize.
Have you met this question in a real interview?
Example

An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7

Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition of TreeNode:

 */


public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(root.val + ",");

        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if (tmp.left != null)  {
                sb.append(tmp.left.val + ",");
                q.add(tmp.left);
            } else {
                sb.append("#,");
            }

            if (tmp.right != null)  {
                sb.append(tmp.right.val + ",");
                q.add(tmp.right);
            } else {
                sb.append("#,");
            }
        }

        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] s = data.split(",");
        if (s.length == 0) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        q.add(root);
        int idx = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (s[++idx].equals("#")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(s[idx]));
                q.add(node.left);
            }

            if (s[++idx].equals("#")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(s[idx]));
                q.add(node.right);
            }
        }

        return root;
    }

     public class TreeNode {
         public int val;
         public TreeNode left, right;

         public TreeNode(int val) {
             this.val = val;
             this.left = this.right = null;
         }
     }
}
