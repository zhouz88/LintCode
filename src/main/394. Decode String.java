import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                sb = new StringBuilder();
                while (!stack.peek().equals("[")) {// wrong 1
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                int tmp = 0;
                String num = "";
                while (!stack.isEmpty() && isD(stack.peek())) {
                    num = stack.pop() + num;
                }
                tmp = num.equals("") ? 1: Integer.parseInt(num);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < tmp; i ++ ) {
                    stringBuilder.append(sb.toString());
                }
                stack.add(stringBuilder.toString());
            } else {
                stack.add(ch+"");
            }
        }
        String res = "";//wrong 2
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    private boolean isD(String ch) {
        return ch.charAt(0) >= '0' && ch.charAt(0) <= '9';
    }
}
