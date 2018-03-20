import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i], i);
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < nodes.length; i++) {
            max = Math.max(nodes[i].id, max);
            if (max == i) {
                cnt++;
            }
        }
        return cnt;
    }
    
    private static class Node {
        int val;
        int id;
        public Node(int x, int y) {
            this.val = x;
            this.id = y;
        }
    }
}
