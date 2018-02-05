

import java.util.*;

public class Solution {
    /**
     * @param s: The input string
     * @return: all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        if (s == null) {
            return new ArrayList<>();
        }
        // Write your code here
        Queue<String> q = new ArrayDeque<>();
        q.add(s);
        Set<String> set = new HashSet<>();
        set.add(s);
        boolean flag = false;
        List<String> ret = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String node = q.poll();
                if (check(node)) {
                    flag = true;
                    ret.add(node);
                }
                for (int u = 0; u < node.length(); u++) {
                    if (node.charAt(u) != '(' && node.charAt(u) != ')') continue;
                    String tmp = node.substring(0, u) + node.substring(u + 1);
                    if (set.add(tmp)) {
                        q.add(tmp);
                    }
                }
            }
            if (flag) break;
        }
        
        return ret;
    }

    private boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != '(' && ch != ')') {
                continue;
            }
            if (ch == '(') {
                stack.add(')');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
