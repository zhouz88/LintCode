import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    //klog(2k);
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(matrix[o1[0]][o1[1]], matrix[o2[0]][o2[1]]);
            }
        });

        int m = matrix.length, n = matrix[0].length;

        int[] start = new int[]{0, 0};

        pq.add(start);

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        final int[][] directions = {{0, 1}, {1, 0}};
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            k--;
            if (k == 0) {
                return matrix[node[0]][node[1]];
            }
            for (int[] dir : directions) {
                int x = dir[0] + node[0];
                int y = dir[1] + node[1];
                if (x>=0&&y>=0&&x< matrix.length&&y<matrix[0].length&&!visited.contains(x*n + y)) {
                    visited.add(x*n + y);
                    pq.add(new int[]{x, y});
                }
            }

        }
        
        return -1;
    }
}

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    // m*log(n)*log(m*n)
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;

        int l = matrix[0][0], r = matrix[m - 1][n - 1];

        while (l <= r) {
            int mid = (r - l)/2 + l;
            if (check(matrix, mid) >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int check(int[][] matrix, int target) {
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] array = matrix[i];
            int l = 0, r =  array.length - 1;
            while (l <= r) {
                int mid = (r - l)/2 + l;
                if (array[mid] == target) {
                    l = mid + 1;
                } else if (array[mid] < target) {
                    l = mid + 1;
                } else{
                    r = mid - 1;
                }
            }
            cnt += l;
        }
        return cnt;
    }
}
