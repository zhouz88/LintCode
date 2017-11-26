public class Solution {
    /*
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
     /*
     249. Count of Smaller Number before itself 
Give you an integer array (index from 0 to n-1, where n is the
size of this array, data value from 0 to 10000) . For each element Ai in the array, 
count the number of element before this element Ai is smaller than it and return count number array.

*/
    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        TreeNode root = build(0, 10000);
         for(int i = 0; i < A.length; i++){
            int ans = 0;
            if(A[i] > 0){
                ans = query(root, 0, A[i] - 1);
            }
            add(root, A[i], 1);
            res.add(ans);
        }
        return res;
    }
    
    int query(TreeNode root, int start, int end) {
          if(start == root.start && end == root.end){
            return root.count;
        }

        int leftCount = 0;
        int rightCount = 0;

        int mid = (root.start + root.end) / 2;
        if(start <= mid){
            if(end > mid){
                leftCount = query(root.left, start, mid);
            }else{
                leftCount = query(root.left, start, end);
            }
        }

        if(end > mid){
            if(start <= mid){
                rightCount = query(root.right, mid + 1, end);
            }else{
                rightCount = query(root.right, start, end);
            }
        }
        return leftCount + rightCount;
    }
    
    
    void add(TreeNode root, int index, int val) {
        if (root.start == root.end) {
            root.count += val;
            return;
        }
        
        int mid = (root.start + root.end)/2;
        
        if (index >= root.start && index <= mid){
            add(root.left, index, val);
        }

        if(index <= root.end && index > mid){
            add(root.right, index, val);
        }

        root.count = root.right.count + root.left.count;
    }
    
    TreeNode build(int start, int end) {
        if (start > end) {
            return null;
        } else {
            TreeNode root = new TreeNode(start, end);
            if (start == end) {
                return root;
            }
            int mid = (start + end)/2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
            return root;
        }
    }
    
    class TreeNode{
        int start;
        int end;
        int count;
        TreeNode left;
        TreeNode right;
        public TreeNode(int a, int b) {
            start = a;
            end = b;
        }
    }
}
