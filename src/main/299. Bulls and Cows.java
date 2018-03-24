class Solution {
    public String getHint(String secret, String guess) {
        int[] sMap = new int[256];
        int[] gMap = new int[256];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                sMap[secret.charAt(i)]++;
                gMap[guess.charAt(i)]++;
            }
        }
        for (int i = 0; i < 256; i++) {
            cows += Math.min(sMap[i], gMap[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
