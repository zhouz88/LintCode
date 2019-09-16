class Solution {
    public int calculate(String s) {
        // Integer, char '(', char '+', char '-';
        ArrayDeque<Object> stk = new ArrayDeque<>();
        char[] t = ("(" + s + ")").toCharArray();
        for (int i = 0; i < t.length; i++) {
            switch (t[i]) {
                case ' ':
                    break;
                case '+':
                case '-':
                case '(':
                    stk.add(t[i]);
                    break;
                case ')':
                    int sum = 0;
                    while (!stk.peekLast().equals('(')) {
                        sum += (int) stk.pollLast();
                    }
                    stk.pollLast();
                    stk.add(getPossibleSign(stk, sum));
                    break;
                default:
                    int temp = t[i] - '0';
                    while (i + 1 < t.length && Character.isDigit(t[i + 1])) {
                        temp = 10 * temp + t[++i] - '0';
                    }
                    stk.add(getPossibleSign(stk, temp));
            }
        }
        return (int) stk.pollLast();
    }

    private int getPossibleSign(ArrayDeque<Object> dq, int temp) {
        if (!dq.isEmpty() && (dq.peekLast().equals('+') || dq.peekLast().equals('-'))) {
            char ch = (char) dq.pollLast();
            temp = (ch == '+' ? temp : -temp);
        }
        return temp;
    }
}
