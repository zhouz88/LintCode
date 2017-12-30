public class Solution {
    /*
    401. Kth Smallest Number in Sorted Matrix 
 Description
 Notes
 Testcase
 Judge
Find the kth smallest number in at row and column sorted matrix.

Have you met this question in a real interview? Yes
Example
Given k = 4 and a matrix:

[
  [1 ,5 ,7],
  [3 ,7 ,8],
  [4 ,8 ,9],
]
return 5
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            
            public int compare(int[] a, int[] b) {
                return matrix[a[0]][a[1]] - matrix[b[0]][b[1]] ;
            }
        });
        
        int m = matrix.length, n = matrix[0].length;
        
        int[] start = new int[2];
        
        pq.add(start);
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            k--;
            if (k == 0) 
                return matrix[node[0]][node[1]];
            
            for (int[] dir : directions) {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                if (x<0||y<0||x>=m||y>=n||visited[x][y]) continue;
                visited[x][y] = true;
                pq.add(new int[]{x, y});
            }
        }
        
        throw new RuntimeException();
    }
}

