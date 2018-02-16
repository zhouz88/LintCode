class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder ret = new StringBuilder();
        int pre = 0;

        for (int i = 0; i < s.length(); i++) {
            int row = i/(2*k);
            int col = (i%(2*k))/k;

            if (row == pre) {
                if (col == 0) sb.insert(0, s.charAt(i));
                else sb.append(s.charAt(i));
            } else {
                ret.append(sb.toString());
                pre++;
                sb.setLength(0);
                if (col == 0) sb.insert(0, s.charAt(i));
                else sb.append(s.charAt(i));
            }
        }

        ret.append(sb);

        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefghijklmnopqrst", 3));
    }
}
