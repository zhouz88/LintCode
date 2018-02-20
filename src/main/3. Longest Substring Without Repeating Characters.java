class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        
        if (s.length() == 0) {
            return 0;
        }
        
        int[] window = new int[256];
        int j = 0;
        int max = 1;
        
        for (int i = 0; i < s.length(); i++) {
            window[s.charAt(i)]++;
            if (window[s.charAt(i)] == 1) {
                max = Math.max(i - j + 1, max);
            } else {
                while (window[s.charAt(i)] > 1 && j <= i) {
                    window[s.charAt(j)]--;
                    j++;
                }
            }
        }
        return max;
    }
}
