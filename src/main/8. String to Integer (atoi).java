class Solution {
    public int myAtoi(String str) {
        int i = 0;
        long tmp = 0;
        int sign = 1;
        while (i < str.length() && str.charAt(i) == ' ') {
            i ++;
        }
        if (i == str.length()) {
            return 0;
        }
        
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+' ) {
            i++;
        }
            
        if (i == str.length() || !D(str.charAt(i))) {
            return 0;
        }
        tmp = str.charAt(i) - '0';
        while (i + 1 < str.length() && D(str.charAt(i + 1))) {
            tmp = 10*tmp + str.charAt(++i) - '0';
            if (sign*tmp > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign*tmp < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        tmp = sign*tmp;
        if (tmp > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (tmp < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int)tmp;
    }

    private boolean D(char ch) {
        return ch >= '0' && ch <= '9'; //wrong 1
    }
}
