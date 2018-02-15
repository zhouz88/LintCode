class Solution {
    public boolean isOneEditDistance(String s, String t) {
       if (Math.abs(s.length() - t.length()) > 1) {
           return false;
       }
       int cnt = 0;
       if (s.length() == t.length()) {
           for (int i = 0; i < t.length(); i++) {
               if (t.charAt(i) != s.charAt(i)) {
                   cnt++;
                   if (cnt > 1) {
                       return false;
                   }
               }
           }
           return cnt == 1;
       } else {
           String tmp = s;
           if (t.length() > tmp.length()) {
               s = t;
               t = tmp;
           }
           int i = 0;
           int j = 0;
           while (i < s.length() && j < t.length()) {
               if (s.charAt(i) != t.charAt(j)) {
                   cnt++;
                   if (cnt == 2) {
                       return false;
                   }
                   i++;
               } else {
                   j++;
                   i++;
               }
           }
           if (j == t.length()) {
               return true;
           }
           return cnt == 1;
       }
    }
}
