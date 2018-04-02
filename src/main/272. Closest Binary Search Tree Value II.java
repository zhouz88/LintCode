import java.util.ArrayList;
import java.util.List;
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
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        fillLeft(leftStack, root, target);
        fillRight(rightStack, root, target);
        if (!leftStack.isEmpty() && !rightStack.isEmpty() && leftStack.peek() == rightStack.peek()) {
            TreeNode node = leftStack.pop();
            addLeft(node, leftStack);
        }
        while (k-- > 0) {
            if (!leftStack.isEmpty() && !rightStack.isEmpty()) {
                if (target - leftStack.peek().val < rightStack.peek().val - target) {
                    res.add(leftStack.peek().val);
                    TreeNode node = leftStack.pop();
                    addLeft(node, leftStack);
                } else {
                    res.add(rightStack.peek().val);
                    TreeNode node = rightStack.pop();
                    addRight(node, rightStack);
                }
            } else if (!leftStack.isEmpty()) {
                res.add(leftStack.peek().val);
                TreeNode node = leftStack.pop();
                addLeft(node, leftStack);
            } else if (!rightStack.isEmpty()) {
                res.add(rightStack.peek().val);
                TreeNode node = rightStack.pop();
                addRight(node, rightStack);
            } else {
                break;
            }
        }
        return res;
    }

    private void addLeft(TreeNode node, Stack<TreeNode> stack) {
        node = node.left;
        while (node != null) {
            stack.add(node);
            node = node.right;
        }
    }

    private void addRight(TreeNode node, Stack<TreeNode> stack) {
        node = node.right;
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }

    private void fillRight(Stack<TreeNode> rightStack, TreeNode root, double target) {
        while (root != null) {
            if (root.val == target) {
                rightStack.add(root);
                break;
            } else if (root.val < target) {
                root = root.right;
            } else {
                rightStack.add(root);
                root = root.left;
            }
        }
    }

    private void fillLeft(Stack<TreeNode> leftStack, TreeNode root, double target) {
        while (root != null) {
            if (root.val == target) {
                leftStack.add(root);
                break;
            } else if (root.val > target) {
                root = root.left;
            } else {
                leftStack.add(root);
                root = root.right;
            }
        }
    }
}
