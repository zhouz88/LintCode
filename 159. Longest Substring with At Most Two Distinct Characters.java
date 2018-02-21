159. Longest Substring with At Most Two Distinct Charactersclass Solution {
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
