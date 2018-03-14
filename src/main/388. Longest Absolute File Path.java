import java.util.Stack;

class Solution {
    public int lengthLongestPath(String s) {
        String[] t = s.split("\n");
        Stack<String> stack = new Stack<>();
        int len = 0, max = 0;
        
        for (String k : t) {
            int total = getT(k);
            if (stack.isEmpty() || getT(stack.peek()) + 1 == total) {
                stack.add(k);
                len += k.length() - total;
                if (k.contains(".")) {
                    max = Math.max(max, len + stack.size() - 1);
                }
            } else if (getT(stack.peek()) >= total) {
                while (!stack.isEmpty() && getT(stack.peek()) >= total) { //wrong 1 so m any cases~
                    String tmp = stack.pop();
                    len -= tmp.length() - (getT(tmp));
                }
                stack.add(k);
                len += k.length() - total;
                if (k.contains(".")) {
                    max = Math.max(max, len + stack.size() - 1);
                }
            }
        }
        
        return max;
    }
    
    private int getT(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '\t') {
            i++;
        }
        return i;
    }
}

//
import java.util.Stack;

class Solution {
    public int lengthLongestPath(String input) {
        String[] t = input.split("\n");
        Stack<String> stk = new Stack<>();
        int max = 0;
        for (int i = 0; i < t.length; i++) {
            int o = cntOft(t[i]);
            if (stk.isEmpty()) {
                stk.add(t[i]);
                if (t[i].contains(".")) {
                    max = Math.max(max, len(stk));
                }
            } else if (o > cntOft(stk.peek())) {
                stk.add(t[i]);
                if (t[i].contains(".")) {
                    max = Math.max(max, len(stk));
                }
            } else if (cntOft(stk.peek()) >= o){
                while (!stk.isEmpty() && cntOft(stk.peek()) >= o) {
                    stk.pop();
                }
                stk.add(t[i]);
                if (t[i].contains(".")) {
                    max = Math.max(max, len(stk));
                }
            }
        }
        return max;
    }

    private int len(Stack<String> stk) {
        int sum = 0;
        for (int i = 0; i < stk.size(); i++) {
            sum += stk.get(i).length() - cntOft(stk.get(i));
        }
        return sum + stk.size() - 1;
    }

    private int cntOft(String t) {
        return t.lastIndexOf("\t") + 1;
    }
}
