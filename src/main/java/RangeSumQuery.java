class NumArray {
//Range sum query

    private TreeNode root;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.root = buildTree(0, nums.length - 1);
    }

    private TreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(start, end);
        if (start == end) {
            root.sum = nums[start];
            return root;
        } else {
            int mid = start + (end - start)/2;
            TreeNode left = buildTree(start, mid);
            TreeNode right = buildTree(mid + 1, end);
            root.left = left;
            root.right = right;
            root.sum = left.sum + right.sum;
            return root;
        }

    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
       return query(root, i, j);
    }

    private int query(TreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return query(root.left, start, end);
            } else if (start >= mid+1) {
                return query(root.right, start, end);
            }  else {    
                return query(root.right, mid+1, end) + query(root.left, start, mid);
            }
        }
    }
    
    private void update(TreeNode root, int idx, int val) {
        if (root.start == root.end) {
            root.sum = val;
            return ;
        }
        int mid = root.start + (root.end - root.start)/2;
        if (idx <= mid) {
            update(root.left, idx, val);
        } else {
            update(root.right, idx, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    private static class TreeNode {
        int start;
        int end;
        int sum;
        TreeNode left, right;
        public TreeNode(int a, int b) {
            this.start = a;
            this.end = b;
        }
    }
}
