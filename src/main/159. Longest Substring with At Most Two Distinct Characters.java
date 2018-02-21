class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) {
            return s.length();
        }
        int[] window = new int[256];
        int cnt = 0, j = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (window[ch]++ == 0) {
                cnt++;
            }
            while (cnt > 2 && j <= i) {
                char tmp = s.charAt(j);
                if (--window[tmp] == 0) {
                    cnt--;
                }
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
/*

159. Longest Substring with At Most Two Distinct Characters
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.

76. Minimum Window Substring
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.



*/

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        int j = 0;
        int[] window = new int[256];
        int[] tMap = new int[256];
        for (char ch : t.toCharArray()) {
            tMap[ch]++;
        }
        String ret = "";
        int cnt = 0, max = 999999999;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (window[ch]++ < tMap[ch]) {
                cnt++;
            } 
            while (cnt == t.length() && j <= i) {
                char tmp = s.charAt(j);
                if (i - j + 1 < max) {
                    ret = s.substring(j, i + 1);
                    max = i - j + 1;
                }
                if (window[tmp]-- == tMap[tmp]) {
                    cnt--;
                }
                j++;
            }
        }
        
        return ret;
    }
}
