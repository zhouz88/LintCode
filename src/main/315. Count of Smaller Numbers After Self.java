import java.util.Arrays;
import java.util.List;

class Solution {
    private Integer[] counts;

    public List<Integer> countSmaller(int[] nums) {
        Node[] nodes = new Node[nums.length];
        this.counts = new Integer[nums.length];
        Arrays.fill(counts, 0);//important ! bug 1
        
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(nums[i], i);
        }
        
        mergeSort(nodes, 0, nums.length  - 1);
        return Arrays.asList(counts);
    }

    private void mergeSort(Node[] nodes, int start, int end) {
        if (start < end) {
            int mid = ((end - start) >> 1) + start;
            
            mergeSort(nodes, start, mid);
            mergeSort(nodes, mid + 1, end);
            
            Node[] array = new Node[end - start + 1]; //bug
            
            int l = start;
            int r = mid + 1;
            int idx = 0;//for array
            int total = 0;

            while (l <= mid && r <= end) {
                if (nodes[l].val <= nodes[r].val) {
                    counts[nodes[l].id] += total;
                    array[idx++] = nodes[l++];
                } else {
                    total++;
                    array[idx++] = nodes[r++];
                }
            }
            
            while (l <= mid) {
                counts[nodes[l].id] += total; //bug 2
                array[idx++] = nodes[l++];
            }
            
            while (r <= end) {
                array[idx++] = nodes[r++];
            }

            for (int i = start; i <= end; i++) {
                nodes[i] = array[i - start];
            }
        }
    }

    private static class Node {
        int val;
        int id;
        public Node(int val, int id) {
            this.val = val;
            this.id = id;
        }
    }
}

//

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = (nums[i] < min) ? nums[i]:min;
        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i],max);
        }
        int[] tree = new int[max+1];
        for (int i = nums2.length-1; i >= 0; i--) {
            res.add(0,get(nums2[i]-1,tree));
            update(nums2[i],tree);
        }
        return res;
    }
    private int get(int i, int[] tree) {
        int num = 0;
        while (i > 0) {
            num +=tree[i];
            i -= i&(-i);
        }
        return num;
    }
    private void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i] ++;
            i += i & (-i);
        }
    }
}

//
class Solution {
    public List<Integer> countSmaller(int[] A) {
        List<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0) return res;
        int min = A[0], max = A[0];
        
        for (int i : A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        if (min < 0) {
            for (int i = A.length - 1; i >= 0; i--) {
                A[i] -= min;
            }
            min = 0;
            max -= min;
        }
         
        TreeNode root = build(min, 100000);
        
        for (int i = A.length - 1; i >= 0; i--){
            int ans = 0;
            if(A[i]>0)ans = query(root, min, A[i] - 1);
            add(root, A[i], 1);
            res.add(ans);
        }
        
        Collections.reverse(res);
        return res;
    }

    private int query(TreeNode root, int start, int end) {
        if (start > end) return 0;
        if (start == root.start && end == root.end){
            return root.count;
        }

        int leftCount = 0;
        int rightCount = 0;

        int mid = (root.start + root.end) / 2;
        if (start <= mid) {
            if (end > mid) {
                leftCount = query(root.left, start, mid);
            } else {
                leftCount = query(root.left, start, end);
            }
        }

        if (end > mid) {
            if (start <= mid) {
                rightCount = query(root.right, mid + 1, end);
            } else {
                rightCount = query(root.right, start, end);
            }
        }
        return leftCount + rightCount;
    }


    private void add(TreeNode root, int index, int val) {
        if (root.start == root.end) {
            root.count += val;
            return;
        }

        int mid = (root.start + root.end)/2;

        if (index >= root.start && index <= mid) {
            add(root.left, index, val);
        }

        if (index <= root.end && index > mid) {
            add(root.right, index, val);
        }

        root.count = root.right.count + root.left.count;
    }

    private TreeNode build(int start, int end) {
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

    private static class TreeNode {
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

