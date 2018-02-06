public class Solution {
       public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode p = dummy;
        while (root != null) {
            if (root.left != null) {
                p.next = root.left;
                p = p.next;
            }
            if (root.right != null) {
                p.next = root.right;
                p = p.next;
            }
            root = root.next;
            if (root == null) {
                root = dummy.next;
                dummy.next = null;
                p = dummy;
            }
        }
    }
}
