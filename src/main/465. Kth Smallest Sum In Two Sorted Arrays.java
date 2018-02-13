import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<>();
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(10, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(nums1[o1[0]] + nums2[o1[1]], nums1[o2[0]] + nums2[o2[1]]);
            }
        });
        
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        List<int[]> ret = new ArrayList<>();
        int[] start = {0, 0};
        
        int[][] directions = {{1, 0}, {0, 1}};
        pq.add(start);
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            k--;
            ret.add(new int[]{nums1[node[0]], nums2[node[1]]});
            
            if (k == 0) {
                break;
            }
            
            for(int[] dir : directions) {
                int x = dir[0] + node[0];
                int y = dir[1] + node[1];
                if (x >= 0 && y >= 0 && x < nums1.length &&y < nums2.length && !visited[x][y]) {
                    pq.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        
        return ret;
    }
}
