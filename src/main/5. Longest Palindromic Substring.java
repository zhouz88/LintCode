class Solution {
    public String longestPalindrome(String s) {
        //corner case
        if (s == null || s.length() == 0) {
            return "";
        }
        int ret = 1;
        int end = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = extends1(i, s);
            int b = extends2(i, s);
            if (a > ret) {
                start = i - a/2;
                end = i + a/2;
                ret = a; //wrong 1
            }
            if (b > ret) {
                start = i - b/2 + 1;
                end = i + b/2;
                ret = b;
            }
        }
        
        return s.substring(start, end + 1);
    }

    private int extends1(int start, String s) {
        int i = start, j = start;
        int total = 1;
        while (i - 1 >= 0 && j + 1 < s.length() && s.charAt(i - 1) == s.charAt(j + 1)) {
            i--;
            j++;
            total += 2;
        }
        return total;
    }

    private int extends2(int start, String s) {
        int i = start, j = start + 1;
        if (j == s.length() || s.charAt(i) != s.charAt(j)) {
            return 0;
        }
        int total = 2;
        while (i - 1 >= 0 && j + 1 < s.length() && s.charAt(i - 1) == s.charAt(j + 1)) {
            i--;
            j++;
            total += 2;
        }
        return total;
    }
}
