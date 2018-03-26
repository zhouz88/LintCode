class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) 
            return "";
        int min = Integer.MAX_VALUE, start = 0;
        int[] map = new int[256];
        for (char ch : t.toCharArray()) {
            map[ch]++;
        }
        for (int i = 0, cnt = t.length(), j = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]-- > 0) {
                cnt--;
            }
            while (cnt == 0 && j <= i) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    start = j;
                }
                if (++map[s.charAt(j++)] > 0) {
                    cnt++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
