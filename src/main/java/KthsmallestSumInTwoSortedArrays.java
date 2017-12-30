465. Kth Smallest Sum In Two Sorted Arrays 
 Description
 Notes
 Testcase
 Judge
Given two integer arrays sorted in ascending order and an integer k. Define sum = a + b, where a is an element from the first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.

Have you met this question in a real interview? Yes
Example
Given [1, 7, 11] and [2, 4, 6].

For k = 3, return 7.

For k = 4, return 9.

For k = 8, return 15.


public class Solution {
    
    /*
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        if (A == null || B == null || A.length == 0 || B.length == 0)
            throw new RuntimeException();
            
        int m = A.length, n = B.length;
        
        int l = A[0] + B[0];
        int r = A[m - 1] + B[n - 1];
        
        while (l <= r) {
            int mid = (l + r)/2;
            if (check(A, B, mid, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    private boolean check(int[] A, int[] B, int target, int k) {
        if (A.length < B.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        int total = 0;
        for (int i = 0; i < B.length; i++) {
            int center = target - B[i];
            int l = 0;
            int r = A.length - 1;
            while (l <= r) {
                int mid = (l + r) /2;
                if (A[mid] <=  center) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            total += l;
        }
        return total >= k;
    }
};


public class Solution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        int[][] directions = {{0, 1}, {1, 0}};
        
        // directions is two dimensional!!!!!!!!!!! int[][] not int[]
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return (A[a[0]] + B[a[1]]) - (A[b[0]] + B[b[1]]);
            }
        });
        
        boolean[][] visited = new boolean[A.length][B.length];
        visited[0][0] = true;
        pq.add(new int[]{0, 0});
        
        for (int i = 0; i < k; i++) {
            int[] node = pq.poll();
            if (i == k - 1) 
                return A[node[0]] + B[node[1]];
                
            for (int[] dir : directions) {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                
                if (x>=A.length || y >= B.length || visited[x][y]) continue;
                visited[x][y] = true;
                pq.add(new int[]{x, y});
            }
    
        }
        
        throw new RuntimeException();
    }
}

