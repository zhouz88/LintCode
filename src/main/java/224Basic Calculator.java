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

import java.util.ArrayDeque;

class Solution {
    public int calculate(String s) {
        int sum = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addLast(1);
        int sign = 1;
        char[] t = s.toCharArray();
        for (int i = 0; i < t.length; i++) {
            if (t[i] == ' ') {
                continue;
            } else if (Character.isDigit(t[i])) {
                int j = i - 1;
                while (j >= 0 && t[j] == ' ') {
                    j--;
                }
                if (j >= 0 && t[j] == '(') {
                    sign = 1;
                }
                int temp = t[i] - '0';
                while (i + 1 < t.length && Character.isDigit(t[i + 1])) {
                    temp = 10 * temp + t[++i] - '0';
                }
                sum += dq.peekLast() * sign * temp;
            } else if (t[i] == '+') {
                sign = 1;
            } else if (t[i] == '-') {
                sign = -1;
            } else if (t[i] == '(') {
                dq.add(dq.peekLast() * sign);
            } else {
                dq.pollLast();
            }
        }
        return sum;
    }
}
