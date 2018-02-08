class Solution {
    public int longestSubstring(String s, int k) {
        //corner case
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        //use a cache to store the frequencies of this character
        int[] map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a'] ++;
        }
        String lessThanK = "";
        
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0 && map[i] < k) {
                lessThanK += ((char) (i + 'a'));
            }
        }
        
        if (lessThanK.equals("")) {
            return s.length();
        }
        
        for (char ch : lessThanK.toCharArray()) {
            s = s.replace(ch+"", " ");
        }
        String[] str = s.split("\\s+");
        
        int max = 0;
        for (String t : str) {
            max = Math.max(longestSubstring(t, k) , max);
        }
        
        return max;
    }
}
