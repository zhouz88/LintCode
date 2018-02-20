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
