class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] ret = new int[m + n + 1];
        int i ,  j;
        for (i = 0; i < num1.length(); i++) {
            for (j = 0; j < num2.length(); j++) {
                ret[m - i - 1 + n - j - 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (i = 0; i < ret.length - 1; i++) {
            ret[i + 1] += ret[i]/10;
            ret[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        int k = ret.length - 1;
        while (k >= 0 && ret[k] == 0) {
            k--;
        }
        if (k == -1) {
            return "0";
        }
        for (i = k; i >= 0; i--) {
            sb.append(ret[i]);
        }
        return  sb.toString();
    }
}
