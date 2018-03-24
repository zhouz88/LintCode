import java.math.BigInteger;
import java.util.Stack;

class Solution {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, new Stack<>());
    }

    private boolean dfs(String s, int start, Stack<BigInteger> stack) {
        if (start == s.length() && stack.size() >= 3) {
            return true;
        } else if (start == s.length()) {
            return false;
        }
        
        for (int i = start; i < s.length(); i++) {
            String tmp = s.substring(start, i + 1);
            if (i > start && s.charAt(start) == '0') {
                break;
            }
            BigInteger c = new BigInteger(tmp);
            if (stack.size() <= 1) {
                stack.add(c);
                if (dfs(s, i + 1, stack)) {
                    return true;
                } else {
                    stack.pop();
                }
            } else {
                BigInteger first = stack.get(stack.size() - 2);
                BigInteger second = stack.peek();
                if ((first.add(second)).equals(c)) {
                    stack.add(c);
                    if (dfs(s, i + 1, stack)) {
                        return true;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        
        return false;
    }
}
