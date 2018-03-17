class Solution {
    public String reverseStr(String s, int k) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (idx < k) {
                sb.insert(i - idx, ch);
            } else if (idx < 2 * k) {
                sb.append(ch);
            } 
            idx++;
            if (idx == 2 * k) {
                idx = 0;
            }
        }
        return sb.toString();
    }
}
