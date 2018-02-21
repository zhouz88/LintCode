//binary search

class Solution {
    private int count = 0;

    public int reversePairs(int[] nums) {
        Node[] nodes = new Node[nums.length];

        for (int i = 0; i < nums.length; i++)
            nodes[i] = new Node(nums[i], i);

        mergeSort(nodes, 0, nums.length - 1);

        return count;
    }

    private void mergeSort(Node[] nodes, int start, int end) {
        if (start < end) {
            int mid = ((end - start) >> 1) + start;
            mergeSort(nodes, start, mid);
            mergeSort(nodes, mid + 1, end);

            Node[] array = new Node[end - start + 1];
            int idx = 0;
            int l = start, r = mid + 1;

            for (int i = mid + 1; i <= end; i++) {
                long g = 2 * nodes[i].val;
                int L = search(g, nodes, start, mid);
                count += mid - L + 1;
            }

            while (l <= mid && r <= end) {
                if (nodes[l].val <= nodes[r].val) {
                    array[idx++] = nodes[l++];
                } else {
                    array[idx++] = nodes[r++];
                }
            }

            while (l <= mid) {
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

    private int search(long g, Node[] array, int start, int end){
        int l = start;
        int r = end;
        while (l <= r) {
            int mid = ((r -  l) >> 1) + l;
            if (array[mid].val == g){
                l = mid  + 1;
            } else if (array[mid].val < g) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private static class Node {
        long val;
        int id;
        public Node(long val, int id){
            this.val = val;
            this.id = id;
        }
    }
}

//two pointers 

class Solution {
    private int count = 0;

    public int reversePairs(int[] nums) {
        Node[] nodes = new Node[nums.length];

        for (int i = 0; i < nums.length; i++)
            nodes[i] = new Node(nums[i], i);

        mergeSort(nodes, 0, nums.length - 1);

        return count;
    }

    private void mergeSort(Node[] nodes, int start, int end) {
        if (start < end) {
            int mid = ((end - start) >> 1) + start;
            mergeSort(nodes, start, mid);
            mergeSort(nodes, mid + 1, end);

            Node[] array = new Node[end - start + 1];
            int idx = 0;
            int l = start, r = mid + 1;
            int j = mid + 1;
            
            for (int i = start; i <= mid; i++) {
                long g = 2 * nodes[j].val;
                if (nodes[i].val > g) {
                    count += mid - i + 1;
                    j++;
                }
            }

            while (l <= mid && r <= end) {
                if (nodes[l].val <= nodes[r].val) {
                    array[idx++] = nodes[l++];
                } else {
                    array[idx++] = nodes[r++];
                }
            }

            while (l <= mid) {
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
        long val;
        int id;
        public Node(long val, int id){
            this.val = val;
            this.id = id;
        }
    }
}
