class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] ret = new int[m + n + 1];
        int i ,  j;
        for (i = 0; i < num1.length(); i++) {
            for (j = 0; j < num2.length(); j++) {
                ret[m - i - 1 + n - j - 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');//wrong1
            }
        }
        for (i = 0; i < ret.length - 1; i++) {
            ret[i + 1] += ret[i]/10;
            ret[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        int k = ret.length - 1;
        while (k >= 0&&ret[k] == 0) {
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
//
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n + 1];
        char[] s = num1.toCharArray();
        char[] t = num2.toCharArray();
        int i , j;
        
        for (i = m - 1; i >= 0; i--) {
            for (j = n - 1; j >= 0; j--) {
                res[m - 1 - i + n - 1 - j] += (s[i] - '0') * (t[j] - '0');
            }
        }
        
        for (i = 0; i < res.length - 1; i++) {
            res[i + 1] += res[i]/10;
            res[i] = res[i]%10;
        }
        
        for (i = res.length - 1; i >= 0; i--) {
            if (res[i] != 0) {
                break;
            }
        }
        
        if (i == -1) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (i >= 0) {
            sb.append(res[i]);
            i--;
        }
        return sb.toString();
    }
}
