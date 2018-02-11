import java.util.LinkedList;
import java.util.Queue;
//only queue
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
        sb.append(root.val + ",");// every node has four types of children “# val” "val #" "val val" "# #"
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

//Map + stack 

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //corner case
        if (root == null) {
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode k = stack.pop();
            if (k == null) {
                sb.append("#,");
                continue;
            } else {
                sb.append(k.val + ",");
            }

            if (k.right != null) {
                stack.add(k.right);
            } else {
                stack.add(null);
            }

            if (k.left != null) {
                stack.add(k.left);
            } else {
                stack.add(null);
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
        Map<TreeNode, Boolean> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        System.out.println(data);
        TreeNode root = null;
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(s[i]));
                if (stack.isEmpty()) {
                    root = node;
                    stack.add(node);
                } else {
                    if (!map.containsKey(stack.peek())) {
                        map.put(stack.peek(), true);
                        stack.peek().left = node;
                        stack.add(node);
                    } else {
                        stack.peek().right = node;
                        stack.add(node);
                    }
                }
            } else {
                if (!map.containsKey(stack.peek())) {
                    map.put(stack.peek(), false);
                } else {
                    stack.pop(); 
                    while (!stack.isEmpty() && map.containsKey(stack.peek()) && stack.peek().right != null) {
                        stack.pop();
                    }
                }
            }
        }
        
        return root;
    }
}


//Double stack~
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //corner case
        if (root == null) {
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode k = stack.pop();
            if (k == null) {
                sb.append("#,");
                continue;
            } else {
                sb.append(k.val + ",");
            }

            if (k.right != null) {
                stack.add(k.right);
            } else {
                stack.add(null);
            }

            if (k.left != null) {
                stack.add(k.left);
            } else {
                stack.add(null);
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
        
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> isLeftOk = new Stack<>();

        TreeNode root = null;
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(s[i]));
                if (stack.isEmpty()) {
                    root = node;
                    stack.add(node);
                    isLeftOk.add(-1);
                } else {
                    if (isLeftOk.peek() == -1) {
                        stack.peek().left = node;
                        
                        isLeftOk.pop();
                        isLeftOk.add(1);
                        
                        stack.add(node);
                        isLeftOk.add(-1);
                        
                    } else if (isLeftOk.peek() == 1 || isLeftOk.peek() == 0){
                        stack.peek().right = node;
                        
                        stack.add(node);
                        isLeftOk.add(-1);
                    }
                }
            } else {
                if (isLeftOk.peek() == -1) {
                    isLeftOk.pop();
                    isLeftOk.add(0);
                } else {
                    stack.pop();
                    isLeftOk.pop();
                    while (!stack.isEmpty() && isLeftOk.peek() != -1 && (stack.peek().right != null)) {
                        stack.pop();
                        isLeftOk.pop();
                    }
                }
            }
        }

        return root;
    }
}

