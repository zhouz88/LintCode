class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int j, i = 0;
        StringBuilder sb = new StringBuilder();
        for (j = S.length() - 1; j >= 0; j--) {
            if (S.charAt(j) == '-') {
                continue;
            }
            sb.append(Character.toUpperCase(S.charAt(j)));
            i++;
            if (i == K) {
                sb.append('-');
                i = 0;
            } 
        }
        if (sb.length() == 0) { //bug 1
            return sb.toString();
        }
        if (sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
