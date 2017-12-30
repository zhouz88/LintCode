543. Kth Largest in N Arrays 
public class Solution {
    
    /*
     * @param arrays: a list of array
     * @param k: An integer
     * @return: an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // write your code here
        
        if (arrays == null || arrays.length == 0) 
            throw new RuntimeException();
            
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (cnt < k) {
                    pq.add(arrays[i][j]);
                    cnt++;
                } else {
                    pq.add(arrays[i][j]);
                    pq.poll();
                }
            }
        }
        
        return pq.isEmpty() ? -1 : pq.poll();
    }
}
