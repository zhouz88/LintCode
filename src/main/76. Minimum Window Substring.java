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
                if (i - j + 1 < max) {
                    ret = s.substring(j, i + 1);
                    max = i - j + 1;
                }
                char tmp = s.charAt(j);
                if (window[tmp]-- == tMap[tmp]) {
                    cnt--;
                }
                j++;
            }
        }
        
        return ret;
    }
}
