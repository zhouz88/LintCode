class Solution {
    public String getHint(String secret, String guess) {
        char[] t = secret.toCharArray();
        int[] map = new int[256];
        for (char ch : t) {
            map[ch]++;
        }
        int A = 0, B = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == t[i]) {
                A++;
                map[t[i]]--;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) != t[i]) {
                if (map[guess.charAt(i)] > 0) {
                    map[guess.charAt(i)]--;
                    B++;
                }
            }
        }
        return A + "A" + B + "B";
    }
}
