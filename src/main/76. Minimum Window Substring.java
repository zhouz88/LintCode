class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) 
            return "";   
        int[] map = new int[256];
        int[] window = new int[256];
        int start = 0, end = 0, min = Integer.MAX_VALUE;
        for (char ch : t.toCharArray())
            map[ch]++;
        
        for (int i = 0, j = 0, cnt = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 0) continue;
            if (window[s.charAt(i)]++ < map[s.charAt(i)]) {
                 cnt++;
            }
            while (cnt == t.length() && j <= i) {
                if (i - j + 1 < min) {
                    start = j;
                    end = i;
                    min = i - j + 1;
                }
                if (map[s.charAt(j)] == 0) {
                    j++;
                    continue;
                }
                if (window[s.charAt(j)]-- == map[s.charAt(j)])
                     cnt--;
                j++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
    }
}
