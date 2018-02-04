class Solution {
//https://leetcode.com/problems/basic-calculator-ii/description/
    public int calculate(String s) {
        int i;
        char sign = '+';
        int sum = 0, pre = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-'  || s.charAt(i) == '*' || s.charAt(i) == '/' ) {
                sign = s.charAt(i);
            } else if (Character.isDigit(s.charAt(i))) {
                int tmp = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    tmp = tmp * 10 + s.charAt(++i) - '0';
                }
                switch(sign) {
                    case '*':
                        pre *= tmp;
                        break;
                    case '/':
                        pre /= tmp;
                        break;
                    case '+':
                        sum += tmp;
                        pre = 1;
                        break;
                    case '-':
                        sum -= tmp;
                        pre = -1;
                        break;
                }
            }
        }
        return sum;
    }

}
