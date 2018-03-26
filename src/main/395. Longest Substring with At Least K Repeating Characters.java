class Solution {
    public int longestSubstring(String s, int k) {
        int max = 0;
        for (int i = 1; i <= 26; i++) {
            max = Math.max(helper(s, k, i), max);
        }
        return max;
    }

    private int helper(String s, int k, int number) {
        int j = 0;
        int count = 0;
        int max = 0;
        int[] map = new int[128];
        int okCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]++ == 0) {
                count++;
            }
            if (map[s.charAt(i)] == k) {
                okCount++;
            }
            while (count > number && j <= i) {
                map[s.charAt(j)]--;
                if (map[s.charAt(j)] == 0) {
                    count--;
                }
                if (map[s.charAt(j)] == k - 1) {
                    okCount--;
                }
                j++;
            }
            if (okCount == number) {
               max = Math.max(max, i - j + 1);
            }
        }
        return max;
    }
}
