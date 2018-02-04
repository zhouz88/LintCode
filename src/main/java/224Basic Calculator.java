import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int i, sum = 0;
        char sign = '+';
        stack.add(1);
        for (i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '+':
                    sign = '+';
                    break;
                case '-':
                    sign = '-';
                    break;
                case ' ':
                    break;
                case '(':
                    int t = sign == '+' ? 1 : -1;
                    stack.add(stack.peek()*t);
                    break;
                case ')':
                    stack.pop();
                    break;
                default:
                    int tmp = s.charAt(i) - '0';
                    if (i > 0 && s.charAt(i - 1) == '(') {
                        sign = '+';
                    }
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        tmp = 10 * tmp + s.charAt(++i) - '0';
                    }
                    sum += stack.peek() * tmp * (sign == '+' ? 1 : -1);
                    break;
            }
        }
        return sum;
    }
}
