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
    boolean flagA = false;
    boolean flagB = false;
    boolean visitedLeaf = false;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(root.val);
        } else if (root.left == null) {
            dfsRight(root.right, res);
            Collections.reverse(res);
            res.add(0, root.val);
        } else if (root.right == null) {
            res.add(root.val);
            dfsLeft(root.left, res);
        } else {

            List<Integer> left = new ArrayList<>();
            List<Integer> mid = new ArrayList<>();
            List<Integer> right = new ArrayList<>();

            dfsL(root.left, left);
            dfsR(root.right, right);
            dfs(root, mid);
            res.add(root.val);
            res.addAll(left);
            res.addAll(mid);
            Collections.reverse(right);
            res.addAll(right);
        }
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            res.add(root.val);
        }
        dfs(root.left, res);
        dfs(root.right, res);
    }

    private void dfsL(TreeNode root,  List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            flagA = true;
        }
        if (!flagA) res.add(root.val);
        dfsL(root.left, res);
        dfsL(root.right, res);
    }

    private void dfsR(TreeNode root,  List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            flagB = true;
        }
        if (!flagB) res.add(root.val);
        dfsR(root.right, res);
        dfsR(root.left, res);
    }

    private void dfsLeft(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (!visitedLeaf || (root.right == null && root.left == null)) {
            res.add(root.val);
        }
        if (root.right == null && root.left == null) {
            visitedLeaf = true;
        }
        dfsLeft(root.left, res);
        dfsLeft(root.right, res);
    }

    private void dfsRight(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (!visitedLeaf || (root.right == null && root.left == null)) {
            res.add(root.val);
        }

        if (root.right == null && root.left == null) {
            visitedLeaf = true;
        }
        dfsRight(root.right, res);
        dfsRight(root.left, res);
    }

//       public class TreeNode {
//         int val;
//         TreeNode left;
//         TreeNode right;
//         TreeNode(int x) { val = x; }
//     }
}
