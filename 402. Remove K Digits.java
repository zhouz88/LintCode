class Solution {
    public String removeKdigits(String num, int k) {
        if (k == 0) {
            return num;
        }
        if (k >= num.length()) {
            return "0";
        }
        int len = num.length();
        int t = len - k;
        char[] stk = new char[len + 1];
        int idx = -1;
        for (int i = 0; i < num.length(); i++) {
            if(idx + 1 + len - i == t) {
                stk[++idx] = num.charAt(i);
            } else if (idx + 1 + len - i > t) {
                while (idx != -1 && idx + 1 + len - i > t && stk[idx] > num.charAt(i)) {
                    idx--;
                }
                if (idx + 1 < t) {
                    stk[++idx] = num.charAt(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i <= idx) {
            if (stk[i] == '0') {//bug 1
                i++;
            } else {
                break;
            }
        }
        for (; i <= idx; i++) {
            sb.append(stk[i]);
        }
        return sb.toString().equals("") ? "0" : sb.toString();
    }
}
