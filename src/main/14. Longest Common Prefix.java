import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        String can = strs[0];
        int i = 0, j;
        while (i < can.length()) {
            if (check(strs, i, can.charAt(i))) {
                i++;
            } else {
                break;
            }
        }
        return can.substring(0, i);
    }

    private boolean check(String[] strs, int k, char c) {
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].charAt(k) != c) {
                return false;
            }
        }
        return true;
    }
}
