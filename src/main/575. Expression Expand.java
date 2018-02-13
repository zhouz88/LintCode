public class Solution {
    /*
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        Stack<Object> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isD(s.charAt(i))) {
                int tmp = s.charAt(i) - '0';
                while (i + 1 < s.length() && isD(s.charAt(i+1))) {
                    tmp = tmp*10 + s.charAt(++i) - '0';
                }
                stack.add((Integer)tmp);
            } else if (isL(s.charAt(i))) {
                stack.add(""+s.charAt(i));
            } else if (s.charAt(i) == '[') {
                stack.add("[");
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    Object t = stack.pop();
                    sb.insert(0, (String)t);
                }
                stack.pop();
                Integer t = (Integer) stack.pop();
                StringBuilder sb1 = new StringBuilder();
                while (t != 0) {
                    sb1.append(sb.toString());
                    t--;
                }
                stack.add(sb1.toString());
            }
        }
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
    
    boolean isD(char ch) {
        return ch >= '0' && ch <= '9';
    }
    
    boolean isL(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
