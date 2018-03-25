import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> lStack = new Stack<>();
        Stack<TreeNode> rStack = new Stack<>();
        fillSmaller(lStack, root, target);
        fillBigger(rStack, root, target);

        if (!lStack.isEmpty() && !rStack.isEmpty() && lStack.peek() == rStack.peek()) {
            add(res, lStack, false);
            res.remove(res.size() - 1);
        }

        while (k-- > 0) {
            if (lStack.isEmpty() && rStack.isEmpty()) {
                break;
            } else if (lStack.isEmpty()) {
                add(res, rStack, true);
            } else if (rStack.isEmpty()) {
                add(res, lStack, false);
            } else {
                double r = 1.0*((rStack.peek().val) - target);
                double l = 1.0*(target - (lStack.peek().val));
                if (l < r) {
                    add(res, lStack, false);
                } else {
                    add(res, rStack, true);
                }
            }
        }
        return res;
    }

    private void add(List<Integer> res, Stack<TreeNode> stack, boolean isR) {
        TreeNode node = stack.pop();
        res.add(node.val);
        if (isR) {
            node = node.right;
        } else {
            node = node.left;
        }
        while (node != null) {
            stack.add(node);
            if (isR) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private void fillBigger(Stack<TreeNode> rStack, TreeNode root, double target) {
        while (root != null) {
            if (root.val > target) {
                rStack.add(root);
                root = root.left;
            } else if (root.val < target) {
                root = root.right;
            } else {
                rStack.add(root);
                break;
            }
        }
    }

    private void fillSmaller(Stack<TreeNode> lStack, TreeNode root, double target) {
        while (root != null) {
            if (root.val < target) {
                lStack.add(root);
                root = root.right;
            } else if (root.val > target) {
                root = root.left;
            } else {
                lStack.add(root);
                break;
            }
        }
    }
}
