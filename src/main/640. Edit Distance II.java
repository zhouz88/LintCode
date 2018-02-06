public class Solution {
    /*
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        if (s == null || t == null ) {
            return false;
        }
        int distance = Math.abs(s.length() - t.length());
        
        switch (distance) {
            case 0:
                int cnt = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != t.charAt(i)) {
                        cnt++;
                        if (cnt > 1) {
                            return false;
                        }
                    }
                }
                return cnt == 1;
            case 1 :
                for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
                    if (s.charAt(i) != t.charAt(i)) {
                        if (s.length() > t.length()) {
                            return s.substring(i + 1).equals(t.substring(i));
                        } else {
                            return t.substring(i + 1).equals(s.substring(i));
                        }
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
