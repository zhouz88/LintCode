class Solution {
    public boolean isSubsequence(String s, String t) {
        //corner case ????????
        if (t == null || s == null) {
            return false;
        }
        if (s.length() == 0 && s.length() == 0) {
            return true;
        }
        
        int l = 0, r = 0;
        while (l != t.length()) {
            if (t.charAt(l) == s.charAt(r)) {
                l++;
                r++;
                if (r == s.length()) {
                    return true;
                }
            } else {
                l++;
            }
        }
        return false;
    }
}
