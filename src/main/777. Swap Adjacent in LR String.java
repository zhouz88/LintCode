class Solution {
    public boolean canTransform(String start, String end) {
        int i = 0, j = 0;
        while (true) {
            while (i < start.length() && start.charAt(i) == 'X') {
                i++;
            }
            while (j < end.length() && end.charAt(j) == 'X') {
                j++;
            }
            if (i == start.length() && j == end.length()) {
                return true;
            }
            if (i == start.length() || j == end.length()) {
                return false;
            }
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            if (start.charAt(i) == 'R' && j < i) {
                return false;
            }
            i++;
            j++;
        }
    }
}

class Solution {
    public boolean canTransform(String start, String end) {
       int l = 0, r = 0;
       if (start.length() != end.length()) return false;
       while (true) {
           while (l < start.length() && !isLorR(start.charAt(l))) {
               l++;
           }
           while (r < end.length() && !isLorR(end.charAt(r))) {
               r++;
           }
           if (l == start.length() && r == start.length()) return true;
           if (l == start.length() || r == start.length()) return false;
           if (start.charAt(l) != end.charAt(r)) return false;
           if (start.charAt(l) == 'L' && l < r) return false;
           if (start.charAt(l) == 'R' && l > r) return false;
           l++;
           r++;
       }
    }
    
    private boolean isLorR(char ch) {
        return ch == 'L' || ch == 'R';
    }
}
