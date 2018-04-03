class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-') continue;
            char cur = Character.toUpperCase(S.charAt(i));
            sb.append(cur);
            if (++idx == K) {
                sb.append('-');
                idx = 0;
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }//关键点！！！
        return sb.reverse().toString();
    }
}
