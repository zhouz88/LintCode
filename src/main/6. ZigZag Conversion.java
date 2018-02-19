class Solution {
    public String convert(String s, int m) {
         //edge case
        if (m <= 1) {
            return s;
        }
        //general s.length() > 2;
        int n = 2 * m - 2;
        
        int j;
        StringBuilder[] strs = new StringBuilder[m];
        
        for (int i = 0; i < strs.length; i++) {
            strs[i] = new StringBuilder();
        }
        int len = s.length();
        
        for (int i = 0; i < len; i += n) {
            for (j = i; j < Math.min(m + i, len); j++) {
                strs[j - i].append(s.charAt(j)); //wrong 1 j not i
            }
            int index = m - 2;
            for (j = i + m; j < Math.min(n + i, len); j++) {
                strs[index--].append(s.charAt(j));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (StringBuilder k:  strs) {
            sb.append(k);
        }
        return sb.toString();
    }
}
