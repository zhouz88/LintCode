class Solution {
    public boolean isOneEditDistance(String s, String t) {
       if (s == null || t == null) {
           return false;
       }
       int m = s.length(), n = t.length();
       if (Math.abs(m - n) > 1) return false;
       if (m == n) {
           for (int i = 0; i < t.length(); i++) {
               if (t.charAt(i) != s.charAt(i)) {
                   return t.substring(i + 1).equals(s.substring(i + 1));
               }
           }
           return false;
       } else {
           String tmp = s;
           if (m < n) {
                s = t;
                t = tmp;
           }
           for (int i = 0; i < t.length(); i++) {
               if (t.charAt(i) != s.charAt(i)) {
                   return t.substring(i).equals(s.substring(i + 1));
               }
           }
           return true;
       }
    }

}
