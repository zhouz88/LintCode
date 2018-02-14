class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[256];
        for (char ch : s.toCharArray()) {
            map[ch]++;
        }
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                if ((map[i] & 1) == 1) {
                    cnt++;
                } 
            }
        }
        return cnt <= 1;
    }
}
