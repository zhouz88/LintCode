import java.util.Stack;

class Solution {
    //s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
    public String decodeString(String s) {
        Stack<Object> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                stk.add(s.charAt(i) + "");
            } else if (Character.isDigit(s.charAt(i))) {
                int tmp = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    tmp = 10 * tmp + s.charAt(++i) - '0';
                }
                stk.add(tmp);
            } else if (s.charAt(i) == '[') {
                stk.add("[");
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stk.peek().equals("[")) {
                    sb.insert(0, stk.pop());
                }
                StringBuilder sn = new StringBuilder();
                stk.pop();
                int k = (Integer)stk.pop();
                while (k != 0) {
                    sn.append(sb);
                    k--;
                }
                stk.add(sn.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < stk.size(); i++) {
            res.append(stk.get(i));
        }
        return res.toString();
    }
}
