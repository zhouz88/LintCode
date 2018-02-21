class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //edge case
        if (k <= 0 || s.length() == 0) {
            return 0;
        }
        
        //general
        int[] window = new int[256];
        int cnt = 0;//to record the number of distinct char;
        int j = 0, i;
        int max = 0;
        
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (window[ch]++ == 0) {
                cnt++;
            }
            while (cnt > k && j <= i) {
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
