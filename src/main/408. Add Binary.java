public class Solution {
    /*
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
        if (a == null || b == null) {
            throw new RuntimeException();
        }
        int m = a.length() - 1;
        int n = b.length() - 1;

        int i, j;

        int[] ret = new int[Math.max(a.length(), b.length()) + 1];

        int idx = ret.length - 1, carry = 0;
        while (m >= 0 && n >= 0) {
            int tmp = a.charAt(m--) - '0' + b.charAt(n--) - '0' + carry;
            ret[idx--] = tmp%2;
            carry = tmp/2;
        }

        while (m >= 0) {
            int tmp = a.charAt(m--) - '0' + carry;
            ret[idx--] = tmp%2;
            carry = tmp/2;
        }

        while (n >= 0) {
            int tmp = b.charAt(n--) - '0' + carry;
            ret[idx--] = tmp%2;
            carry = tmp/2;
        }

        if (carry == 1) {
            ret[idx] = 1;
        }

        i = ret[0] == 1 ? 0 : 1;

        StringBuilder sb = new StringBuilder();
        for (; i < ret.length; i++) {
            sb.append(ret[i]);
        }
        String res = sb.toString();

        return res.equals("") ? "0" : res;
    }
}
