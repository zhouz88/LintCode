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
