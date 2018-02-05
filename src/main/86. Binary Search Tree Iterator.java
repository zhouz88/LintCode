public class BSTIterator {
    /*
    * @param root: The root of binary tree.
    * 
    */
    private Stack<TreeNode> stack;
    private TreeNode p;
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        p = root;
        stack = new Stack<>();
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return p != null || !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        boolean flag = false;
        TreeNode ret = null;
        while (hasNext()) {
            if (p != null) {
                stack.add(p);
                p = p.left;
            } else {
                p = stack.pop();
                ret = p;
                flag = true;
                p = p.right;
            }
            if (flag) {
                break;
            }
        }
        return ret;
    }
}
