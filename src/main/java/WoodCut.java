public class Solution {
    /*
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     183. Wood Cut 

 Description
 Notes
 Testcase
 Judge
Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.

 Notice

You couldn't cut wood into float length.

If you couldn't get >= k pieces, return 0.

Have you met this question in a real interview? Yes
Example
For L=[232, 124, 456], k=7, return 114.

Challenge 
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        long l = 1;
        long r = Integer.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r)/2;
            if (check(L,mid, k)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int)r;
    }
    
    private boolean check(int[] L, long mid, int k) {
        int count = 0;
        for (int i = 0; i < L.length; i++) {
            count += L[i]/(int)mid; 
        }
        return count >= k;
    }
}
