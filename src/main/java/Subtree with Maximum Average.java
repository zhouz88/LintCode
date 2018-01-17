public class Solution {
    /*
    lintcode 597
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        getCountsAndSum(root);
        return maxTreeNode;
    }
    
    private TreeNode maxTreeNode;
    private double maxVal = Double.NEGATIVE_INFINITY;
    
    private long[] getCountsAndSum(TreeNode root) {
        if (root == null) 
            return new long[2];
            
        long[] left = getCountsAndSum(root.left);
        long[] right = getCountsAndSum(root.right);
        
        long totalCount = left[0] + right[0] + 1;
        long total = left[1] + right[1] + (long)root.val;
        
        maxVal = Math.max(maxVal, total*1.0/totalCount);
        
        if (maxVal == total*1.0/totalCount) 
           maxTreeNode = root;
           
        return new long[]{totalCount, total};
    }
}
