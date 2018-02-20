class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        
        if (needle.length() == 0) {
            return 0;
        }
        
        for (int i = 0; i <= haystack.length() - needle.length() ; i++) {
            int l = i;
            int r = 0;
            
            while (true) {
                if (haystack.charAt(l) == needle.charAt(r)) {
                    l++;
                    r++;
                    if (r == needle.length()) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
                        
        return -1;
    }
}
