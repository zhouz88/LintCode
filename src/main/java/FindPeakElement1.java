public class Solution {
    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
     /*
     
     75. Find Peak Element 

 Description
 Notes
 Testcase
 Judge
There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peek if:

A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.

 Notice

It's guaranteed the array has at least one peak.
The array may contain multiple peeks, find any of them.
The array has at least 3 numbers in it.
Have you met this question in a real interview? Yes
Example
Given [1, 2, 1, 3, 4, 5, 7, 6]

Return index 1 (which is number 2) or 6 (which is number 7)

Challenge */
    public int findPeak(int[] A) {
        // write your code here
        int l = 1;
        int r = A.length - 2;
        while (l <= r) {
            int mid = (l + r)/2;
            if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
                return mid;
            } else if (A[mid] < A[mid + 1] && A[mid] > A[mid - 1]) {
                l = mid + 1;
            } else if (A[mid] > A[mid + 1] && A[mid] < A[mid - 1]) {
                r = mid - 1;
            } else if (A[mid] < A[mid + 1] && A[mid] < A[mid - 1]) {
                l = mid;
            }
        }
        return -1;
    }
}
