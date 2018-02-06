/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode p;
    
    public BSTIterator(TreeNode root) {
        this.p = root;//wrong 1 stack 不需要加入root!!!!
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return p != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp;
        while (hasNext()) {
            if (p != null) {
                stack.add(p);
                p = p.left;
            } else {
                p = stack.pop();
                tmp = p;
                p = p.right;
                return tmp.val;
            }
        }
        return -1;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
