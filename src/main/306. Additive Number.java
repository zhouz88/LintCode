import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, new Stack<>());
    }

    private boolean dfs(String num, int start, Stack<BigInteger> stk) {
        if (start == num.length() && stk.size() >= 3) {
            return true;
        } else if (start == num.length()) {
            return false;
        }

        boolean found = false;

        for (int i = start; i < num.length(); i++) {
            String tmp = num.substring(start, i + 1);
            if (tmp.charAt(0) == '0' && tmp.length() > 1) {
                break;
            }
            if (stk.size() >= 2) {
                BigInteger a = stk.get(stk.size() - 2);
                BigInteger b = stk.get(stk.size() - 1);
                BigInteger c = new BigInteger(tmp);
                if (a.add(b).equals(c)) {
                    stk.add(c);
                    found |= dfs(num,i + 1, stk);
                    stk.pop();
                    if (found) return true;
                }
            } else {
                stk.add(new BigInteger(tmp));
                found |= dfs(num, i + 1, stk);
                stk.pop();
            }
        }
        return found;
    }
}
