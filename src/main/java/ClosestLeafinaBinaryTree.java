/*
742. Closest Leaf in a Binary Tree My SubmissionsBack to Contest
User Accepted: 351
User Tried: 667
Total Accepted: 356
Total Submissions: 1586
Difficulty: Medium
Given a binary tree where every node has a unique value, and a target key k, find the closest leaf node to target k in the tree.

A node is called a leaf if it has no children.

In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

Example 1:

Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)

Explanation: Either 2 or 3 is the closest leaf node to 1.
Example 2:

Input:
root = [1], k = 1
Output: 1

Explanation: The closest leaf node is the root node itself.
Example 3:

Input:
root = [1,2,3,4,null,null,null,5,null,6], k = 2
Diagram of binary tree:
             1
            / \
           2   3
          /
         4
        /
       5
      /
     6

Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is closest to the node with value 2.
Note:
root represents a binary tree with at least 1 node and at most 1000 nodes.
Every node has a unique node.val in range [1, 1000].
There exists some node in the given binary tree for which node.val == k
*/
class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        node = root;
        getNode(root, k, 0);
        dfs(root, 0);
        return value;
    }
    private TreeNode node;
    private TreeNode target;
    private int targetLevel;
    
    private Map<Integer, Integer> map = new HashMap<>();
    private int res = 999999999;
    private int value = 0;
    
    public void getNode(TreeNode root, int k, int level) {
        if (root == null) {
            return;
        } else {
            if (root.val == k) {
                target = root;
                targetLevel = level;
            }
            map.put(root.val, level);
            getNode(root.left, k, level+1);
            getNode(root.right, k, level+1);
        }
    }
    
    public void dfs(TreeNode root, int level) {
        if (root ==null) {
            return;
        } else {
            if (root.left == null && root.right == null ) {
               TreeNode father = get(node, target, root);
               int fatherLevel = map.get(father.val);
               if (-2*fatherLevel + level + targetLevel < res) {
                   res = -2*fatherLevel + level + targetLevel;
                   value = root.val;
               }
            }
            dfs(root.left, level+1);
            dfs(root.right, level+1);
        }
    }
    
    public TreeNode get(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = get(root.left, p, q);
        TreeNode right = get(root.right, p, q);
        if (left != null && right != null)   return root;
        return left != null ? left : right;
    }
}
