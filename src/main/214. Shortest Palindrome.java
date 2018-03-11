class Solution {
    public String shortestPalindrome(String s) {
       String t = s + "#" + new StringBuilder(s).reverse().toString();
       int k = KMP(t);
       return new StringBuilder(s.substring(k)).reverse().toString() + s;
    }

    private int KMP(String t) {
        int[] f = new int[t.length()];
        int i = 1, j = 0;
        while (i < f.length) {
            if (t.charAt(i) == t.charAt(j)) {
                f[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = f[j - 1];
            } else {
                f[i] = 0;
                i++;
            }
        }
        return f[t.length() - 1];
    }
}
