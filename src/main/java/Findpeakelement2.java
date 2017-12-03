public class Solution {
    /*
     * @param A: An integer matrix
     * @return: The index of the peak
     390. Find Peak Element II 

 Description
 Notes
 Testcase
 Judge
There is an integer matrix which has the following features:

The numbers in adjacent positions are different.
The matrix has n rows and m columns.
For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
We define a position P is a peek if:

A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
Find a peak element in this matrix. Return the index of the peak.

 Notice

The matrix may contains multiple peeks, find any of them.

Have you met this question in a real interview? Yes
Example
Given a matrix:

[
  [1 ,2 ,3 ,6 ,5],
  [16,41,23,22,6],
  [15,17,24,21,7],
  [14,18,19,20,10],
  [13,14,11,10,9]
]
return index of 41 (which is [1,1]) or index of 24 (which is [2,2])
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            int[] tmp = A[i];
            int t = biser(tmp);
            if (A[i - 1][t] < A[i][t] &&  A[i][t] > A[i + 1][t]) {
                res.add(i);
                res.add(t);
                return res;
            }
        }
        return res;
    }
    
    private int biser(int[] nums) {
        int l = 1;
        int r = nums.length - 2;
        while (l <= r) {
            int mid = (l + r)/2;
            if ( nums[mid - 1] < nums[mid]  && nums[mid]>  nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid]  && nums[mid] < nums[mid + 1]){
                l = mid + 1;
            } else if (nums[mid - 1] > nums[mid]  && nums[mid] > nums[mid + 1])  {
                r = mid - 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}
