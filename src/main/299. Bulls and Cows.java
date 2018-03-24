class Solution {
    public String getHint(String secret, String guess) {
        int[] map = new int[128];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (map[secret.charAt(i)] < 0) {
                    cows++;
                }
                if (map[guess.charAt(i)] > 0) {
                    cows++;
                }
                map[secret.charAt(i)]++;
                map[guess.charAt(i)]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
