public class Solution {
    /*
     * @param s: a string
     * @return: an integer
     384. Longest Substring Without Repeating Characters  
 Description
 Notes
 Testcase
 Judge
Given a string, find the length of the longest substring without repeating characters.

Have you met this question in a real interview? Yes
Example
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.

Challenge 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null) 
           throw new RuntimeException();
           
        if (s.length() == 0) 
            return 0;
            
        int j = 0, max = -999999999;
        
        int[] map = new int[256];
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            count++;
            
            if (map[s.charAt(i)] == 1) {
                max = Math.max(max, count);
                continue;
            }
            
            while (map[s.charAt(i)] > 1) {
                map[s.charAt(j)]--;
                count--;
                j++;
            }
            
            max = Math.max(max, count);
        }
       
        return max;
    }
}
