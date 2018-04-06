import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] window = new int[nums.size()];
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                nodes.add(new Node(i, nums.get(i).get(j)));
            }
        }
        Collections.sort(nodes);
        int min = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0, j = 0, cnt = 0; i < nodes.size(); i++) {
            if (window[nodes.get(i).id]++ == 0) {
                cnt++;
            }
            while (cnt == nums.size() && j <= i) {
                if (nodes.get(i).val - nodes.get(j).val + 1 < min) {
                    min = nodes.get(i).val - nodes.get(j).val + 1;
                    start = nodes.get(j).val;
                }
                if (--window[nodes.get(j).id] == 0) {
                    cnt--;
                }
                j++;
            }
        }
        return new int[]{start, start + min - 1};
    }
    
    private static class Node implements Comparable<Node>{
        int id;
        int val;
        
        public Node(int id, int val) {
            this.id = id;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
}
