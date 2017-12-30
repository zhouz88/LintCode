public class Solution {
    /*
    386. Longest Substring with At Most K Distinct Characters 
 Description
 Notes
 Testcase
 Judge
Given a string s, find the length of the longest substring T that contains at most k distinct characters.

Have you met this question in a real interview? Yes
Example
For example, Given s = "eceba", k = 3,

T is "eceb" which its length is 4.

Challenge 
O(n), n is the size of the string s.
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null)
            throw new RuntimeException();
            
        if (s.length() == 0 || k == 0) 
            return 0;
            
        int m = s.length();
        
        int[] window = new int[256];
        int count = 0, max = -99999999, j = 0;
        
        for (int i = 0; i < m; i++) {
            if (window[s.charAt(i)] == 0) {
                count++;
            }
            window[s.charAt(i)]++;
            
            while (count > k && j <= i) {
                if (window[s.charAt(j)] == 1) {
                    count--;
                }
                window[s.charAt(j)]--;
                j++;
            }
            
            max = Math.max(max, i - j + 1);
            //record the max;
        }
        
        return max == -99999999 ? -1: max;
    }
}
