import java.util.ArrayDeque;

class Solution {
    public int calculate(String s) {
        //Object Integer Character '+' '-', '*', '/', '('
        ArrayDeque<Object> stk = new ArrayDeque<>();
        char[] t = ("(" + s + ")").toCharArray();
        for (int i = 0; i < t.length; i++) {
            switch (t[i]) {
                case '(':
                case '+':
                case '-':
                case '*':
                case '/':
                    stk.addLast(t[i]);
                    break;
                case ' ':
                    break;
                case ')':
                    int sum = 0;
                    while (!stk.peekLast().equals('(')) {
                       sum += (int) stk.pollLast();
                    }
                    stk.pollLast();
                    stk.addLast(mergeValueToStack(stk, sum));
                    break;
                default: //Int
                    int temp = t[i] - '0';
                    while (i + 1< t.length && Character.isDigit(t[i + 1])) {
                        temp = 10 * temp + t[++i] - '0';
                    }
                    stk.add(mergeValueToStack(stk, temp));
            }
        }
        return (int) stk.poll();
    }

    private int mergeValueToStack(ArrayDeque<Object> stk, int temp) {
        if (!stk.isEmpty()) {
            if (stk.peekLast().equals('+')) {
                stk.pollLast();
                return temp;
            } else if (stk.peekLast().equals('-')) {
                stk.pollLast();
                return -temp;
            } else if (stk.peekLast().equals('*')) {
                stk.pollLast();
                int first = (int) stk.pollLast();
                return first * temp;
            } else if (stk.peekLast().equals('/')) {
                stk.pollLast();
                int first = (int) stk.pollLast();
                return first / temp;
            }
        }
        return temp;
    }
}
