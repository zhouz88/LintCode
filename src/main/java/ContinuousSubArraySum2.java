public class Solution {

    /*
     403. Continuous Subarray Sum II

    Description
    Notes
    Testcase
    Judge

Given an circular integer array (the next element of the last element is the first element), find a continuous subarray in it, where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number.

If duplicate answers exist, return any of them.
Have you met this question in a real interview?
Example

Give [3, 1, -100, -3, 4], return [4,1].

     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySumII(int[] A) {
        if (A == null) 
            throw new RuntimeException();
            
        if (A.length == 0) 
            return new ArrayList<>();
            
        int[] start = new int[A.length];
        int begin = 0, end = 0;
        int max = A[0], pre = A[0];
        
        for (int i = 1; i < A.length; i++) {
            pre = Math.max(pre + A[i], A[i]);
            if (pre == A[i]) {
                start[i] = i;
            } else {
                start[i] = start[i - 1];
            }
            if (pre > max) {
                max = pre;
                begin = start[i];
                end = i;
            }
        }
        
        int total = 0;
        for (int i : A) {
            total += i;
        }
        
        pre = A[0];
        int min = pre;
        int[] start1 = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            pre = Math.min(A[i], pre + A[i]);
            if (pre == A[i]) {
                start1[i] = i;
            } else {
                start1[i] = start1[i - 1];
            }
            //System.out.println(pre);
            if (total - pre > max && start1[i] > 0) {
                max = total - pre;
                begin = i + 1;
                end = start1[i] - 1;
            }
        }
        return Arrays.asList(begin, end);
    }
}
